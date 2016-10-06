package com.julian.loginrelative;

import android.app.Application;

import com.julian.loginrelative.modelo.User;

//create for keep the data of user

public class LoginRelative_Application extends Application {

    private User user;

    public User getUser(){
        return user;
    }

    public void setUser (User user){
        this.user=user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
