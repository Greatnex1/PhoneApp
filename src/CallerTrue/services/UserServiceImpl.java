package CallerTrue.services;

import CallerTrue.Exceptions.UserAlreadyExistsException;
import CallerTrue.Utils.Mapper;
import CallerTrue.data.models.Contacts;
import CallerTrue.data.models.User;
import CallerTrue.data.repository.UserRep;
import CallerTrue.dto.request.ContactRequest;
import CallerTrue.dto.request.RegisterRequest;
import CallerTrue.dto.response.AllContactResponse;
import CallerTrue.dto.response.ContactResponse;
import CallerTrue.dto.response.RegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRep userRepository;

    public UserServiceImpl(UserRep rep){
        this.userRepository = rep;
    }

//    private RegisterResponse userResponse = new RegisterResponse();
@Autowired
    private  ContactService contactService;
    @Override
    public RegisterResponse registerUser(RegisterRequest request) throws UserAlreadyExistsException {
        validate(request, userRepository);
        User user = new User();
        Mapper.map(request, user);
//        userResponse.setMessage("Successful!");
        userRepository.save(user);
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setMessage(String.format("%s contact added!", request.getEmail()));
        return registerResponse;
//        return userResponse;

    }

    private void validate(RegisterRequest request, UserRep userRepository) {
        User savedUser = userRepository.findUserByEmail(request.getEmail());
        if (savedUser != null) throw new UserAlreadyExistsException(request.getFirstName() + "already exists");
    }

    @Override
    public ContactResponse addContact(ContactRequest request) {
//        create a contact
//        save contact to repository
//        /find user by email
//        add contact to user contact lists
//        save user
        Contacts contact = new Contacts();
        Mapper.map(request,contact);
        Contacts savedContact = contactService.addNewContact(contact);
        User user = userRepository.findUserByEmail(request.getUserName());
        user.getContacts().add(savedContact);
        ContactResponse response = new ContactResponse();
        response.setMessage("");

        userRepository.save(user);
        return null;
    }

    @Override
    public int getNumberOfUsers() {
        return 0;
    }

//    @Override
//    public int getNumberOfUsers() {
//        return 0;
//    }


    @Override

    public List<AllContactResponse> findContactsBelongingTo(String email) {
        User user = userRepository.findUserByEmail(email);
        System.out.println(user);
        List<Contacts> allUserContact = user.getContacts();
        List<AllContactResponse> response = new ArrayList<>();
        for (var contact : allUserContact) {
            AllContactResponse singleResponse = new AllContactResponse();
            Mapper.map(contact, singleResponse);
            response.add(singleResponse);
        }
//        allUserContact.forEach(contacts -> {
//            AllContactResponse singleResponse = new AllContactResponse();
//            singleResponse.setId(contact.getId()+ "");
//            singleResponse.setFirstname(contact.getFirstName());
//            singleResponse.setLastname(contact.getLastName());
//            r
//
//        };
            return response;
        }
    }


