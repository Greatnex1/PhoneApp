package CallerTrue.services;

import CallerTrue.data.models.Contacts;
import CallerTrue.data.repository.ContactRepository;
import CallerTrue.data.repository.ContactImpl;
import CallerTrue.dto.response.ContactResponse;

public class ContactServiceImpl implements ContactService {
ContactRepository contactRepository = new ContactImpl();
ContactResponse contactResponse = new ContactResponse();

    @Override
    public Contacts addNewContact(Contacts contact) {
        Contacts saveContacts = new Contacts();
        return contactRepository.save(contact);
    }
}