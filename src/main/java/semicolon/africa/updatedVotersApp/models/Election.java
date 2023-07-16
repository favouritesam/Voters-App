package semicolon.africa.updatedVotersApp.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class Election {
    private String electionDate;
    private LocalDate date;
    private  Category category;
    private List<Party> parties;
}
