package CallerTrue.data.repository;

import CallerTrue.data.models.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactImpl implements ContactRepository {
    private int count;
    private int size;
    List<Contacts> saves = new ArrayList<>();

    //   Contacts contacts;
    @Override
    public Contacts save(Contacts contact) {
        var contactToUpdate = findById(contact.getId());
        if (contactToUpdate== null) {
            count++;
            contact.setId(count);
            saves.add(contact);

        } else {
           contactToUpdate.setFirstName(contact.getFirstName()  );
            contactToUpdate.setLastName(contact.getLastName());
            contactToUpdate.setEmail(contact.getEmail());
            contactToUpdate.setPhoneNumber(contact.getPhoneNumber());

        }
        return contact ;
    }



    @Override
    public Contacts delete(Contacts contact) {
        count--;
        contact.setId(count);
        saves.remove(contact);

return contact;
    }

    @Override
    public void deleteById(int id) {
//        for (var contact : saves) {
//            if (contact.getId() == id) {
//                return contact;
        Contacts del = findById(id);
        saves.remove(del);
            }




    @Override
    public Contacts findById(int id) {
        for (var contact: saves) {
            if(contact.getId() == id){
                return contact;

            }
        }
        return null;
    }

    @Override
    public List<Contacts> findByFirstName(String firstName) {
count++;
          return   saves;
           }


    @Override
    public List<Contacts> findByLastName(String lastName) {

        return saves;
    }

    @Override
    public List<Contacts> findAll() {
        return saves;
    }

    @Override
    public int count() {
        count++;
        return saves.size();

    }
}
