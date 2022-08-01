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
    private  UserController userController1 = new UserController();

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
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
            case '1'-> createAnAccount();

            case '2'-> AddContactToUser();
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
        var contact = userController.findContactBelongingTo(contactRequest.getEmail());
//
//                for (var contact : contacts){
//                   display((contact.toString());
//                }
    }

        private static void display (String message){
            System.out.println(message);
        }

        private static void AddContactToUser () {
            UserController userController = new UserController();
            ContactRequest contactRequest = new ContactRequest();
            contactRequest.setFirstName(input("Enter contact firstName"));
            contactRequest.setLastName(input("Enter contact's lastName"));
            contactRequest.setEmail(input("Enter contact email:"));
            contactRequest.setUserName(input("Enter your username"));
            contactRequest.setPhoneNumber(input("Enter contact's phoneNumber"));
            userController.addContact(contactRequest);
            displayMainMenu();
        }


        private static void createAnAccount () {
            RegisterRequest contactRequest = new RegisterRequest();
            UserController userController = new UserController();
            contactRequest.setFirstName(input("Enter first name"));
           contactRequest.setLastName(input("Enter last name"));
            contactRequest.setUsername(input("Enter last name"));
            contactRequest.setPassword(input("Enter phonenumber"));
            contactRequest.setEmail(input("Enter your email"));
            userController.registerUser(contactRequest);
            welcome();
        }

    private static void welcome() {
        System.out.println("\nAccount created successfully!");
        AddContactToUser();
    }


    public static String input (String prompt){
            System.out.println(prompt);
            return keyboardInput.nextLine();
        }
    }
