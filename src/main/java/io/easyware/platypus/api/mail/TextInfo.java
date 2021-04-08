package io.easyware.platypus.api.mail;

public class TextInfo {

    public TextInfo() {}

    private String id;
    private EncodedSize encodedSize;

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
