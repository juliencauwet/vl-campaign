package org.greenwin.VLCampaign.controllers;


import org.greenwin.VLCampaign.exceptions.DuplicateVoteException;
import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;
import org.greenwin.VLCampaign.model.Vote;
import org.greenwin.VLCampaign.services.impl.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
@CrossOrigin(origins = "http://localhost:4200")
public class VoteController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VoteService voteService;

    @GetMapping("/")
    public List<Vote> getVotes(){
        logger.info("getVotes Method");
        return voteService.getAllVotes();
    }

    @GetMapping("/{id}")
    public Vote getVoteById(@PathVariable("id") int id){
        return voteService.getVoteById(id);
    }

    @GetMapping("/user/{userId}/campaign/{campaignId}")
    public Vote getVoteByUserAndCampaign(@PathVariable("userId") int userId, @PathVariable("campaignId") int campaignId){
        return voteService.getVoteByUserAndCampaign(userId, campaignId);
    }

    @PostMapping("/")
    public Vote saveVote(@RequestBody Vote vote){
        try {
            return voteService.saveVote(vote);
        }catch (DuplicateVoteException e){
            return new Vote(-1, new Campaign(), new Option());
        }

    }



}
