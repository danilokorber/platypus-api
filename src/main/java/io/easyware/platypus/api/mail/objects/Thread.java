package io.easyware.platypus.api.mail.objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Thread {

    public Thread() {}

    private String id;
    private boolean unseen;
    private Address from;
    private String subject;
    private Date date = new Date(0);
    private int size = 0;
    private boolean hasAttachments = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isUnseen() { return unseen; }

    public void setUnseen(boolean unseen) { this.unseen = unseen; }

    public Address getFrom() {
        return from;
    }

    public void setFrom(Address from) {
        this.from = from;
    }

    public String getSubject() {return subject;}

    public void setSubject(String subject) {
        ArrayList<String> prefixes = new ArrayList<>(Arrays.asList("AW:", "WE:", "RE:", "FW:", "RES:", "ENC:"));
        int firstSpace = subject.indexOf(" ");
        String prefix = subject.substring(0,3).trim();
        if (prefixes.contains(subject.substring(0,3))) {
            subject = subject.substring(firstSpace).trim();
        }
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) { this.date = date.after(this.date) ? date : this.date; }

    public int getSize() {        return size;    }

    public void setSize(int size) {        this.size = size;    }

    public void sizePlusOne() { this.size += 1; }

    public boolean isHasAttachments() {
        return hasAttachments;
    }

    public void setHasAttachments(boolean hasAttachments) {
        this.hasAttachments = hasAttachments;
    }
}
