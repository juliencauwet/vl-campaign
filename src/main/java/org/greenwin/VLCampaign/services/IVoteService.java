package org.greenwin.VLCampaign.services;

import org.greenwin.VLCampaign.model.Vote;

import java.util.List;

public interface IVoteService {

    Vote getVoteById(int id);
    List<Vote> getAllVotes();
    Vote saveVote(Vote vote);

}
