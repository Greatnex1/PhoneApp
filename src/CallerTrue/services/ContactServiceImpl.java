package CallerTrue.services;

import CallerTrue.Utils.Mapper;
import CallerTrue.data.models.Contacts;
import CallerTrue.data.repository.ContactRepository;
import CallerTrue.dto.response.ContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;
    ContactResponse contactResponse = new ContactResponse();


    @Override
    public Contacts addNewContact(Contacts contact) {
        Contacts saveContacts = new Contacts();
        Mapper.map(contact,saveContacts);
        contactRepository.save(saveContacts);
        var response = contactResponse.getMessage();
        return saveContacts;
         }

}

