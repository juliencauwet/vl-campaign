package org.greenwin.VLCampaign.model;

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

    @Id
    @GeneratedValue
    private int id;

    private int userId;

    @Transient
    private AppUser user;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "vote")
    private  Campaign campaign;

    private Option option;



}
