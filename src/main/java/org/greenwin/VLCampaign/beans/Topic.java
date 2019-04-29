package org.greenwin.VLCampaign.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.greenwin.VLCampaign.model.Vote;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    private int id;

    private String title;
    private String summary;
    private Date dateOfCreation;

    private int authorId;

    private List<Vote> votes;

}
