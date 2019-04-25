package org.greenwin.VLCampaign.beans;

import org.greenwin.VLCampaign.model.Vote;

import java.util.Date;
import java.util.List;


public class Topic {

    private int id;

    private String title;
    private String summary;
    private Date dateOfCreation;

    private int authorId;

    private List<Vote> votes;

}
