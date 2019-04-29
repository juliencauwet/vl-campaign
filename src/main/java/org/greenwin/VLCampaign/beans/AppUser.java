package org.greenwin.VLCampaign.beans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {

    public AppUser(@NotNull String email, @NotNull String password) {
        this.email = email;
        this.password = password;
    }

    private int id;

    private String email;

    private String password;

    private List<AppRole> appRole;

    private String name;

    private String firstName;

    private String tel;

    private LocalDate birthday;

    private LocalDateTime registrationDate;

    private int addressId;

    private Boolean active = true;

}
