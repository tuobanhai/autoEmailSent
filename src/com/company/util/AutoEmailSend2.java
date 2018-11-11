package com.company.util;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AutoEmailSend2 {
    public static void main(String[] args) throws IOException {

//        read result from file
        double result = FileReader.read("part-r-00000");

//        read client info and build a list of client
        List<Client> list = ClientInfoReader.read("client_info.txt");

//        split the client list to 8 smaller tasks to be processed in 8 threads
        int numberOfClients = list.size();
        int numberPerThread = numberOfClients / 8;
        int start = 0;
        int end = Math.min(start + numberPerThread, numberOfClients - 1);

//        create thread pool with 8 threads
        ExecutorService executor = Executors.newFixedThreadPool(8);

//        for each thread, set their workerid, the task list from start to end, and result
        for (int i = 0; i < 8; i++) {
            Runnable worker = new ThreadSend(i, start, end, list, result);
            executor.execute(worker);
            start = end + 1;
            end = Math.min(start + numberPerThread, numberOfClients - 1);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
