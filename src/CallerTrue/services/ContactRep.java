package CallerTrue.services;

import CallerTrue.data.models.Contacts;

import java.util.List;

public interface ContactRep {
    Contacts save (Contacts contact);
     Contacts delete (Contacts contact);
     void deleteById(int id);
     Contacts findById(int id);
     List <Contacts> findByFirstName(String firstName);
    List <Contacts> findByLastName(String lastName);
    List <Contacts> findAll();

    int count();


}
