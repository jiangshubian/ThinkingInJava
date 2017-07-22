package com.shu.Cloneable;

import java.util.Date;

/**
 * Created by Administrator on 2017-07-22.
 */
public class User implements Cloneable {
    private String username;


    private String password;


    private Date birthdate;


    public User(String username, String password, Date birthdate) {


        this.username = username;


        this.password = password;


        this.birthdate = birthdate;


    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return birthdate != null ? birthdate.equals(user.birthdate) : user.birthdate == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}
