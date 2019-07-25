package com.books.firebasetest;

public class User {

    private String mobileNumber;
    private String emailID;
    private String userName;
    private String password;

    public User() {

    }

    public User(String mobileNumber, String emailID, String userName, String password) {
        this.mobileNumber = mobileNumber;
        this.emailID = emailID;
        this.userName = userName;
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
