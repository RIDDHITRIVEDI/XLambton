package com.example.riddhi.project_final_lambton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import android.support.design.widget.TextInputLayout;
//import android.support.design.widget.TextInputLayout;


public class register_data extends AppCompatActivity {
    Button register,back;

    EditText email,password;
   // private TextInputLayout inputLayoutEmail, inputLayoutPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_data);
        final Button save=(Button)findViewById(R.id.save);

           // inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);



           // name = (EditText)findViewById(R.id.et_uname);

            email = (EditText)findViewById(R.id.email);
            password = (EditText)findViewById(R.id.password);
            //back = (Button) findViewById(R.id.back);
            register = (Button) findViewById(R.id.save);
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    User user = new User();
                    // String uName=name.getText().toString();

                    String uEmail = email.getText().toString();
                    String uPassword = password.getText().toString();
                    //  user.setName(uName);
                    user.setEmail(uEmail);
                    user.setPassword(uPassword);
                    database userDatabase = new database(register_data.this);
                    userDatabase.dbInsert(user);
                    userDatabase.close();


                    save.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent i = new Intent(register_data.this, MainActivity.class);

                            startActivity(i);
                        }
                    });
                }


//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(register_data.this,MainActivity.class);
//                startActivity(i);
//            }
//        });
            });
}}
