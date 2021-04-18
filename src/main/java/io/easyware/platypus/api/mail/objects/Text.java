package io.easyware.platypus.api.mail.objects;

public class Text {

    private String plain;
    private String html;

    public Text() {}

    public String getPlain() {
        return plain;
    }

    public void setPlain(String plain) {
        this.plain = plain;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
