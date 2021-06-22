package com.example.siksha;

import androidx.annotation.NonNull;

public class homeworkd {
   String message;
    String link;

    public homeworkd(String message, String link) {
        this.message = message;
        this.link = link;
    }

    public homeworkd() {
    }

    public String getMessage() {
        return message;
    }

    public String getLink() {
        return link;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
