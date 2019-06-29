package org.greenwin.VLCampaign.controllers;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;
import org.greenwin.VLCampaign.services.impl.CampaignService;
import org.greenwin.VLCampaign.services.impl.OptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/options")
@CrossOrigin(origins = "http://localhost:4200")
public class OptionController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    OptionService optionService;

    @Autowired
    CampaignService campaignService;

    @GetMapping("/id/{id}")
    public Option getOptionById(@PathVariable ("id") int id){
        logger.info("### getOptionById ###");
        return optionService.getOptionById(id);
    }

    @GetMapping("/campaign/{campaign_id}")
    public List<Option> getAllByCampaignId(@PathVariable("campaign_id") int campaignId){
        logger.info("### getAllByCampaignId method ###");
        Campaign campaign = campaignService.findById(campaignId);
        return optionService.getAllByCampaign(campaign);
    }

    @PostMapping("/")
    public Option saveOption(@RequestBody Option option){
        logger.info("### saveOption method ###");
        return optionService.saveOption(option);
    }
}
