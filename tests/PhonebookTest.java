import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {
    Phonebook call;
    Contacts info;
    @BeforeEach
    void up(){
        call = new Phonebook();
info = new Contacts();
    }
@Test
    void phoneBookCanBeCreatedSpec(){
        assertNotNull(call);
}
@Test
public void phoneBookCanBeEmpty(){
        assertTrue(call.isEmpty());
}
@Test
    void testFirstNameAndLastNameCanBeAddedToPhoneBook(){
//   Contacts info = new Contacts();
//       info.setFirstName("George");
//        info.setLastName("Wiz");
        call.addContact(info);
        assertFalse(call.isEmpty());
        String col = info.getFirstName();
    System.out.println(col);

//    System.out.println(info.getFirstName() +" " + info.getLastName());
//        assertEquals("George",info.getFirstName());
//    assertEquals("Wiz",info.getLastName());

}
@Test
    void testPhoneBookCanBeIncreased(){
        call.addContact(info);
       call.addContact(info);
        assertEquals(2,call.size());
}
@Test
     void testPhoneBoOKCanSearchForContacts(){

}
}