package org.greenwin.VLCampaign.controllers;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;
import org.greenwin.VLCampaign.services.impl.CampaignService;
import org.greenwin.VLCampaign.services.impl.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/options")
public class OptionController {

    @Autowired
    OptionService optionService;

    @Autowired
    CampaignService campaignService;

    @GetMapping("/id/{id}")
    public Option getOptionById(@PathVariable ("id") int id){
        return optionService.getOptionById(id);
    }

    @GetMapping("/campaign/{campaign_id}")
    public List<Option> getAllByCampaignId(@PathVariable("campaign_id") int campaignId){
        Campaign campaign = campaignService.findById(campaignId);
        return optionService.getAllByCampaign(campaign);

    }
}
