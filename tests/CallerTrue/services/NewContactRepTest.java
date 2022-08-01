package CallerTrue.services;

import CallerTrue.data.models.Contacts;
import CallerTrue.data.repository.ContactRepository;
import CallerTrue.data.repository.ContactImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewContactRepTest {
    @Test

    public void testContactsCAnBeSaved() {
        ContactRepository contactRep = new ContactImpl();
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
        ContactRepository contactRep = new ContactImpl();
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
        ContactRepository contactRep = new ContactImpl();
        Contacts contact = new Contacts();
        contact.setFirstName("George");
        contact.setLastName("Max");
        contact.setPhoneNumber("09067");
        contact.setEmail("georgemax@gmail.com");
        contact.setAddress("Willie wells Street");
        contactRep.save(contact);
        ContactRepository contactRep1 = new ContactImpl();
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
        ContactRepository contactRep = new ContactImpl();
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
        ContactRepository contactRep = new ContactImpl();
        Contacts contact = new Contacts();
        contact.setFirstName("George");
        contact.setLastName("Max");
        contactRep.save(contact);
        assertEquals(1, contactRep.count());
        contact.setFirstName("Emma");
        contact.setLastName("Max");
        contactRep.save(contact);
        assertEquals(1, contactRep.count());
//        System.out.println(contactRep.findById(1).getFirstName()  + " , updated successfully!");
        assertEquals("Emma", contactRep.findById(1).getFirstName());
    }

    @Test
    void testSearchContactsByFirstName() {
        ContactRepository contactRep = new ContactImpl();
        Contacts contact = new Contacts();
        contact.setFirstName("George");
        contact.setLastName("Max");
        contactRep.save(contact);
        ContactRepository contactRep1 = new ContactImpl();
        Contacts contact1 = new Contacts();
        contact1.setFirstName("George");
        contactRep1.findByFirstName("George");

        assertEquals("George", contact1.getFirstName());
    }

    @Test
    void testSearchContactsByLastName() {
        ContactRepository contactRep = new ContactImpl();
        Contacts contact = new Contacts();
        contact.setLastName("Wells");
        contactRep.save(contact);
        contactRep.findByLastName("Wells");
        assertEquals("Wells", contact.getLastName());

    }
}