package CallerTrue.services;

import CallerTrue.Exceptions.UserAlreadyExistsException;
import CallerTrue.Utils.Mapper;
import CallerTrue.data.models.Contacts;
import CallerTrue.data.models.User;
import CallerTrue.data.repository.ContactImpl;
import CallerTrue.data.repository.ContactRepository;
import CallerTrue.data.repository.UserRep;
import CallerTrue.data.repository.UserRepImpl;
import CallerTrue.dto.request.ContactRequest;
import CallerTrue.dto.request.RegisterRequest;
import CallerTrue.dto.response.ContactResponse;
import CallerTrue.dto.response.RegisterResponse;

import java.util.List;

public class UserServiceImpl implements UserService {
    private int count;
    private final UserRep userRepository ;
    private RegisterResponse userResponse = new RegisterResponse();

    private final ContactService contactService;

    public UserServiceImpl(){
        this.userRepository =new UserRepImpl();
        ContactRepository contactRepository = new ContactImpl();
        this.contactService = new ContactService() {
            @Override
            public Contacts addNewContact(Contacts contact) {
                return contact;
            }
        };

    }

    @Override
    public RegisterResponse registerUser(RegisterRequest request) throws UserAlreadyExistsException {
        validate (request, userRepository);
        User user = new User();
        Mapper.map(request,user);
        userResponse.setMessage("Successful!");
        userRepository.save(user);
        return null;
//        return userResponse;

    }

    private void validate(RegisterRequest request, UserRep userRepository) {
        User savedUser = userRepository.findByEmail(request.getEmail());
        if(savedUser!= null) throw new UserAlreadyExistsException(request.getFirstName()+"already exists");
    }

    @Override
    public ContactResponse addContact(ContactRequest request) {
//        create a contact
//        save contact to repository
//        /find user by email
//        add contact to user contact lists
//        save user
        Contacts contact = new Contacts();
        contact.setEmail(request.getEmail());
        contact.setFirstName(request.getFirstName());
        contact.setPhoneNumber(request.getPhoneNumber());
        contact.setLastName(request.getLastName());

      Contacts savedContact =  contactService.addNewContact(contact);
      User user = userRepository.findByEmail(request.getUserName());
      user.getContacts().add(savedContact);

      userRepository.save(user);
        return null;
    }

    public int getNumberOfUsers(){
        return  userRepository.counter();
 }

    @Override

    public List<Contacts> findContactsBelongingTo(String userEmail) {
        User user = userRepository.findByEmail(userEmail);
        return user.getContacts();
    }
}


