package CallerTrue.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document
@Data
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String firstName;
    private String password;
    private String email;
    private String username;
@DBRef
    List<Contacts> contacts = new ArrayList<>();

}

