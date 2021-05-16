package com.sana.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn00,btn_add,btn_sub,btn_mul,btn_div,btn_dp,btn_eql,btn_clr;
  TextView op_text;
  EditText ip_text;
  String input="";
    float val1,val2;
    boolean eadd,esub,emul,ediv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn8=(Button)findViewById(R.id.btn8);
        btn9=(Button)findViewById(R.id.btn9);
        btn00=(Button)findViewById(R.id.btn00);
        btn_add=(Button)findViewById(R.id.btn_add);
        btn_sub=(Button)findViewById(R.id.btn_sub);
        btn_mul=(Button)findViewById(R.id.btn_mul);
        btn_div=(Button)findViewById(R.id.btn_div);
        btn_dp=(Button)findViewById(R.id.btn_dp);
        btn_clr=(Button)findViewById(R.id.btn_clr);
        btn_eql=(Button)findViewById(R.id.btn_eql);
        ip_text=(EditText)findViewById(R.id.ip_text);
        op_text=(TextView)findViewById(R.id.op_text);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+"0");
                input=input+ip_text.getText();
            }
        });
        btn00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+"00");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+"3");

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+"4");

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+"9");
            }
        });
        btn_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(ip_text.getText()+".");
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=Float.parseFloat(ip_text.getText()+"");
                eadd=true;
                input=input+ip_text.getText()+"+";
                ip_text.setText(null);
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=Float.parseFloat(ip_text.getText()+"");
                esub=true;
                input=input+ip_text.getText()+"-";
                ip_text.setText(null);
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=Float.parseFloat(ip_text.getText()+"");
                input=input+ip_text.getText()+"*";
                emul=true;
                ip_text.setText(null);
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=Float.parseFloat(ip_text.getText()+"");
                input=input+ip_text.getText()+"/";
                ediv=true;
                ip_text.setText(null);
            }
        });
        btn_eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val2 = Float.parseFloat(ip_text.getText() + "");
                input=input+ip_text.getText();
                if (eadd) {
                    op_text.setText((val1 + val2) + "");
                    ip_text.setText(input);
                    eadd = false;
                }
                if (esub) {
                    op_text.setText((val1 - val2) + "");
                    ip_text.setText(input);
                    eadd = false;
                }
                if (emul) {
                    op_text.setText((val1 * val2) + "");
                    ip_text.setText(input);
                    eadd = false;
                }
                if (ediv) {
                    op_text.setText((val1 / val2) + "");
                    ip_text.setText(input);
                    eadd = false;
                }
            }
        });
        btn_clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip_text.setText(null);
                input="";
                op_text.setText(null);
            }
        });

    }
}