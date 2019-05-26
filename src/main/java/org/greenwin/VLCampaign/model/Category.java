package org.greenwin.VLCampaign.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    public Category(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(
            cascade = CascadeType.DETACH,
            mappedBy = "category"
    )
    private List<Campaign> campaigns = new ArrayList<>();


}
