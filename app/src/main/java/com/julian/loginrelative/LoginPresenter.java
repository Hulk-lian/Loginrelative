package com.julian.loginrelative;

import android.content.Context;
import android.text.TextUtils;

import com.julian.loginrelative.modelo.User;


public class LoginPresenter implements ILoginMvp.Presenter{

    private ILoginMvp.View view;

   private String patronpass="((?=.*[0-9]).*)";//number
    private String patronpass2="(.*(?=.*[a-z])(?=.*[A-Z]).*)";//characters

    public LoginPresenter(ILoginMvp.View view) {
        this.view=view;
    }

    @Override
    public void validateCredentials(String user, String password) {

        String res="";
        int componente=0;

        if(!TextUtils.isEmpty(user))
        {
            res=((Context)view).getResources().getString(R.string.data_emptyES);
            componente=R.id.edtUser;
        }
        if (!TextUtils.isEmpty(password)) {

            if (password.length()>=8){

                if(password.matches(patronpass)) {

                    if(password.matches(patronpass2)){
                        //save the user on the class application
                        ((LoginRelative_Application)((Context)view).getApplicationContext()).setUser(new User(user,password));

                    }
                    else {
                        res=((Context)view).getResources().getString(R.string.password_case);
                        componente=R.id.edtPass;
                    }
                }
                else {
                    res=((Context)view).getResources().getString(R.string.password_digit);
                    componente=R.id.edtPass;
                }
            }
            else{
                res=((Context)view).getResources().getString(R.string.password_length);
                componente=R.id.edtPass;
            }
        }
        else {
            res=((Context)view).getResources().getString(R.string.data_emptyES);
            componente=R.id.edtPass;
        }

        view.setMessageError(res,componente);
    }
}
