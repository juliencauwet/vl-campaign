package org.greenwin.VLCampaign.services.impl;

import org.greenwin.VLCampaign.VlCampaignApplication;
import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;
import org.greenwin.VLCampaign.repository.CampaignRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = VlCampaignApplication.class
)
@TestPropertySource(locations = "classpath:application-test.properties")
public class OptionServiceTest {

    @Autowired
    private OptionService optionService;

    @Autowired
    private CampaignRepository campaignRepository;

    @Test
    public void getAllByCampaign() {
        Campaign campaign = campaignRepository.findById(9);
        Assert.assertEquals(3, optionService.getAllByCampaign(campaign).size() );
    }

    @Test
    public void getOptionById() {
        Assert.assertEquals("Taxer les entreprises", optionService.getOptionById(9).getOption());
    }

    @Test
    public void saveOption() {
        Option option = new Option("test-option", new Campaign());
        Option registeredOption = optionService.saveOption(option);
        Assert.assertNotNull(registeredOption.getId());
    }
}
