package CallerTrue.services;

import CallerTrue.data.models.Contacts;

import java.util.ArrayList;
import java.util.List;

public class NewContactRep implements ContactRep {
    private int count;
    private int size;
    List<Contacts> saves = new ArrayList<>();

    //   Contacts contacts;
    @Override
    public Contacts save(Contacts contact) {
//        count++;
        contact.setId(count);
        saves.add(contact);
//if(saves.add(contact ) == findById(id))
//
        return contact;
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
//        for (var contact: saves) {
//            if(contact.getFirstName();
               return saves;

            }

    @Override
    public List<Contacts> findByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Contacts> findAll() {
        return null;
    }

    @Override
    public int count() {
        count++;
        return saves.size();

    }
}
