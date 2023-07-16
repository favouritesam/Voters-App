package semicolon.africa.updatedVotersApp.Dtos.request;

import lombok.Data;

@Data
public class AdminRegistrationRequest {
    private String userName;
    private  String firstName;
    private String lastName;
    private String password;
}
