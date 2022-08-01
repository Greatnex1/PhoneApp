package CallerTrue.data.repository;

import CallerTrue.data.models.User;

import java.util.List;

public interface UserRep {
  User save(User user);
 User delete(User user);

User  findByEmail(String user);
void   deleteByEmail (String email);
List <User>  findByFirstName(String firstName);
List <User> viewAlL();

    int counter();
}
