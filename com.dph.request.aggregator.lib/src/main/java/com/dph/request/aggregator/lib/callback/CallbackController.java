package com.dph.request.aggregator.lib.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dph.request.aggregator.lib.support.RequestAggregatorSupport;

@Controller
@RequestMapping("/aggregator")
public class CallbackController {

    private RequestAggregatorSupport requestAggregatorSupport;

    @Autowired
    public CallbackController(RequestAggregatorSupport requestAggregatorSupport) {
        this.requestAggregatorSupport = requestAggregatorSupport;
    }

    @RequestMapping(value = "/callback", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void setData(HttpEntity<String> httpEntity) {
        requestAggregatorSupport.endSession(null);
    }

    @RequestMapping(value = "/statistic", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void aggregatorStatistic() {

    }
}
