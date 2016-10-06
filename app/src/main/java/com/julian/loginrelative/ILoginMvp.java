package com.julian.loginrelative;

/**
 *
 */


public interface ILoginMvp {

    int PASSWORD_DIGIT=1;
    int PASSWORD_CASE = 2;
    int PASSWORD_LENGTH = 3;
    int DATA_EMPTY=4;

    interface View{
        public void setMessageError(String error);
    }
    interface Presenter{
        public void validateCredentials(String use,String pass);
    }
}
