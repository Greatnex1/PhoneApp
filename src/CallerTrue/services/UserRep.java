package CallerTrue.services;

import CallerTrue.data.models.Contacts;
import CallerTrue.data.models.User;

import java.util.ArrayList;
import java.util.List;

public interface UserRep {
  User save(User user);
 void delete(User user);

User  findByPassword (User user);
User   deleteByPassWord (User user);
List <User>  findByFirstName(String firstName);
List <User> viewAlL();
}
