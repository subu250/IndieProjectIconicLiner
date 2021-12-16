package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * The type of the product
 */

@Entity(name = "Item")
@Table(name = "item")

public class Item {

    /**
     * Instantiates a new type of product.
     */
    public Item() {
    }
    private Product product;

    public Item(String name, String description, Product product) {
        this.name = name;
        this.description = description;
        this.product = product;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    // @ManyToOne
    //   @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "item_id"))


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", product=" + product +
                '}';
    }
}