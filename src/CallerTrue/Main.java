package CallerTrue;

import CallerTrue.controller.UserController;
import CallerTrue.dto.request.ContactRequest;
import CallerTrue.dto.request.RegisterRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    private static final Scanner keyboardInput = new Scanner(System.in);
    private UserController userController1 = new UserController();

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        displayMainMenu();
    }

    private static void displayMainMenu() {

        String mainMenuPrompt = """
                Welcome To True Caller
                                
                -> 1 Create an Account
                -> 2 Add Contact to a user
                -> 3 Find Contact belonging to user
                             
                """;
        String userInput = input(mainMenuPrompt);

        switch (userInput.charAt(0)) {
            case '1' -> createAnAccount();

            case '2' -> AddContactToUser();
            case '3' -> findContactBelongingToUSer();
        }
    }

    //
    private static void findContactBelongingToUSer() {
        UserController userController = new UserController();
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setFirstName(input("Enter contact firstName"));
        contactRequest.setLastName(input("Enter contact's lastName"));
        contactRequest.setEmail(input("Enter contact email:"));
        contactRequest.setUserName(input("Enter your email"));
        var contacts = userController.findContactBelongingTo(contactRequest.getEmail());

        for (var contact : contacts) {
            display(contact.toString());
        }
    }


    private static void display(String message) {
        System.out.println(message);
    }

    private static void AddContactToUser() {
        UserController userController = new UserController();
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setFirstName(input("Enter contact firstName"));
        contactRequest.setLastName(input("Enter contact's lastName"));
        contactRequest.setEmail(input("Enter contact email:"));
        contactRequest.setPhoneNumber(input("Enter contact's phoneNumber"));
        contactRequest.setUserName(input("Enter user's username"));
        userController.addContact(contactRequest);
        displayMainMenu();
        }



    private static void createAnAccount() {
        RegisterRequest userRequest = new RegisterRequest();
        UserController userController = new UserController();
        userRequest.setFirstName(input("Enter first name"));
        userRequest.setLastName(input("Enter last name"));
        userRequest.setUsername(input("Enter username"));
        userRequest.setPassword(input("Enter password"));
        userRequest.setPhoneNumber(input("Enter phonenumber"));
        userRequest.setEmail(input("Enter your email"));
        userController.registerUser(userRequest);
        welcome();
    }

    private static void welcome() {
        System.out.println("\nAccount created successfully!");
        AddContactToUser();
    }


    public static String input(String prompt) {
        System.out.println(prompt);
        return keyboardInput.nextLine();
    }
}
