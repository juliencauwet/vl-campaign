package org.greenwin.VLCampaign.services;

import org.greenwin.VLCampaign.beans.AppUser;
import org.greenwin.VLCampaign.model.Vote;
import org.greenwin.VLCampaign.proxies.UserProxy;
import org.greenwin.VLCampaign.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserProxy userProxy;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     * @param id
     * @return the vote with this id
     */
    public Vote getVoteById(int id){
        return voteRepository.getById(id);
    }

    /**
     *
     * @return all Votes
     */
    public List<Vote> getAllVotes(){
        List<Vote> votes = new ArrayList<>();
        voteRepository.findAll().forEach(votes::add);
        for (Vote vote : votes)
            vote.setUser(userProxy.getUserById(vote.getUserId()));
        return votes;
    }

    public Vote saveVote(Vote vote){
        return voteRepository.save(vote);
    }
}
