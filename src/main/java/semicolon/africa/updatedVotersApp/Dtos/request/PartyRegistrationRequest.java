package semicolon.africa.updatedVotersApp.Dtos.request;

import lombok.Data;

@Data
public class PartyRegistrationRequest {
    private String name;
    private  String userName;
    private String password;
    private  String houseNumber;
    private  String street;
    private  String lga;
    private  String state;
    private String town;
}
