package com.shu.Cloneable;

/**
 * Created by Administrator on 2017-07-22.
 */
public class Administrator implements Cloneable {
    private User user;

    private Boolean editable;

    public Administrator(User user, Boolean editable) {
        this.user = user;
        this.editable = editable;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Administrator admin = (Administrator) super.clone();
        admin.user = (User) admin.user.clone();
        return admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return user != null ? user.equals(that.user) : that.user == null;
    }

    @Override
    public int hashCode() {
        return user != null ? user.hashCode() : 0;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }
}
