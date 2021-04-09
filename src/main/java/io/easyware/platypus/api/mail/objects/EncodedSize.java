package io.easyware.platypus.api.mail.objects;

public class EncodedSize {

    public EncodedSize() {}

    private float plain;
    private float html;

    @Override
    public String toString() {
        return "EncodedSize{" +
                "plain=" + plain +
                ", html=" + html +
                '}';
    }

    public float getPlain() {
        return plain;
    }

    public void setPlain(float plain) {
        this.plain = plain;
    }

    public float getHtml() {
        return html;
    }

    public void setHtml(float html) {
        this.html = html;
    }
}
