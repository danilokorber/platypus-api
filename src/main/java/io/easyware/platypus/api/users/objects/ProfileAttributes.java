package io.easyware.platypus.api.users.objects;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDate;

public class ProfileAttributes {

    private String locale;
    @JsonbDateFormat(value = "yyyy-MM-dd HH:mm:ss")
    private LocalDate birthdate;
    private String street;
    private String locality;
    private String postalCode;
    private String country;
    private String picture;

    public String getLocale() { return locale; }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
