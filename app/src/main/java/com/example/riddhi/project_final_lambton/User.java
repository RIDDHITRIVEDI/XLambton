package com.example.riddhi.project_final_lambton;


public class User
{

    private String email,password;

    public void setEmail(String email){
        this.email=email;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public String getEmail()
    {
        return email;

    }
    public String getPassword(){
        return password;
    }

    public String toString()
    {
        return getEmail()+" - "+getPassword();
    }


}
