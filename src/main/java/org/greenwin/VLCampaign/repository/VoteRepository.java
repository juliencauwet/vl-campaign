package org.greenwin.VLCampaign.repository;


import org.greenwin.VLCampaign.beans.AppUser;
import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    Vote getById(int id);
    List<Vote> getAllByCampaign(Campaign campaign);
    Vote getVoteByUserIdAndAndCampaign(int userId, Campaign campaign);

}
