package org.greenwin.VLCampaign.services;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    public Campaign addCampaign(Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public Campaign findById(int id){
        return campaignRepository.findById(id);
    }
}
