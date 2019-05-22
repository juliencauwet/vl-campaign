package org.greenwin.VLCampaign.services;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;
import org.greenwin.VLCampaign.model.Vote;

import java.util.List;
import java.util.Map;

public interface IVoteService {

    Vote getVoteById(int id);
    List<Vote> getAllVotes();
    Vote saveVote(Vote vote);
    Map<Integer, Integer> getVotesByCampaign(Campaign campaign);

}
