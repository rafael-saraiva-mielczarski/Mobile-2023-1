package br.com.uniritter.app1_2023_1.models;

import androidx.annotation.NonNull;

public class Posts {
    private int id;
    private String title;
    private String body;
    private User user;

    public Posts(int id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @NonNull
    @Override
    public String toString() {
        return this.id+" -> "+this.title+" user: "+this.user.getName();
    }
}
