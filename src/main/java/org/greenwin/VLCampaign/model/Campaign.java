package org.greenwin.VLCampaign.model;

import lombok.*;
import org.greenwin.VLCampaign.beans.Topic;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
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

    @Transient
    private Topic topic;

    private int TopicId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "campaign")
    private Set<Vote> votes = new HashSet<>();

    private LocalDate startDate;

    private LocalDate endDate;


    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "campaign")
    private Set<Option> options = new HashSet<>();


}
