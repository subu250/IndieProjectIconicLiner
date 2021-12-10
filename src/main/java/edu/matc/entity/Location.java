package edu.matc.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;
/*
 * Product location
 * @subu
 */

@Data
@Entity

public class Location {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalcode;
}
