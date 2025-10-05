package com.deepak.Chache_Demo;

import com.deepak.Chache_Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class MultiUserTest implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        int numberOfRequests = 10; // number of simulated requests
        ExecutorService executor = Executors.newFixedThreadPool(5); // 5 threads at a time

        System.out.println("=== Running WITHOUT cache ===");
        for (int i = 0; i < numberOfRequests; i++) {
            executor.submit(() -> {
                long start = System.currentTimeMillis();
                userService.findByIdWithoutCache(1); // DB hit every time
                long end = System.currentTimeMillis();
                System.out.println("Thread " + Thread.currentThread().getName() +
                        " WITHOUT cache time: " + (end - start) + " ms");
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }

        // Wait a bit before next test
        Thread.sleep(2000);

        // New executor for cache test
        ExecutorService executorWithCache = Executors.newFixedThreadPool(5);
        System.out.println("\n=== Running WITH cache ===");

        for (int i = 0; i < numberOfRequests; i++) {
            executorWithCache.submit(() -> {
                long start = System.currentTimeMillis();
                userService.findByIdWithCache(1); // First DB, rest memory cache
                long end = System.currentTimeMillis();
                System.out.println("Thread " + Thread.currentThread().getName() +
                        " WITH cache time: " + (end - start) + " ms");
            });
        }

        executorWithCache.shutdown();
        while (!executorWithCache.isTerminated()) {
            Thread.sleep(100);
        }

        System.out.println("\nAll simulated requests finished.");
    }
}
