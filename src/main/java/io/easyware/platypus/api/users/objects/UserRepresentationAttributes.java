package io.easyware.platypus.api.users.objects;

import java.util.List;

public class UserRepresentationAttributes {

    private Object country;
    private Object birthdate;
    private Object street;
    private Object postalCode;
    private Object locality;
    private Object locale;
    private Object picture;

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Object birthdate) {
        this.birthdate = birthdate;
    }

    public Object getStreet() {
        return street;
    }

    public void setStreet(Object street) {
        this.street = street;
    }

    public Object getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Object postalCode) {
        this.postalCode = postalCode;
    }

    public Object getLocality() {
        return locality;
    }

    public void setLocality(Object locality) {
        this.locality = locality;
    }

    public Object getLocale() {
        return locale;
    }

    public void setLocale(Object locale) {
        this.locale = locale;
    }

    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
    }
}
