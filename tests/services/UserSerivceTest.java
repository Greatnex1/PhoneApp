package services;


import CallerTrue.data.repository.UserRep;
import CallerTrue.dto.request.ContactRequest;
import CallerTrue.dto.request.RegisterRequest;
import CallerTrue.services.ContactService;
import CallerTrue.services.ContactServiceImpl;
import CallerTrue.services.UserService;
import CallerTrue.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {
    @Autowired
     UserRep userRep;

    @Autowired
    ContactService contactService;

    @Autowired
    UserService userService;
    @Autowired
     ContactRequest addRequest;
    @Autowired
     RegisterRequest request;
    @BeforeEach
   void up(){
        contactService = new ContactServiceImpl();
     userService = new UserServiceImpl();
        addRequest= new ContactRequest();


        request = new RegisterRequest();
        request.setEmail("test@example.com");
        request.setFirstName("Test");
        request.setPassword("Test123");
        request.setUsername("testing224");
        request.setUsername("Testing_me");

    }



/*@Test
    void registerTest(){
//    given there is a request
//    when
    userService.registerUser(request);
//    i try to register user repositories
    assertEquals(1,userService.getNumberOfUsers());
}

@Test
    public void testDuplicateEmailThrowExceptionIfEmailAlreadyExists(){
    userService.registerUser(request);
    RegisterRequest request1  = new RegisterRequest();
    request1.setEmail("test@example.com");
    request1.setFirstName("Test");
//    userService.registerUser(request1);
//    assertThrows(UserAlreadyExistsException.class);
    assertEquals(1,userService.getNumberOfUsers());
}
*/

@Test
    public void addContactTest(){


//    given that i have a user
//    user adds contacts
//    check that user size increases
//    UserServiceImpl userService =new UserServiceImpl(userRepository,contactService);


    addRequest.setUsername(request.getUsername());
    addRequest.setEmail("ayo2gmail.com");
    addRequest.setLastName("Aj");
    addRequest.setFirstName("NiIke");
    addRequest.setPhoneNumber("090876543");
    userService.registerUser(request);

//    userService.addContact(addRequest);

    assertEquals(1,userService.findContactsBelongingTo(request.getEmail()).size());

}
@Test
    void findAllContactsTest(){
    userService.registerUser(request);

}
}