package pl.coderslab.seleniumcourse.zadaniazaliczeniowe.zad1;

public class FillInForm {
    private String alias;
    private String address;
    private String zipCode;
    private String city;
    private String selectCountry;
    private String phoneNumber;

    public String getAlias() {
        return alias;
    }

    public FillInForm setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public FillInForm setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public FillInForm setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public FillInForm setCity(String city) {
        this.city = city;
        return this;
    }

    public String getSelectCountry() {
        return selectCountry;
    }

    public FillInForm setSelectCountry(String selectCountry) {
        this.selectCountry = selectCountry;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public FillInForm setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
