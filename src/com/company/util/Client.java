package com.company.util;

// client object with fields including firstName, lastName, email, airLine, origin, dest, deptTime, delayedTime, terminal, gate, passClass
public class Client {
    private String firstName;
    private String lastName;
    private String email;
    private String airLine;
    private String origin ;
    private String dest;
    private String deptTime;
    private String delayedTime;
    private String terminal;
    private String gate;
    private String passClass;


    public Client(String firstName, String lastName, String email, String airLine, String origin, String dest, String deptTime, String delayedTime, String terminal, String gate, String passClass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.airLine = airLine;
        this.origin = origin;
        this.dest = dest;
        this.deptTime = deptTime;
        this.delayedTime = delayedTime;
        this.terminal = terminal;
        this.gate = gate;
        this.passClass = passClass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAirLine() {
        return airLine;
    }

    public void setAirLine(String airLine) {
        this.airLine = airLine;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(String deptTime) {
        this.deptTime = deptTime;
    }

    public String getDelayedTime() {
        return delayedTime;
    }

    public void setDelayedTime(String delayedTime) {
        this.delayedTime = delayedTime;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getPassClass() {
        return passClass;
    }

    public void setPassClass(String passClass) {
        this.passClass = passClass;
    }


    }

