package CallerTrue.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Contacts {
    @Id
    private String id;
    @Getter
    @Setter
     private  String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;


    }

