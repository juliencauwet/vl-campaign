package org.greenwin.VLCampaign.utils;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.proxies.TopicProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CampaignUtil {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TopicProxy topicProxy;

    public void fillWithTopic(Campaign campaign){
        logger.info("campaign: " + campaign.getId() + " topicId: " + campaign.getTopicId());
        campaign.setTopic(topicProxy.getTopicById(campaign.getTopicId()));
    }
}
