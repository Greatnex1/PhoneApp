package CallerTrue.controller;

import CallerTrue.data.models.Contacts;
import CallerTrue.dto.request.ContactRequest;
import CallerTrue.dto.request.RegisterRequest;
import CallerTrue.dto.response.ContactResponse;
import CallerTrue.dto.response.RegisterResponse;
import CallerTrue.services.UserServiceImpl;
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
    private UserServiceImpl userService = new UserServiceImpl();

    @PostMapping("/user")
    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest) {
        System.out.println("registering");
        return userService.registerUser(registerRequest);
    }

    @PatchMapping("/user")
    public ContactResponse addContact(@RequestBody ContactRequest contactRequest) {
        return userService.addContact(contactRequest);
    }

    @GetMapping("/user/{email}")
    public List<Contacts> findContactBelongingTo(@PathVariable String email) {
        System.out.println("fetching");
        return userService.findContactsBelongingTo(email);
    }
}
