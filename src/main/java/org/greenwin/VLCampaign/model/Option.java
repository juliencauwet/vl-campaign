package org.greenwin.VLCampaign.model;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

public class Option {

    @Id
    @GeneratedValue
    int id;

    private String option;

    @ManyToOne
    private Campaign campaign;

}
