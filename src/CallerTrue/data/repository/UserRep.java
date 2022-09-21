package CallerTrue.data.repository;

import CallerTrue.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRep extends MongoRepository <User, String> {

    User findUserByEmail(String email);
   // User findUsersByUsername(String userame);

}
