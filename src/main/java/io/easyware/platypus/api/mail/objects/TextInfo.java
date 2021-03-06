package io.easyware.platypus.api.mail.objects;

public class TextInfo {

    public TextInfo() {}

    private String id;
    private EncodedSize encodedSize;

    @Override
    public String toString() {
        return "TextInfo{" +
                "id='" + id + '\'' +
                ", encodedSize=" + encodedSize +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EncodedSize getEncodedSize() {
        return encodedSize;
    }

    public void setEncodedSize(EncodedSize encodedSize) {
        this.encodedSize = encodedSize;
    }
}
