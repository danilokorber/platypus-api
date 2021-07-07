package io.easyware.platypus.api.users.objects;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDate;
import java.util.List;

public class UserRepresentationAttributes {

    private String country;
    private String birthdate;
    private String street;
    private String postalCode;
    private String locality;
    private String locale;
    private String picture;

    public String getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country.get(0);
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(List<String> birthdate) {
        this.birthdate = birthdate.get(0);
    }
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(List<String> street) {
        this.street = street.get(0);
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(List<String> postalCode) {
        this.postalCode = postalCode.get(0);
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(List<String> locality) {
        this.locality = locality.get(0);
    }
    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(List<String> locale) {
        this.locale = locale.get(0);
    }
    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(List<String> picture) {
        this.picture = picture.get(0);
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
