package com.company.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class SendEmail {
    public static void sendEmail(Client client, double result) throws IOException, FileNotFoundException, MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // log in host email by set authentication password and username
        final String username = "wxin860";
        final String password = "wx631101!";
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // -- Create new message --
        Message message = new MimeMessage(session);
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);

        // -- Set the FROM and TO fields --
        try {
            message.setFrom(new InternetAddress(username + "@gmail.com"));
        } catch (MessagingException e) {
            System.out.println("unable to use host email address ");
        }

        // send email to the client in the clients list
        try {
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(client.getEmail(), false));
        } catch (MessagingException e) {
            System.out.println("unable to find client's email address");
        }

        // set message text according to delay time, if >= 30, send delay email
        if (result >= 30) {
            message.setSubject("Your flight is delayed");
            // if passenger is first class, normal delay email + VIP waiting room + today's date
            if (client.getPassClass().equals("First Class")) {

                message.setText("Dear " + client.getFirstName() + " , \n" +
                        "We are sorry to inform you that your flight" + client.getAirLine() + " from " + client.getOrigin() +
                        " to " + client.getDest() + " at " + client.getDeptTime() + " is changed! \n" + "Your new departure time " +
                        "is" + client.getDelayedTime() + ". Your flight will be at " + client.getTerminal() + ", and gate is "
                        + client.getGate() + "." +
                        "\nWe appologize for the inconvenience. To make change of your travel plan, please contact" +
                        "with us at phone number: xxx-xxx-xxxx. Please take a rest in our VIP waiting room."
                        + "\n" + today.getTime());
            } else {
                // if passenger not in first class, normal delay email + today's date
                message.setText("Dear " + client.getFirstName() + " , \n" +
                        "We are sorry to inform you that your flight" + client.getAirLine() + " from " + client.getOrigin() +
                        " to " + client.getDest() + " at " + client.getDeptTime() + " is changed! \n" + "Your new departure time " +
                        "is" + client.getDelayedTime() + ". Your flight will be at " + client.getTerminal() + ", and gate is "
                        + client.getGate() + "." +
                        "\nWe appologize for the inconvenience. To make change of your travel plan, please contact" +
                        "with us at phone number: xxx-xxx-xxxx"
                        + "\n" + today.getTime());
            }
            message.setSentDate(new Date());
        }

        // on time email + today's date if delay time < 30
        else if (result < 30) {
            message.setSubject("Your flight is on time");
            message.setText("Dear " + client.getFirstName() + " , your flight is on time, welcome abroad. \n" + today.getTime());
            message.setSentDate(new Date());
        }
        Transport.send(message);
    }


}

