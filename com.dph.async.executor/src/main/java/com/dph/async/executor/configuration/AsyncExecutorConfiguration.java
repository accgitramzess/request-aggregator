package com.dph.async.executor.configuration;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.dph.async.executor.AsyncOperationExecutor;

@Configuration
@EnableScheduling
public class AsyncExecutorConfiguration {

    @Bean
    public AsyncOperationExecutor executor() {
        return new AsyncOperationExecutor(new Random(), new RestTemplate(), new ArrayBlockingQueue<>(10));
    }
}
