package org.greenwin.VLCampaign.services.impl;

import org.greenwin.VLCampaign.VlCampaignApplication;
import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Category;
import org.greenwin.VLCampaign.repository.CampaignRepository;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = VlCampaignApplication.class
)
@TestPropertySource(locations = "classpath:application-test.properties")
public class CampaignServiceTest {

    @Autowired
    private CampaignService campaignService;

    @Test
    public void addCampaign() {
        Campaign campaign = new Campaign();
        Campaign persistedCampaign = campaignService.addCampaign(campaign);
        Assert.assertNotNull(persistedCampaign.getId());
    }

    @Test
    public void findById() {
        Campaign campaign = campaignService.findById(9);
        Assert.assertEquals(1, campaign.getTopicId());
    }

    @Test
    public void getnMostRecent() {
        List<Campaign> campaigns = campaignService.getnMostRecent(2);
        Assert.assertEquals(2, campaigns.size());
    }

    @Test
    public void getnMostPopular() {
    }

    @Test
    public void updateCampaign() {
        Campaign campaign = campaignService.findById(12);
        campaign.setQuestion("question updated");
        Campaign updatedCampaign = campaignService.updateCampaign(campaign);
        Assert.assertEquals("question updated", updatedCampaign.getQuestion());
        campaign.setQuestion("Comment anticiper la cohabitation avec les robots?");
        campaignService.updateCampaign(campaign);
    }

    /*
    @Test
    public void selectCampaigns() {
        Campaign campaign1 = new Campaign();
        Campaign campaign2 = new Campaign();
        campaign1.setStartDate(LocalDate.now());
        campaign1.setEndDate(LocalDate.now().plusDays(7));
        campaign1.setQuestion("for test");
        campaign2.setStartDate(LocalDate.now());
        campaign2.setEndDate(LocalDate.now().plusDays(7));
        campaign2.setQuestion("test again");
        campaignService.addCampaign(campaign1);
        campaignService.addCampaign(campaign2);
        Assert.assertEquals(2, campaignService.selectCampaigns(LocalDate.now().minusDays(1), LocalDate.now().plusDays(8), new Category()).size());
    }
    */

    @AfterClass
    public static void after(){

    }
}
