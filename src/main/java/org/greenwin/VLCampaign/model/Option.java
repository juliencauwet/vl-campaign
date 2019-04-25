package org.greenwin.VLCampaign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Option {

    @Id
    @GeneratedValue
    private int id;

    private String option;

    @ManyToOne
    @JoinColumn(name = "campaign")
    private Campaign campaign;

}
