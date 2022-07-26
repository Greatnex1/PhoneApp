package CallerTrue.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;

}
