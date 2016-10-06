package com.julian.loginrelative;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginRelative_activity extends AppCompatActivity implements ILoginMvp.View{

    private ILoginMvp.Presenter loginMvp;

    private EditText edtPassWord,edtUser;

    private Button btnOk,btnCancel;

    private CheckBox chbRemember;

    private  static  String TAG="loginrelative";


    @Override
    protected void onStop() {
        super.onStop();
        if(((LoginRelative_Application)getApplicationContext()).getUser()!=null) {

            Log.d(TAG, "Activity finalizada");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_relative_activity);

        loginMvp = new LoginPresenter(this);//the presenter who have the direct conection with the view

        edtUser=(EditText)findViewById(R.id.edtUser);
        edtPassWord=(EditText)findViewById(R.id.edtPass);
        btnCancel=(Button)findViewById(R.id.btnCancel);
        btnOk=(Button)findViewById(R.id.btnOK);
        chbRemember=(CheckBox)findViewById(R.id.chbrecordar);

        //onClick
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the presenter
                loginMvp.validateCredentials(edtUser.getText().toString(),edtPassWord.getText().toString());
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetValues();
            }
        });
        if(((LoginRelative_Application)getApplicationContext()).getUser()!=null){
            Log.d(TAG,((LoginRelative_Application)getApplicationContext()).getUser().toString());
        }

    }

    private void resetValues()
    {
        edtPassWord.setText("");
        edtUser.setText("");
    }
    @Override
    public void setMessageError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }
}
