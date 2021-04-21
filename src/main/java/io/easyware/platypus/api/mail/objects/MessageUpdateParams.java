package io.easyware.platypus.api.mail.objects;

import java.util.ArrayList;

public class MessageUpdateParams {

    private ArrayList<String> add;
    private ArrayList<String> delete;
    private ArrayList<String> set;

    public MessageUpdateParams() {
        this.add = new ArrayList<String>();
        this.delete = new ArrayList<String>();
        this.set = new ArrayList<String>();
    }

    public ArrayList<String> getAdd() {
        return add;
    }

    public void setAdd(ArrayList<String> add) {
        this.add = add;
    }

    public ArrayList<String> getDelete() {
        return delete;
    }

    public void setDelete(ArrayList<String> delete) {
        this.delete = delete;
    }

    public ArrayList<String> getSet() {
        return set;
    }

    public void setSet(ArrayList<String> set) {
        this.set = set;
    }

    public void addAdd(String x) { this.add.add(x); }
    public void addDelete(String x) { this.delete.add(x); }
    public void addSet(String x) { this.set.add(x); }
}
