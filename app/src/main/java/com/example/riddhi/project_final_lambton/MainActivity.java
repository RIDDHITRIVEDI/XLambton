package com.example.riddhi.project_final_lambton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

//import android.support.design.widget.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    EditText email, password;
    private database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login=(Button)findViewById(R.id.login);
        Button register=(Button)findViewById(R.id.register);
     //   Button guest=(Button)findViewById(R.id.guest);

       // private TextInputLayout inputLayoutEmail, inputLayoutPassword;
        //private TextInputLayout inputLayoutNameLogin;
       // inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
      //  inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
       // login = (Button) findViewById(R.id.bLogin);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


        db = new database(this);




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,register_data.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {

                List<User> userList = loadUser();

                final String uEmail = email.getText().toString();
                //Toast.makeText(WelcomeActivity.this, uEmail, Toast.LENGTH_SHORT).show();

                final String uPassword = password.getText().toString();
                if(uEmail.isEmpty() || uPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter Login Credentials !!", Toast.LENGTH_SHORT).show();
                } else
                {
                    if (userList.isEmpty())
                    {
                        Toast.makeText(MainActivity.this, "Register First", Toast.LENGTH_SHORT).show();
                    }
                    for (int i=0; i<userList.size(); i++)
                    {
                        String userName=userList.get(i).getEmail();

                        String userEmail=userList.get(i).getEmail();
                        String userPassword=userList.get(i).getPassword();
                       // Toast.makeText(WelcomeActivity.this, userName, Toast.LENGTH_SHORT).show();
                        if(uEmail.equals(userEmail)&& uPassword.equals(userPassword))
                        {
                            Toast.makeText(MainActivity.this, userName, Toast.LENGTH_SHORT).show();
                            Intent goToProducts=new Intent(MainActivity.this,main_screen.class);
                            goToProducts.putExtra("name", userEmail);

                            startActivity(goToProducts);
                            break;
                        }

                        else
                            Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

    }

    public void NewUser(View v) {
        Intent goTONewUser = new Intent(this, register_data.class);
        startActivity(goTONewUser);

    }

    public void goForGuest(View v) {
//        Intent goToGuestProduct = new Intent(MainActivity.this, without_discount.class);
//        startActivity(goToGuestProduct);
    }

    public List<User> loadUser() {
        database userDatabase = new database(this);
        List<User> users = userDatabase.dbSearch();
        userDatabase.close();
        return users;

    }







    }

