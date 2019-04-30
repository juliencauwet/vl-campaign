package org.greenwin.VLCampaign.controllers;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.services.impl.CampaignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CampaignService campaignService;

    /**
     * add a campaign
     * @param campaign
     * @return campaign created
     */
    @PostMapping("/")
    public Campaign addCampaign(@RequestBody Campaign campaign){
        logger.info("### addCampaign method ###");
        return campaignService.addCampaign(campaign);
    }

    /**
     * get a campaign by its id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public  Campaign getCampaignById(@PathVariable ("id") int id){
        logger.info("### getCampaignById method ###");
        return campaignService.findById(id);
    }

    @GetMapping("/recent")
    public List<Campaign> getMostRecentCampaigns(){
        logger.info("### getMostRecentCampaigns method ###");
        return campaignService.getnMostRecent(3);
    }


}
