package com.dph.async.executor;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import com.dph.async.executor.dto.AsyncRequest;
import com.dph.async.executor.dto.AsyncResponse;

public class AsyncOperationExecutor {

    private Random random;

    private RestTemplate restTemplate;

    private BlockingQueue<AsyncRequest> asyncOperations;

    public AsyncOperationExecutor(Random random, RestTemplate restTemplate, BlockingQueue<AsyncRequest> asyncOperations) {
        this.random = random;
        this.restTemplate = restTemplate;
        this.asyncOperations = asyncOperations;
    }

    public void pushAsyncOperation(AsyncRequest asyncRequest) {
        try {
            asyncOperations.put(asyncRequest);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void execute() {
        try {
            AsyncRequest asyncRequest = asyncOperations.poll(1000, TimeUnit.MILLISECONDS);
            Thread.sleep(random.nextInt(9000) + 1000);
            if(asyncRequest != null)
                restTemplate.postForObject(asyncRequest.getCallbackUrl(), new AsyncResponse(), HttpStatus.class);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
