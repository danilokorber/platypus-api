package io.easyware.platypus.api.mail.objects;

import java.util.ArrayList;

public class MessageList {

    public MessageList() {}

    private int page;
    private int pages;
    private ArrayList<Message> messages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
