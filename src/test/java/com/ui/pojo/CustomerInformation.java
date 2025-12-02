package com.ui.pojo;

public class CustomerInformation {

    private String firstName;
    private String lastName;
    private String code;

    public CustomerInformation(String firstName, String lastName, String code) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "CustomerInformation{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", code=" + code +
                '}';
    }


}
