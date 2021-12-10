package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The product type.
/**
 * The type Product.
 * @author subu
 */

@Entity(name = "Product")
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    private User user;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "type")
    private String type;


    /**
     * No arg constructor.
     */
    public Product() {

    }

    /**
     * Instantiates a new Product.
     *
     * @param brand    brand of product
     * @param type type of product
     */
    public Product(String brand, String type, String user_name) {
        this.brand = brand;
        this.type = type;
        this.user_name = user_name;
    }
    /**
     * Gets brand.
     *
     * @return the brand
     */

    public String getBrand() {
        return brand;
    }

    /**
     * Sets brand.
     *
     * @return the brand
     */

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets type.
     *
     * @return the type
     */

    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @return the type
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets username.
     *
     * @return the user_name
     */

    public String getUser_name() {
        return user_name;
    }


    /**
     * Sets username.
     *
     * @return the user_name
     */


    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", user=" + user +
                ", user_name='" + user_name + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


}
