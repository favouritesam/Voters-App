package semicolon.africa.updatedVotersApp.Dtos.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateElectionRequest {
    private  String electionDate;
    private List<String> state;
    private  List<String> parties;
    private List<String> localGovernment;

    public void setElectionCategory(String gubernatorial) {
    }
}
