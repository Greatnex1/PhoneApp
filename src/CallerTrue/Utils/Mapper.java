package CallerTrue.Utils;

import CallerTrue.data.models.User;
import CallerTrue.dto.request.RegisterRequest;

public class Mapper {
    public static void map(RegisterRequest request, User user) {
        user.setFirstName(request.getFirstName());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());

    }
}
