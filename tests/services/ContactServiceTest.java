package services;


import CallerTrue.data.models.Contacts;
import CallerTrue.data.repository.ContactRepository;
import CallerTrue.data.repository.UserRep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactServiceTest {
    Contacts contact;
    ContactRepository contactRep;
    UserRep userRepository;
    @BeforeEach
  /*  void up(){
        contact  = new Contacts();
        contactRep = new ContactImpl();
    userRepository = new UserRepImpl();
    }*/
    @Test
    void addNewContact(){

        contact.setFirstName("Ojo");
        contact.setLastName("Arin");
        contact.setEmail("ojoarin@gmail.com");
        contact.setPhoneNumber("09087564321");
      contactRep.save(contact);
       var savedContact = contactRep.count();
       assertEquals(1,savedContact);
    }
}
