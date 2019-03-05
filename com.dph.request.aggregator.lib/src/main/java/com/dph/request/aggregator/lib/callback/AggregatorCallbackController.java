package com.dph.request.aggregator.lib.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dph.request.aggregator.lib.flow.callback.AggregatorCallbackFlow;

@Controller
@RequestMapping("/aggregator")
public class AggregatorCallbackController {

    private AggregatorCallbackFlow aggregatorCallbackFlow;

    @Autowired
    public AggregatorCallbackController(AggregatorCallbackFlow aggregatorCallbackFlow) {
        this.aggregatorCallbackFlow = aggregatorCallbackFlow;
    }

    @RequestMapping(value = "/callback", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void callback(HttpEntity<?> httpEntity) {
        aggregatorCallbackFlow.execute(httpEntity);
    }
}
