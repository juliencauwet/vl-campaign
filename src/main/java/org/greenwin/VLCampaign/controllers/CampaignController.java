package org.greenwin.VLCampaign.controllers;

import com.netflix.discovery.converters.Auto;
import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;
import org.greenwin.VLCampaign.model.Vote;
import org.greenwin.VLCampaign.repository.VoteRepository;
import org.greenwin.VLCampaign.services.impl.CampaignService;
import org.greenwin.VLCampaign.services.impl.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private VoteRepository voteRepository;

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

    /**
     * get most recent campaigns
     * @return specified numbers of recent campaigns
     */
    @GetMapping("/recent")
    public List<Campaign> getMostRecentCampaigns(){
        logger.info("### getMostRecentCampaigns method ###");
        return campaignService.getnMostRecent(3);
    }

    /**
     * gets results of a campaign sorted by options
     * @param id
     * @return a map with results
     */
    @GetMapping("/results/{id}")
    public Map<Option, Integer> getCampaignResults(@PathVariable ("id") int id){
        Campaign campaign = campaignService.findById(id);
        return voteService.getVotesByCampaign(campaign);
    }

}
