package org.greenwin.VLCampaign.controllers;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.services.impl.CampaignService;
import org.greenwin.VLCampaign.services.impl.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private VoteService voteService;

    /**
     * add a campaign
     * @param campaign
     * @return campaign created
     */
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Campaign addCampaign(@RequestBody Campaign campaign){
        logger.info("### addCampaign method ###");
        return campaignService.addCampaign(campaign);
    }

    /**
     * get a campaign by its id
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  Campaign getCampaignById(@PathVariable ("id") int id){
        logger.info("### getCampaignById method ###");
        return campaignService.findById(id);
    }

    /**
     * get most recent campaigns
     * @return specified numbers of recent campaigns
     */
    @GetMapping(value = "/recent", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Campaign> getMostRecentCampaigns(){
        logger.info("### getMostRecentCampaigns method ###");
        return campaignService.getnMostRecent(3);
    }

    /**
     * get results of a campaign sorted by options
     * @param id
     * @return a map with results
     */
    @GetMapping(value = "/results/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<Integer, Integer> getCampaignResults(@PathVariable ("id") int id){
        logger.info("### getCampaignResults method ###");
        Campaign campaign = campaignService.findById(id);
        return voteService.getVotesByCampaign(campaign);
    }

    /**
     * update a campaign
     * @param c
     * @return
     */
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Campaign updateCampaign(@RequestBody Campaign c){
        Campaign campaign = campaignService.findById(c.getId());
        return campaignService.updateCampaign(campaign);
    }

    /**
     * select a list of campaign matching some campaign properties
     * @param campaign
     * @return
     */
    @PostMapping(value = "/select", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Campaign> selectCampaign(@RequestBody Campaign campaign){
        //TODO: adjust
        List<Campaign> campaigns = campaignService.selectCampaigns(campaign.getStartDate(), campaign.getEndDate(), campaign.getCategory());
        return campaigns;
    }

    @GetMapping(value = "/search/{keyword}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Campaign> searchCampaign(@PathVariable ("keyword") String keyword){
        return campaignService.searchCampaignByKeyWord(keyword);
    }


}
