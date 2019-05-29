package org.greenwin.VLCampaign.controllers;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.greenwin.VLCampaign.model.Campaign;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;


public class CampaignControllerTest extends AbstractTestClass{

    @Test
    public void addCampaign() throws Exception{
        String uri = "/campaign/";
        Campaign campaign = new Campaign();
        campaign.setQuestion("testQuestion");

        String inputJson = super.mapToJson(campaign);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void getCampaignById() throws Exception{
        String uri = "/campaign/9";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void getMostRecentCampaigns() throws Exception {
        String uri = "/campaign/recent";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        try {
            String content = mvcResult.getResponse().getContentAsString();
            Campaign[] campaigns = super.mapFromJson(content, Campaign[].class);
            assertTrue(campaigns.length > 0);
        } catch (InvalidDefinitionException e) {
        }
    }

    @Test
    public void getCampaignResults()throws Exception {
        String uri = "/campaign/results/10";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


}
