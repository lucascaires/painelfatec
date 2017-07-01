package br.edu.fatecrp.painelfatec;

import android.text.Html;

/**
 * Created by lucas on 29/06/17.
 */

public class Message {


    private String title;
    private String message;

    public Message(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return stripHtml(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return stripHtml(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String stripHtml(String html) {
        return Html.fromHtml(html).toString();
    }

}
