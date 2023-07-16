package semicolon.africa.updatedVotersApp.Dtos.request;

import lombok.Data;

@Data
public class VoterRegistrationRequest {
    private  String name;
    private  String userName;
    private  String password;
    private  String houseNumber;
    private  String street;
    private  String town;
    private  String localGovernmentArea;
    private String state;
    private  String gender;
    private int age;
}
