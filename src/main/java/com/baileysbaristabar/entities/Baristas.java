package com.baileysbaristabar.entities;

import javax.persistence.*;
import java.util.Date;


// the Baristas class is a Java representation of the baristas table in the database
// the @Entity annotation tells Hibernate to create a table in the database based on the fields in this class
// the @Table annotation tells Hibernate to create a table in the database with the name "baristas"
@Entity
@Table(name = "baristas")
public class Baristas {
    // the @Id annotation tells Hibernate that this field is the primary key for the table
    // the @GeneratedValue annotation tells Hibernate to auto-generate the primary key
    // the @Column annotation tells Hibernate to create a column in the table based on the field name
    @Id
    @GeneratedValue
    @Column(name = "barista_username")
    private String barista_username;
    @Column(name = "barista_password")
    private String barista_password;
    @Column(name = "account_creation_date")
    private Date account_creation_date;
    @Column(name = "num_dropped_from")
    private int num_dropped_from;
    @Column(name = "enrolled_num")
    private int enrolled_num;

    // the default constructor is required by Hibernate
    // it is used to create a new instance of the class
    // it is also used to create a new instance of the class when retrieving data from the database
    // the constructor is not used when updating, deleting, inserting, or retrieving data in the database
    public Baristas(){}

    // the constructor is used when inserting, updating, deleting, and retrieving data into the database
    public Baristas(int id, String barista_username, String barista_password, Date account_creation_date, int num_dropped_from, int enrolled_num) {
        this.barista_username = barista_username;
        this.barista_password = barista_password;
        this.account_creation_date = account_creation_date;
        this.num_dropped_from = num_dropped_from;
        this.enrolled_num = enrolled_num;
    }

    public Baristas(String barista_username, String barista_password){
        this.barista_username = barista_username;
        this.barista_password = barista_password;
    }

    // the getters and setters are used to get and set the values of the fields in the class
    public String getBaristaUsername() {
        return barista_username;
    }

    public void setBaristaUsername(String barista_username) {
        this.barista_username = barista_username;
    }

    public String getBaristaPassword() {
        return barista_password;
    }

    public void setBaristaPassword(String barista_password) {
        this.barista_password = barista_password;
    }

    public Date getAccountCreationDate() {
        return account_creation_date;
    }

    public void setAccountCreationDate(Date account_creation_date) {
        this.account_creation_date = account_creation_date;
    }

    public int getNumDroppedFrom() {
        return num_dropped_from;
    }

    public void setNumDroppedFrom(int num_dropped_from) {
        this.num_dropped_from = num_dropped_from;
    }

    public int getEnrolledNum() {
        return enrolled_num;
    }

    public void setEnrolledNum(int enrolled_num) {
        this.enrolled_num = enrolled_num;
    }

    // the toString method is used to print the values of the fields in the class
    // this method is not used when inserting, updating, deleting, or retrieving data in the database
    // this method is used when printing the values of the fields in the class
    // this method is used when printing the values of the fields in the class when retrieving data from the database
    @Override
    public String toString() {
        return "Baristas [barista_username=" + barista_username + ", barista_password=" + barista_password + ", account_creation_date=" + account_creation_date + ", num_dropped_from=" + num_dropped_from + ", enrolled_num=" + enrolled_num + "]";
    }



}
