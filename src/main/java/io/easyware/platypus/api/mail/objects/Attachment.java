package io.easyware.platypus.api.mail.objects;

public class Attachment {

    public Attachment() {}

    private String id;
    private String contentType;
    private float encodedSize;
    private boolean embedded;
    private boolean inline;
    private String contentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public float getEncodedSize() {
        return encodedSize;
    }

    public void setEncodedSize(float encodedSize) {
        this.encodedSize = encodedSize;
    }

    public boolean isEmbedded() {
        return embedded;
    }

    public void setEmbedded(boolean embedded) {
        this.embedded = embedded;
    }

    public boolean isInline() {
        return inline;
    }

    public void setInline(boolean inline) {
        this.inline = inline;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }
}
