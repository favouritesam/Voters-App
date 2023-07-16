package semicolon.africa.updatedVotersApp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Party {
    private String name;
    private  String id;
    private UserInformation userInformation;
}
