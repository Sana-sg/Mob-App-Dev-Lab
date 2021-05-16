package com.sana.sign_up;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button btn_sign ,btn_cancel;
    EditText username,passoword;
    TextView textView,text;
    View view;
    Toast toast;
    Shader shader;

    public void toastmsg(Toast toast){
        view=toast.getView();
        text= view.findViewById(android.R.id.message);
        view.setBackgroundResource(R.drawable.toastmsg);
        text.setTextColor(Color.parseColor("#FFFFFF"));

        toast.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textView = (TextView)findViewById(R.id.heading);
         TextPaint paint=textView.getPaint();
         Shader textShader=new LinearGradient(0,0,450,500,
                 new int[]{
                 Color.parseColor("#EB144C"),
                 Color.parseColor("#9900EF"),
         },null,Shader.TileMode.CLAMP);
         textView.getPaint().setShader(textShader);


        btn_sign=(Button)findViewById(R.id.btn_sign);
        username=(EditText)findViewById(R.id.username);
        passoword=(EditText)findViewById(R.id.password);

        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String $username, $password;
                $username=username.getText().toString();
                $password=passoword.getText().toString();
                if($username.equals("")||$password.equals("")){
                    toast=Toast.makeText(getApplicationContext(),"Please fill all the details!",Toast.LENGTH_LONG);
                    toastmsg(toast);

                }
                else if(!isValidPwd($password.trim())){
                    if($password.length()<8){
                        toast=Toast.makeText(MainActivity.this, "Minimum 8 character password required!", Toast.LENGTH_LONG);
                        toastmsg(toast);
                    }
                    else {
                        toast = Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT);
                        toastmsg(toast);
                    }
                }
                else{
                    toast=Toast.makeText(getApplicationContext(),"Sign-up successful", Toast.LENGTH_SHORT);
                    toastmsg(toast);
                    Bundle bundle=new Bundle();
                    bundle.putString("user",$username);
                    bundle.putString("password",$password);
                    Intent intent=new  Intent(MainActivity.this, LoginActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            }
        });


    }
    public  boolean isValidPwd(final String Password){
        Pattern pattern;
        Matcher matcher;
        final String Pwd_Pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!#$%@&+=-_])(?=\\S+).{8,}$";
        pattern=Pattern.compile(Pwd_Pattern);
        matcher=pattern.matcher(Password);
        return(matcher.matches());
    }


}