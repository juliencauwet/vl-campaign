package org.greenwin.VLCampaign.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    private int Id;

    private String username;

    private String password;

   private Set<AppRole> roles = new HashSet<>();

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
