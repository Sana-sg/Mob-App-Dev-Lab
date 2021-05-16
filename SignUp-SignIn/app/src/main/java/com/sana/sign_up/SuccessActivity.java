package com.sana.sign_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    TextView textView;
    String user;
    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        textView = (TextView)findViewById(R.id.login_text);
        btn_logout=(Button)findViewById(R.id.btn_logout);
        TextPaint paint=textView.getPaint();
        Shader textShader=new LinearGradient(0,0,450,500,
                new int[]{
                        Color.parseColor("#EB144C"),
                        Color.parseColor("#9900EF"),
                },null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(textShader);


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            user=bundle.getString("user");
        }
        textView.setText("Hi "+user);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(getApplicationContext(),MainActivity.class);
               startActivity(intent);
            }
        });

    }
}