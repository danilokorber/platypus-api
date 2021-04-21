package io.easyware.platypus.api.mail.objects;

public class MessageUpdate {

    private MessageUpdateParams flags;
    private MessageUpdateParams labels;

    public MessageUpdate() {
        this.flags = new MessageUpdateParams();
        this.labels = new MessageUpdateParams();
    }

    public MessageUpdateParams getFlags() {
        return flags;
    }

    public void setFlags(MessageUpdateParams flags) {
        this.flags = flags;
    }

    public MessageUpdateParams getLabels() {
        return labels;
    }

    public void setLabels(MessageUpdateParams labels) {
        this.labels = labels;
    }
}
