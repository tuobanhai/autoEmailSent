package com.company.util;

import com.company.util.Client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClientInfoReader {
    /**
     * read client information from txt
     *
     * @return a list of clients object with information including firstName, lastName, email, airLine, origin, dest, deptTime, delayedTime, terminal, gate, passClass
     */
    public static List<Client> read(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);
        List<Client> list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] token = line.split(",");
            //use trim()to remove the space between , and string
            String firstName = token[0].trim();
            String lastName = token[1].trim();
            String email = token[2].trim();
            String airLine = token[3].trim();
            String origin = token[4].trim();
            String dest = token[5].trim();
            String deptTime = token[6].trim();
            String delayedTime = token[7].trim();
            String terminal = token[8].trim();
            String gate = token[9].trim();
            String passClass = token[10].trim();
            list.add(new Client(firstName, lastName, email, airLine, origin, dest, deptTime, delayedTime, terminal, gate, passClass));
        }

        return list;
    }
}




