package CallerTrue.services;

import CallerTrue.data.models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewUserTest {
    @Test
   void testUsersCAnSaveContacts(){
        NewUser identity = new NewUser();
        User users = new User();
      users.setFirstName("John");
users.setPassword("1234");
users.setEmail("john@gmail.com");
    }



}