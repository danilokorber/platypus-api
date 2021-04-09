package io.easyware.platypus.api.mail;

import java.util.Date;

public class WebhookMessage {

    public WebhookMessage() {}

    private String account;
    private Date date;
    private String path;
    private String specialUse;
    private String event;
    private Message data;

    @Override
    public String toString() {
        return "WebhookMessage{" +
                "account='" + account + '\'' +
                ", date=" + date +
                ", path='" + path + '\'' +
                ", specialUse='" + specialUse + '\'' +
                ", event='" + event + '\'' +
                ", data=" + data +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSpecialUse() {
        return specialUse;
    }

    public void setSpecialUse(String specialUse) {
        this.specialUse = specialUse;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Message getData() {
        return data;
    }

    public void setData(Message data) {
        this.data = data;
    }
}