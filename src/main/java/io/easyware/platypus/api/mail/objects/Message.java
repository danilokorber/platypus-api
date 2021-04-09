package io.easyware.platypus.api.mail.objects;

import java.util.ArrayList;
import java.util.Date;

public class Message {

    public Message() {}

    private String id;
    private float uid;
    private String emailId;
    private String threadId;
    private Date date;
    private boolean draft;
    private boolean unseen;
    private boolean flagged;
    private float size;
    private String subject;
    private Address from;
    private Address replyTo;
    private Address sender;
    private ArrayList<Address> to;
    private ArrayList<Address> cc;
    private ArrayList<Address> bcc;
    private String messageId;
    private String inReplyTo;
    private ArrayList<String> labels;
    private ArrayList<Attachment> attachments;
    private TextInfo text;

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", uid=" + uid +
                ", emailId='" + emailId + '\'' +
                ", threadId='" + threadId + '\'' +
                ", date=" + date +
                ", draft=" + draft +
                ", unseen=" + unseen +
                ", flagged=" + flagged +
                ", size=" + size +
                ", subject='" + subject + '\'' +
                ", from=" + from +
                ", replyTo=" + replyTo +
                ", sender=" + sender +
                ", to=" + to +
                ", cc=" + cc +
                ", bcc=" + bcc +
                ", messageId='" + messageId + '\'' +
                ", inReplyTo='" + inReplyTo + '\'' +
                ", labels=" + labels +
                ", attachments=" + attachments +
                ", text=" + text +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getUid() {
        return uid;
    }

    public void setUid(float uid) {
        this.uid = uid;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getThreadId() {
        return threadId;
    }

    public void setThreadId(String threadId) {
        this.threadId = threadId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    public boolean isUnseen() {
        return unseen;
    }

    public void setUnseen(boolean unseen) {
        this.unseen = unseen;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Address getFrom() {
        return from;
    }

    public void setFrom(Address from) {
        this.from = from;
    }

    public ArrayList<Address> getTo() {
        return to;
    }

    public void setTo(ArrayList<Address> to) {
        this.to = to;
    }

    public ArrayList<Address> getCc() {
        return cc;
    }

    public void setCc(ArrayList<Address> cc) {
        this.cc = cc;
    }

    public ArrayList<Address> getBcc() {
        return bcc;
    }

    public void setBcc(ArrayList<Address> bcc) {
        this.bcc = bcc;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<String> labels) {
        this.labels = labels;
    }

    public ArrayList<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<Attachment> attachments) {
        this.attachments = attachments;
    }

    public TextInfo getText() {
        return text;
    }

    public void setText(TextInfo text) {
        this.text = text;
    }
}
