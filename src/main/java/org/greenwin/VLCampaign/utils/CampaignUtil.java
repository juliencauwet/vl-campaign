package org.greenwin.VLCampaign.utils;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.proxies.TopicProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CampaignUtil {

    @Autowired
    private TopicProxy topicProxy;

    public void fillWithTopic(Campaign campaign){
        campaign.setTopic(topicProxy.getTopicById(campaign.getTopicId()));
    }
}
