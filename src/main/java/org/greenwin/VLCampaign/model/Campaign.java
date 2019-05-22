package org.greenwin.VLCampaign.model;

import lombok.*;
import org.greenwin.VLCampaign.beans.Topic;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {

    @Id
    @GeneratedValue
    private int id;

    String question;

    @Transient
    private Topic topic;

    private int TopicId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "campaign")
    private Set<Vote> votes = new HashSet<>();

    private LocalDate startDate;

    private LocalDate endDate;


    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "campaign")
    private List<Option> options = new ArrayList<>();


}
