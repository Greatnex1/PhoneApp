package CallerTrue.data.repository;

import CallerTrue.data.models.Contacts;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contacts,String> {


}
