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
     * Verify successful retrieval of all Users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Verify successful insert of User
     */

    @Test
    void insertSuccess() {

        User user = new User();
        user.setId(1);
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
        assertEquals("Users", retrievedUser.getLastName());
    }

    /**
     * Verify successful update of a User
     */
    @Test
    void updateSuccess() {
        String firstname = "James";
        User userToUpdate = dao.getById(2);
        userToUpdate.setFirstName(firstname);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser= dao.getById(2);
        assertEquals(firstname, retrievedUser.getLastName());
    }

    /**
     * Verify successful delete of User
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

}