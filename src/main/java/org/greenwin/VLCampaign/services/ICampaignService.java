package org.greenwin.VLCampaign.services;

import org.greenwin.VLCampaign.model.Campaign;

import java.util.List;

public interface ICampaignService {

    Campaign addCampaign(Campaign campaign);
    Campaign findById(int id);
    List<Campaign> getnMostRecent(int n);
    List<Campaign> getnMostPopular(int n);
}
