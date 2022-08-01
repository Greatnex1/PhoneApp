package CallerTrue.services;

import CallerTrue.data.repository.UserRepImpl;
import CallerTrue.data.repository.UserRep;
import CallerTrue.data.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewUserTest {
    @Test
    void testUsersCanSaveContacts() {
        UserRep identity = new UserRepImpl();
        User users = new User();
        users.setFirstName("John");
        users.setPassword("1234");
        users.setEmail("john@gmail.com");
        identity.save(users);
        assertEquals(1, identity.counter());
    }

    @Test
    void testUserCanDeleteContacts() {
        UserRep identity = new UserRepImpl();
        User users = new User();
        users.setFirstName("John");
        users.setPassword("1234");
        users.setEmail("john@gmail.com");
        identity.save(users);
//       identity.delete(users);
        UserRepImpl identity1 = new UserRepImpl();
        User users1 = new User();
        users1.setFirstName("John");
        users1.setPassword("1234");
        users1.setEmail("john@gmail.com");
        identity1.save(users1);
        identity1.delete(users);
//        System.out.println(users.getEmail());
        assertEquals(1, identity.counter());
    }

    @Test
    void deleteContactsByEmailTest() {
        UserRep identity = new UserRepImpl();
        User users = new User();
        users.setFirstName("John");
        users.setPassword("1234");
        users.setEmail("john@gmail.com");
        identity.save(users);
        UserRepImpl identity1 = new UserRepImpl();
        User users1 = new User();
        users1.setFirstName("Johnny");
        users1.setPassword("2234");
        users1.setEmail("john@gmail.com");
        identity1.save(users1);
//        identity.findByEmail("john@gmail.com");

        assertEquals(1, identity.counter());

//    System.out.println(users.getEmail());

    }

    @Test
    void testUserCanSearchFirstNameByEmail() {
        UserRep identity = new UserRepImpl();
        User users = new User();
        users.setFirstName("John");
        users.setPassword("1234");
        users.setEmail("john@gmail.com");
        identity.save(users);
        User search = identity.findByEmail("john@gmail.com");
        assertEquals("John", search.getFirstName());

//    NewUser identity1 = new NewUser();
//    User users1 = new User();
//    users1.setFirstName("Johnny");
//    users1.setPassword("2234");
//    users1.setEmail("john@gmail.com");
//    identity1.save(users1);
    }

    @Test
    void testUserCanSearchByFirstNames() {
        UserRep identity = new UserRepImpl();
        User users = new User();
        users.setFirstName("John");
        users.setPassword("1234");
        users.setEmail("john@gmail.com");
        identity.save(users);
 identity.findByFirstName("John");
assertEquals("John",users.getFirstName());
    }
    @Test
     void testUserCanDeleteContactByEmail(){
        UserRep identity = new UserRepImpl();
        User users = new User();
        users.setFirstName("John");
        users.setPassword("1234");
        users.setEmail("john@gmail.com");
        identity.save(users);
        identity.delete(users);
        identity.deleteByEmail("john@gmail.com");
        assertEquals(0,identity.counter());
    }
}