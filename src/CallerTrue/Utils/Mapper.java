package CallerTrue.Utils;

import CallerTrue.data.models.Contacts;
import CallerTrue.data.models.User;
import CallerTrue.dto.request.ContactRequest;
import CallerTrue.dto.request.RegisterRequest;
import CallerTrue.dto.response.AllContactResponse;

public class Mapper {
    public static void map(RegisterRequest request, User user) {
        user.setFirstName(request.getFirstName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());

    }
    public static void map(Contacts contact,Contacts newContact){
        newContact.setFirstName(contact.getFirstName());
        newContact.setLastName(contact.getLastName());
        newContact.setEmail(contact.getEmail());
        newContact.setPhoneNumber(contact.getPhoneNumber());
    }
    public static void map(ContactRequest contactRequest, Contacts newContact) {
        newContact.setFirstName(contactRequest.getFirstName());
        newContact.setLastName(contactRequest.getLastName());
        newContact.setEmail(contactRequest.getEmail());
        newContact.setPhoneNumber(contactRequest.getPhoneNumber());
    }


    public static void map(Contacts contact, AllContactResponse singleResponse) {
        singleResponse.setId(contact.getId()+ "");
        singleResponse.setFirstname(contact.getFirstName());
        singleResponse.setLastname(contact.getLastName());
    }
}
