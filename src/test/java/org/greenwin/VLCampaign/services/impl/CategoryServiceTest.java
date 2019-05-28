package org.greenwin.VLCampaign.services.impl;

import org.greenwin.VLCampaign.VlCampaignApplication;
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
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void getById() {
        Assert.assertEquals(categoryService.getById(1).getName(), "politique");
    }

    @Test
    public void getAll() {
        Assert.assertTrue(categoryService.getAll().size() > 4);
    }
}
