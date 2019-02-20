package com.dph.request.aggregator.asynchronous.callback;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/callback")
public class CallbackController {

    @RequestMapping(value = "/postData", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setData(HttpEntity<String> httpEntity) {
    }
}
