package CallerTrue.data.models;

import lombok.Data;

import java.util.List;
@Data
public class User {
    private String firstName;
    private String password;
    private String email;

    private String username;

    List<Contacts> contacts;

}

