package com.dph.blocked.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dph.blocked.service.BlockedService;
import com.dph.blocked.service.dto.Request;

@Controller
@RequestMapping("/blocked-service")
public class BlockedServiceController {

    private BlockedService blockedService;

    @Autowired
    public BlockedServiceController(BlockedService blockedService) {
        this.blockedService = blockedService;
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void execute(@RequestBody Request request) {
        blockedService.download(request);
    }
}
