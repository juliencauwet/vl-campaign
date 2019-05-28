package org.greenwin.VLCampaign.controllers;


import org.greenwin.VLCampaign.model.Vote;
import org.greenwin.VLCampaign.services.impl.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
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
        return voteService.saveVote(vote);
    }



}
