package org.greenwin.VLCampaign.services.impl;

import org.greenwin.VLCampaign.VlCampaignApplication;
import org.greenwin.VLCampaign.model.Vote;
import org.greenwin.VLCampaign.repository.CampaignRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = VlCampaignApplication.class
)
@TestPropertySource(locations = "classpath:application-test.properties")
public class VoteServiceTest {

    @Autowired
    private VoteService voteService;

    @Autowired
    private CampaignRepository campaignRepository;

    @Test
    public void getVoteById() {
        Assert.assertEquals(4, voteService.getVoteById(21).getUserId());
    }

    /*
    @Test
    public void getAllVotes() {
        Assert.assertTrue(voteService.getAllVotes().size() > 5);
    }
    */
    @Test
    public void saveVote() {
        Vote vote = new Vote();
        Vote registeredVote = voteService.saveVote(vote);
        Assert.assertNotNull(registeredVote.getId());
    }

    @Test
    public void getVotesByCampaign() {
        Assert.assertEquals(3, voteService.getVotesByCampaign(campaignRepository.findById(9)).size());
    }

    @Test
    public void getVoteByUserAndCampaign() {
        Assert.assertEquals(1, voteService.getVoteByUserAndCampaign(1,9).getOption().getId());
    }
}
