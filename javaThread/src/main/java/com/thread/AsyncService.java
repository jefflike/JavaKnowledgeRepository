package com.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void a() {
        while (true) {
            System.out.println("i am a");
        }
    }

    @Async
    public void b () {
        while (true) {
            System.out.println("i am b");
        }
    }
}
