package io.easyware.platypus.api.mail;

public class WebhookMessage {

    public WebhookMessage() {}

    private String account;
    private String path;
    private String event;

    @Override
    public String toString() {
        return "WebhookMessage{" +
                "account='" + account + '\'' +
                ", path='" + path + '\'' +
                ", event='" + event + '\'' +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}