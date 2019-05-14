package org.greenwin.VLCampaign.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.greenwin.VLCampaign.beans.AppUser;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vote {

    public Vote(int userId, Campaign campaign, Option option){
        this.userId = userId;
        this.campaign = campaign;
        this.option = option;
        this.date = LocalDate.now();
    }

    @Id
    @GeneratedValue
    private int id;

    private int userId;

    @Transient
    private AppUser user;

    private LocalDate date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "campaign")
    private  Campaign campaign;


    @ManyToOne
    @JoinColumn(name = "option")
    private Option option;



}
