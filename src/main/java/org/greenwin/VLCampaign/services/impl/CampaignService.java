package org.greenwin.VLCampaign.services.impl;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.repository.CampaignRepository;
import org.greenwin.VLCampaign.services.ICampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class CampaignService implements ICampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    public Campaign addCampaign(Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public Campaign findById(int id){
        return campaignRepository.findById(id);
    }

    public List<Campaign> getnMostRecent(int n){

        List<Campaign> allCampaigns = new ArrayList<>();
        List<Campaign> toDisplay = new ArrayList<>();
        campaignRepository.findAllByOrderByStartDateDesc().forEach(allCampaigns :: add);

        for (int i = 0; i < n; i++)
            toDisplay.add(allCampaigns.get(i));

        return toDisplay;
    }

}
