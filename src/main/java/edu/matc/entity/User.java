package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "User")
@Table(name= "user")

/**
 * A class to represent a user.
 *
 * @author subu
 */
public class User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //private Set<Product> products = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param id        the id
     * @param userName
     * @param password
     */
    public User(String firstName, String lastName, String userName, String email, int id, String password, String givenName, String familyName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.id = id;
        this.password = password;

    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets last name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets emailAddress.
     *
     * @param email the user name
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */


    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password
     */

    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     //     * Add product.
     //     *
     //     * @param product the product
     //     */
    //	public void addProduct(Product product) {
    //  	products.add(product);
    //   product.setUser(this);
    // }
//    /**
//     * Remove product.
//     *
//     * @param product the product
//     */
//    public void removeProduct(Product product) {
//       // products.remove(product);
//    }
//
//    /**
//     * Instantiates a new User.
//     *
//     * @param userName the userName
//     * @param products the trip set
//     */
//
//    public User(String userName, Set<Product> products) {
//        this.userName = userName;
//        //this.products = products;
//    }
//
//    /**
//     * Instantiates a new User.
//     *
//     * @param userName the user name
//     * @param password the password
//     */
//    public User(String userName, String password) {
//        this.userName = userName;
//        this.password = password;
//    }


    // public Set<Product> getProduct() {
    //   return products;
    //}

//   /**
//     * Sets products.
//     *
//     * @param products the products
//     */
//    public void setProduct(Set<Product> products) {
//        this.products = products;
//    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName);
    }
}












