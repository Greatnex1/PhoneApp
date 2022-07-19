package CallerTrue.services;

import CallerTrue.data.models.Contacts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewContactRepTest {
    @Test

    public void testContactsCAnBeSaved() {
        ContactRep contactRep = new NewContactRep();
        Contacts contact = new Contacts();
        contact.setFirstName("George");
        contact.setLastName("Max");
        contact.setPhoneNumber("09067");
        contact.setEmail("georgemax@gmail.com");
        contact.setAddress("Willie wells Street");
        contactRep.save(contact);
        assertEquals(1, contactRep.count());

    }

    @Test
    void testContactCanBeSearchedForById() {
        ContactRep contactRep = new NewContactRep();
        Contacts contact = new Contacts();
        contact.setFirstName("George");
        contact.setLastName("Max");
        contact.setPhoneNumber("09067");
        contact.setEmail("georgemax@gmail.com");
        contact.setAddress("Willie wells Street");
        contactRep.save(contact);
        assertEquals(1, contactRep.count());
        Contacts save = contactRep.findById(1);
        assertEquals("George", save.getFirstName());


    }

    @Test
    void testContactCanBeDeleted() {
        ContactRep contactRep = new NewContactRep();
        Contacts contact = new Contacts();
        contact.setFirstName("George");
        contact.setLastName("Max");
        contact.setPhoneNumber("09067");
        contact.setEmail("georgemax@gmail.com");
        contact.setAddress("Willie wells Street");
        contactRep.save(contact);
        ContactRep contactRep1 = new NewContactRep();
        Contacts contact1 = new Contacts();
        contact1.setFirstName("George");
        contact1.setLastName("Max");
        contact1.setPhoneNumber("09067");
        contact1.setEmail("georgemax@gmail.com");
        contact1.setAddress("Willie wells Street");
        contactRep1.save(contact);
        contactRep1.delete(contact);
        assertEquals(1, contactRep.count());


    }

    @Test
    void testContactCAnBeRemovedById() {
        ContactRep contactRep = new NewContactRep();
        Contacts contact = new Contacts();
        contact.setFirstName("George");
        contact.setLastName("Max");
        contact.setPhoneNumber("09067");
        contact.setEmail("georgemax@gmail.com");
        contact.setAddress("Willie wells Street");
        contactRep.save(contact);

//    contactRep.delete(contact);
//    assertEquals(0,contactRep.count());
        contactRep.deleteById(1);
        assertEquals(0, contactRep.count());


    }

    @Test
    void testContactsCanBeUpdated() {
/* this test is to save a name that overrides when saved wih the same id
}

 */
        ContactRep contactRep = new NewContactRep();
        Contacts contact = new Contacts();
        contact.setFirstName("George");
        contact.setLastName("Max");
        contact.setFirstName("George");
        contact.setLastName("Max");


    }
}