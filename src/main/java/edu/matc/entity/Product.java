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

   // @ManyToOne
   // private User user;

    //@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //private Set<Item> itemSet = new HashSet<>();

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
     * Gets user_name.
     *
     * @return the tuser_name.
     */

    public String getUser_name() {
        return user_name;
    }

    /**
     * Sets user_name.
     *
     * @return the user_name
     */

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }


    /**
     * Gets Item set.
     *
     * @return the item set
     */
   // public Set<Item> getItemSet() {
       // return itemSet;
  //  }

    /**
     * Sets typeSet.
     *
    // * @param itemSet the item set
     */
   // public void setItemSet(Set<Item> itemSet) {
       // this.itemSet = itemSet;
   // }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
               // ", user=" + user +
                ", user_name='" + user_name + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
              //  ", itemSet='" + itemSet + '\'' +
                '}';
    }


}
