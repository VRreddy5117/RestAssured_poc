package com.user.model;

public class User {
    private String name;
    private String job;
    private String emailFail;
    private String emailSuccess;
    private String password;
    ;

    public String getEmailSuccess() {
        return emailSuccess;
    }

    public void setEmailSuccess(String emailSuccess) {
        this.emailSuccess = emailSuccess;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmailFail() {
        return emailFail;
    }

    public void setEmailFail(String email) {
        this.emailFail = emailFail;
    }

}
