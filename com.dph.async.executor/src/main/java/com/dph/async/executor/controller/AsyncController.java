package com.dph.async.executor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dph.async.executor.dto.AsyncRequest;
import com.dph.async.executor.AsyncOperationExecutor;

@Controller
@RequestMapping("/async")
public class AsyncController {

    private AsyncOperationExecutor executor;

    @Autowired
    public AsyncController(AsyncOperationExecutor executor) {
        this.executor = executor;
    }

    @RequestMapping(value = "/request", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void execute(@RequestBody AsyncRequest asyncRequest) {
        executor.pushAsyncOperation(asyncRequest);
    }
}
