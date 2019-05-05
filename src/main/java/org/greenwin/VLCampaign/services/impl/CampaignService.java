package org.greenwin.VLCampaign.services.impl;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.repository.CampaignRepository;
import org.greenwin.VLCampaign.services.ICampaignService;
import org.greenwin.VLCampaign.utils.CampaignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CampaignService implements ICampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private OptionService optionService;

    @Autowired
    private CampaignUtil campaignUtil;

    public Campaign addCampaign(Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public Campaign findById(int id){
        Campaign campaign = campaignRepository.findById(id);
        campaignUtil.fillWithTopic(campaign);
        return campaign;
    }

    /**
     *
     * @param n
     * @return n most recent campaigns
     */
    public List<Campaign> getnMostRecent(int n){

        List<Campaign> allCampaigns = new ArrayList<>();
        List<Campaign> toDisplay = new ArrayList<>();
        campaignRepository.findAllByOrderByStartDateDesc().forEach(allCampaigns :: add);

        for (int i = 0; i < n; i++)
            toDisplay.add(allCampaigns.get(i));

        for (Campaign campaign : toDisplay
             ) {
            campaign.setOptions(optionService.getAllByCampaign(campaign));
            campaignUtil.fillWithTopic(campaign);
        }
        return toDisplay;
    }

    /**
     *
     * @param n
     * @return n most popular campaigns
     */
    @Override
    public List<Campaign> getnMostPopular(int n) {
        List<Campaign> allCampaigns = new ArrayList<>();
        List<Campaign> toDisplay = new ArrayList<>();
        campaignRepository.findAll().forEach(allCampaigns :: add);

        for (int i = 0; i < n; i++)
            toDisplay.add(allCampaigns.get(i));

        return toDisplay;
    }


}
