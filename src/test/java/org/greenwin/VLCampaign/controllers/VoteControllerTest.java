package org.greenwin.VLCampaign.controllers;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Vote;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

public class VoteControllerTest extends AbstractTestClass{

    @Test
    public void getVotes() throws Exception{
        String uri = "/votes/";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void getVoteById()throws Exception {
        String uri = "/votes/13";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void getVoteByUserAndCampaign() throws Exception {
        String uri = "/votes/user/9/campaign/11";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


    @Test
    public void saveVote() throws Exception{
        String uri = "/votes/";
        Vote vote = new Vote();
        String inputJson = super.mapToJson(vote);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);

    }
}
