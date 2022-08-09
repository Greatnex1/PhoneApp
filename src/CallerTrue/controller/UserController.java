package CallerTrue.controller;

import CallerTrue.Exceptions.UserAlreadyExistsException;
import CallerTrue.data.models.Contacts;
import CallerTrue.data.models.User;
import CallerTrue.dto.request.ContactRequest;
import CallerTrue.dto.request.RegisterRequest;
import CallerTrue.dto.response.AllContactResponse;
import CallerTrue.dto.response.ContactResponse;
import CallerTrue.dto.response.RegisterResponse;
import CallerTrue.services.UserService;
import CallerTrue.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Component

//@Controller
//A patch mapping gives a rule to the user based on condition
//GetMapping is a default mapping for browsers such as google
//Post, patch, put, get, delete five most used mapping
@RestController
public class UserController {
    @Autowired
    private UserService userService = new UserServiceImpl();

    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        try {
            RegisterResponse serviceResponse = userService.registerUser(registerRequest);
            return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
//        System.out.println("registering");
        } catch (UserAlreadyExistsException err) {
return  new ResponseEntity<>(err.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/user")
    public ContactResponse addContact(@RequestBody ContactRequest contactRequest) {
        return userService.addContact(contactRequest);
    }

    @GetMapping("/user/{email}")
    public List<AllContactResponse> findContactBelongingTo(@PathVariable String email) {
        System.out.println("fetching");
        return userService.findContactsBelongingTo(email);
    }
}
