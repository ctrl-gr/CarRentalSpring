package com.carrentalspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name", nullable = false)
    @NotEmpty(message = "First name can not be empty")
    @Size(min= 1, max = 15, message = "First name size must be between 1 and 15 characters")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotEmpty(message = "Last name can not be empty")
    @Size(min= 1, max = 15, message = "Last name size must be between 1 and 15 characters")
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Can not set a future date as birth date")
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "username", nullable = false)
    @NotEmpty(message = "You should choose a username")
    @Size(min=4, message="Username size must be minimum 4 characters")
    private String username;

    @Column(name = "password", nullable = false)
    @NotEmpty(message = "You should choose a password")
    @Size(min=8, message="Password size must be minimum 8 characters")
    private String password;

    @Column(name = "is_admin", nullable = false)

    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {

    }

    public String toString() {
        return "User [id=" + id + ", Nome=" + firstName + ", Cognome=" + lastName + ", DataDiNascita=" + birthDate + ", Username = " + username + "]";
    }

}