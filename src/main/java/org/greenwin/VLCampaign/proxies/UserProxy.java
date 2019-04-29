package org.greenwin.VLCampaign.proxies;

import org.greenwin.VLCampaign.beans.AppUser;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name = "ms-users", url = "http://localhost:8640/users")
//@RibbonClient(name = "ms-topics")
public interface UserProxy {

    @GetMapping("/")
    List<AppUser> getAllUsers();

    @GetMapping("/id/{id}")
    AppUser getUserById(@PathVariable("id") int id);

    @PostMapping("/")
    AppUser saveUser(@RequestBody AppUser appUser);

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable ("id") int id);

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    AppUser updateUser(@RequestBody AppUser user);
}
