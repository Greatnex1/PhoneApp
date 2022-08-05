package CallerTrue.services;

import CallerTrue.dto.request.ContactRequest;
import CallerTrue.dto.request.RegisterRequest;
import CallerTrue.dto.response.AllContactResponse;
import CallerTrue.dto.response.ContactResponse;
import CallerTrue.dto.response.RegisterResponse;

import java.util.List;

public interface UserService {
    public RegisterResponse registerUser(RegisterRequest registerRequest);

    ContactResponse addContact(ContactRequest request);

    int getNumberOfUsers();

    List<AllContactResponse> findContactsBelongingTo(String user);
}
