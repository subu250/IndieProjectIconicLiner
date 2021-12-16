package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    //@ManyToOne
    //private User user;

    // @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    // private Set<Item> item = new HashSet<>();

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

////    /**
////     * Sets type.
////     *
////     * @return the type
////     */
////
////    public void setType(String type) {
////        this.type = type;
////    }
////
////    /**
////     * Gets user.
////     *
////     * @return the user.
////     */
////
////    public User getUser() {
////        return user;
////    }
//
//    /**
//     * Sets user_name.
//     *
//     * @return the user
//     */
//
//    public void setUser(User user) {
//        this.user = user;
//    }


    /**
     * Gets Item set.
     *
     * @return the item set
     */
// public Set<Item> getItem() {
//       return item;
//  }
//
//    /**
//     * Sets typeSet.
//     *
//    // * @param itemSet the item set
//     */
//   public void setItem(Set<Item> product) {
//       this.item = item;
//   }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", user_name=" + user_name +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                // ", item='" + item + '\'' +
                '}';
    }


}
