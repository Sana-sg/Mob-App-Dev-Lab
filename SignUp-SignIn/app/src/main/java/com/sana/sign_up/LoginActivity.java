package com.sana.sign_up;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.icu.text.RelativeDateTimeFormatter;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button btn_login,btn_cancel2;
    EditText log_username,log_pwd;
    int counter=3;
    String user,pwd;
    TextView textView,warn_text,text;
    Toast toast;
    View view;

    public void toastmsg(Toast toast){
        view=toast.getView();
        view.setBackgroundResource(R.drawable.toastmsg);
        text= view.findViewById(android.R.id.message);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        toast.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView = (TextView)findViewById(R.id.heading2);
        TextPaint paint=textView.getPaint();
        Shader textShader=new LinearGradient(0,0,450,500,
                new int[]{
                        Color.parseColor("#EB144C"),
                        Color.parseColor("#9900EF"),
                },null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);

        btn_login=(Button)findViewById(R.id.btn_login);
        btn_cancel2=(Button)findViewById(R.id.btn_cancel2);
        log_username=(EditText)findViewById(R.id.log_username);
        log_pwd=(EditText)findViewById(R.id.log_pwd);
        warn_text=(TextView)findViewById(R.id.warn_text);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            user=bundle.getString("user");
            pwd=bundle.getString("password");
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String luser=log_username.getText().toString();
                String lpwd=log_pwd.getText().toString();

                if(luser.equals(user) && lpwd.equals(pwd)) {
                    toast=Toast.makeText(LoginActivity.this, "Login Sucess", Toast.LENGTH_SHORT);
                    toastmsg(toast);
                    Bundle bundle=new Bundle();
                    bundle.putString("user",luser);
                    Intent intent = new Intent(LoginActivity.this, SuccessActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else{
                    counter--;
                    if(counter<=0){
                       warn_text.setText("Max attempts Exceeded");
                       warn_text.setVisibility(View.VISIBLE);
                       btn_login.setEnabled(false);
                    }
                    else {
                        toast = Toast.makeText(LoginActivity.this, "Login Failed! Try Again", Toast.LENGTH_SHORT);
                       toastmsg(toast);
                    }

                    
                }
            }
        });
        btn_cancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}