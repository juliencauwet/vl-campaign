package org.greenwin.VLCampaign.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Option {

    //public Option(String option, Campaign campaign){
    public Option(String option){
        this.option = option;
        //this.campaign = campaign;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String option;


    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.PERSIST,
            mappedBy = "option"
    )
    private List<Vote> votes;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "campaign"
    )
    private Campaign campaign;

}
