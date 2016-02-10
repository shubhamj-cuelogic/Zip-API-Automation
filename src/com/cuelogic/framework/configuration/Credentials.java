package com.cuelogic.framework.configuration;

/**
 * Created by ninad on 15/01/16.
 */
public class Credentials
{
    private String email = null;
    private String password = null;

    public Credentials(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
}