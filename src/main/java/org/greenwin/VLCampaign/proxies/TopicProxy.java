package org.greenwin.VLCampaign.proxies;

import org.greenwin.VLCampaign.beans.Topic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "ms-topics", url = "http://localhost:8641/topics")
public interface TopicProxy {

    @GetMapping("/{id}")
    Topic getTopicById(@PathVariable("id") int id);
}
