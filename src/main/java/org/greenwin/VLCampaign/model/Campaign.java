package org.greenwin.VLCampaign.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.greenwin.VLCampaign.beans.Topic;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {

    @Id
    @GeneratedValue
    private int id;

    private Topic topic;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cam")
    Set<Vote> votes = new HashSet<>();

    private LocalDate startDate;

    private LocalDate endDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "topic")
    private List<Option> options;

    private Option result;

}
