package CallerTrue.services;

import CallerTrue.data.models.Contacts;
import CallerTrue.dto.request.ContactRequest;
import CallerTrue.dto.request.RegisterRequest;
import CallerTrue.dto.response.ContactResponse;
import CallerTrue.dto.response.RegisterResponse;

import java.util.List;

public interface UserService {
    public RegisterResponse registerUser(RegisterRequest registerRequest);

    ContactResponse addContact(ContactRequest request);

    int getNumberOfUsers();

    List<Contacts> findContactsBelongingTo(String user);
}
