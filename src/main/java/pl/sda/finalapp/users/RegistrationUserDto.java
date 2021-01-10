package pl.sda.finalapp.users;

import lombok.Setter;

@Setter
public class RegistrationUserDto {

    private String firstName;
    private String lastName;
    private String eMail;
    private String password;
    private String city;
    private String country;
    private String zipCode;
    private String street;
    private String birthDate;
    private String pesel;
    private String phone;
    private boolean preferEmails;


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEMail() {
        return this.eMail;
    }

    public String getPassword() {
        return this.password;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public String getStreet() {
        return this.street;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getPesel() {
        return this.pesel;
    }

    public String getPhone() {
        return this.phone;
    }

    public boolean isPreferEmails() {
        return this.preferEmails;
    }
}
