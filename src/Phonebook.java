import java.util.ArrayList;

public class Phonebook {
    //    creating an ArrayList Object of class Contact;
    private ArrayList<Contacts> contacts;

//    a constructor of phoneBook(No args constructor)

    public Phonebook() {
        contacts = new ArrayList<Contacts>();
    }

    public Contacts viewAllContact(int index) {
        return contacts.get(index);
    }

    /*
      public Contacts getContact(String list){
          for (Contacts names: contacts) {
             if ( names.getFirstName().equalsIgnoreCase(list) && (names.getLastName().equalsIgnoreCase(list))
                      ||(names.getPassword().equalsIgnoreCase(list))|| (names.getEmail().equalsIgnoreCase(list))){
                  return names;
              }


          }
          return null;
      }

     */
    public void addContact(Contacts contact) {
        contacts.add(contact);
    }

    public void deleteContact(Contacts con) {
        contacts.remove(con);
    }

    public Contacts[] getPhoneBook() {
        Contacts[] contactEntries = new Contacts[contacts.size()];

        for (int i = 0; i < contacts.size(); i++) {
            contactEntries[i] = viewAllContact(i);

        }
        return contactEntries;
    }

    public boolean isEmpty() {
        return contacts.isEmpty();
    }

    public int size() {
        return contacts.size();
    }

    public String getContactInfo(String format) {
        String list = " ";
        for (Contacts names : contacts) {
            if (names.getFirstName().equalsIgnoreCase(format) && (names.getLastName().equalsIgnoreCase(format))
                    || (names.getEmail().equalsIgnoreCase(format))) {
                list = names.getPhoneNumber();
            } else if (names.getPhoneNumber().equalsIgnoreCase(format)) {
                list = String.format("%s %s", names.getFirstName(), names.getLastName());
            }

        }
        return list;
    }


    public String getContactName(String name) {
        return getContactInfo(name);

    }

    public String getContactNumber(String number) {
        return getContactInfo(number);
    }

    public boolean search(String full) {
        for (Contacts names : contacts) {
            if (names.getFirstName().equalsIgnoreCase(full) && (names.getLastName().equalsIgnoreCase(full))
                    || (names.getEmail().equalsIgnoreCase(full))) {
                return true;

            }
            }
        return false;

    }

    }


//    @Override
//    public String toString() {
//        return "Phonebook{" +
//                "contacts=" + contacts +
//                '}';
//    }

