package com.company.util;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ThreadSend implements Runnable {
    private int workId;
    private List<Client> list;
    private int start;
    private int end;
    private double result;
//constructor for ThreadSend
    public ThreadSend(int workerId, int start, int end, List<Client> list, double result) {
        this.workId = workerId;
        this.start = start;
        this.end = end;
        this.list = list;
        this.result = result;
    }

//    send email to each of the client in client list from position [start] to [end]
    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            Client client = list.get(i);
            try {
                SendEmail.sendEmail(client, result);
                System.out.println("Email sent to " + client.getFirstName() + " by " + Thread.currentThread() + ", workerId is " + workId);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
