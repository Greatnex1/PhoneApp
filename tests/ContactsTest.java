import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactsTest {
    Contacts info;

    @BeforeEach
    void up(){
        info = new Contacts();

    }
    @Test
    void testContactsCanBeCreated(){
        assertNotNull(info);

    }
@Test
    void testContactHasFirstNamesInIt(){
        info.setFirstName("Joshua");

        String names = info.getFirstName();
        assertEquals("Joshua", names);
}
    @Test
    void testContactHasLastNamesInIt(){
        info.setLastName("Wiz");
        String lastName = info.getLastName();
        assertEquals("Wiz", lastName);

    }
    @Test
    void testContactHasEmailInIt(){
        info.setEmail("JoshuaWiz2@gmail.com");
        String email = info.getEmail();
        assertEquals("JoshuaWiz2@gmail.com", email);
    }

    @Test
    void testContactCanAccessAddress() {
        info.setAddress("12,Willie Street");
        String address = info.getAddress();
        assertEquals("12,Willie Street", address);
    }

    @Test
    void testContactCanAccessPhoneNumbers() {
        info.setPhoneNumber("+234-5789-081-231");
        String phone = info.getPhoneNumber();
        assertEquals("+234-5789-081-231",phone);
    }

    }