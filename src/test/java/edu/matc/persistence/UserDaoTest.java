package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDaoTest {

    UserDao dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new UserDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }



    /**
     * Verify successful insert of User
     */

    @Test
    void insertSuccess() {

        User user = new User();
        user.setId(10);
        user.setFirstName("John");
        user.setLastName("Doe");
        int id = dao.insert(user);
        User retrieveUser= dao.getById(id);
        assertEquals(user.getFirstName(), retrieveUser.getFirstName());
    }
    /**
     * Verify successful retrieval of a User
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Sierra", retrievedUser.getLastName());
    }

    /**
     * Verify successful update of a User
     */
    @Test
    void updateSuccess() {
        String firstname = "James";
        User userToUpdate = dao.getById(5);
        userToUpdate.setFirstName(firstname);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser= dao.getById(5);
        assertEquals(firstname, retrievedUser.getFirstName());
    }

    /**
     * Verify successful delete of User
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(6));
        assertNull(dao.getById(6));
    }

    /**
     * Verify successful retrieval of all Users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(5, users.size());
    }

}