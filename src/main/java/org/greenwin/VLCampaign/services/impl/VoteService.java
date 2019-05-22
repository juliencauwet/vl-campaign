package org.greenwin.VLCampaign.services.impl;

import org.greenwin.VLCampaign.beans.AppUser;
import org.greenwin.VLCampaign.exceptions.DuplicateVoteException;
import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;
import org.greenwin.VLCampaign.model.Vote;
import org.greenwin.VLCampaign.proxies.UserProxy;
import org.greenwin.VLCampaign.repository.CampaignRepository;
import org.greenwin.VLCampaign.repository.VoteRepository;
import org.greenwin.VLCampaign.services.IVoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VoteService implements IVoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    CampaignRepository campaignRepository;

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

    /**
     * check if no duplicate vote, if so deny
     * @param vote
     * @return
     */
    public Vote saveVote(Vote vote){
        vote.setDate(LocalDate.now());
        List <Vote> userVotes = voteRepository.getAllByCampaign(vote.getCampaign());
        logger.info("save vote");
        for (Vote v: userVotes) {
            logger.info("date début: " + v. getCampaign().getStartDate());
            if (v.getUserId() == vote.getUserId())
                throw new DuplicateVoteException();
        }

        return voteRepository.save(vote);
    }

    /**
     * fetch all votes per campaign and sorts the results by options
     * @param campaign
     * @return a map '<option_id, nbvotes>' of the results per campaign
     */
    @Override
    public Map<Integer, Integer> getVotesByCampaign(Campaign campaign) {
        Map<Integer, Integer> results = new HashMap<>();
        List<Vote> votes =  voteRepository.getAllByCampaign(campaign);
        for(Vote vote : votes)
            results.put(vote.getOption().getId(), !results.containsKey(vote.getOption().getId())? 1 : results.get(vote.getOption().getId()) + 1);
        return results;
    }


}
