package org.greenwin.VLCampaign.services.impl;

import com.netflix.discovery.converters.Auto;
import org.apache.tomcat.jni.Local;
import org.greenwin.VLCampaign.beans.Topic;
import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.proxies.TopicProxy;
import org.greenwin.VLCampaign.repository.CampaignRepository;
import org.greenwin.VLCampaign.services.ICampaignService;
import org.greenwin.VLCampaign.utils.CampaignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class CampaignService implements ICampaignService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private TopicProxy topicProxy;

    @Autowired
    private CampaignUtil campaignUtil;



    public Campaign addCampaign(Campaign campaign){
        logger.info("### addCampaign method ###");
        return campaignRepository.save(campaign);
    }

    public Campaign findById(int id){
        logger.info("### findById method ###");
        logger.info("id: " + id );
        Campaign campaign = campaignRepository.findById(id);
        logger.info("campaign: " + campaign);
        campaignUtil.fillWithTopic(campaign);
        return campaign;
    }

    /**
     *
     * @param n
     * @return n most recent campaigns
     */
    public List<Campaign> getnMostRecent(int n){
        logger.info("### getMostRecent method ###");
        List<Campaign> allCampaigns = new ArrayList<>();
        List<Campaign> toDisplay = new ArrayList<>();
        campaignRepository.findAllByOrderByStartDateDesc().forEach(allCampaigns :: add);

        for (int i = 0; i < n; i++)
            toDisplay.add(allCampaigns.get(i));
        return toDisplay;
    }

    /**
     *
     * @param n
     * @return n most popular campaigns
     */
    @Override
    public List<Campaign> getnMostPopular(int n) {
        logger.info("### getMostPopular method ###");
        List<Campaign> allCampaigns = new ArrayList<>();
        List<Campaign> toDisplay = new ArrayList<>();
        campaignRepository.findAll().forEach(allCampaigns :: add);

        for (int i = 0; i < n; i++)
            toDisplay.add(allCampaigns.get(i));

        return toDisplay;
    }

    /**
     *
     * @param campaign
     * @return
     */
    public Campaign updateCampaign(Campaign campaign){
        logger.info("### updateCampaign method ###");
        return campaignRepository.save(campaign);
    }

    public List<Campaign> selectCampaigns(LocalDate start, LocalDate end, String keyword){
        List<Campaign> campaigns = campaignRepository.findByStartDateAfterAndEndDateBefore(start, end);
        List<Campaign> selectedCampaigns = new ArrayList<>();
        List<Topic> topics = topicProxy.getTopicsByKeyWord(keyword);

        for (Campaign campaign : campaigns){
            campaign.setTopic(topicProxy.getTopicById(campaign.getTopicId()));
            if(campaign.getTopic().getSummary().contains(keyword))
                selectedCampaigns.add(campaign);
        }
        return selectedCampaigns;
    }



}
