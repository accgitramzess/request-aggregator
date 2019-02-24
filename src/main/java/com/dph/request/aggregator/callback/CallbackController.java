package com.dph.request.aggregator.callback;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/aggregator")
public class CallbackController {

    @RequestMapping(value = "/callback", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setData(HttpEntity<String> httpEntity) {
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void aggregatorStatistic() {

    }
}
