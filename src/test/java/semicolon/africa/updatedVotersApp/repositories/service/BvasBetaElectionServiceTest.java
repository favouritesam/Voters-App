package semicolon.africa.updatedVotersApp.repositories.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.updatedVotersApp.Dtos.request.CreateElectionRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.CreateElectionResponse;
import semicolon.africa.updatedVotersApp.service.BevasBetaElectionService;
import semicolon.africa.updatedVotersApp.service.BvasBetaElectionService;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasBetaElectionServiceTest {
    private BevasBetaElectionService electionService = new BvasBetaElectionService() ;
        @BeforeEach
        void SetUp() {
            electionService = new BvasBetaElectionService();
        }

        @Test
        void createElectionTest() {
            CreateElectionRequest createElectionRequest = new CreateElectionRequest();
            createElectionRequest.setElectionDate("2023-02-23");
            createElectionRequest.setElectionCategory("GUBERNATORIAL");
            List<String> parties = getParties();
            List<String> states = getStates();
            createElectionRequest.setState(states);
            createElectionRequest.setParties(parties);
            CreateElectionResponse createElectionResponse = electionService.create(createElectionRequest);
            assertNotNull(createElectionResponse);

        }

        private static List<String> getStates() {
            List<String> states = new ArrayList<>();
            states.add("Lagos");
            states.add("Kogi");
            states.add("kano");
            return states;
        }

        private static List<String> getParties() {
            List<String> parties = new ArrayList<>();
            parties.add("PDP");
            parties.add("APC");
            parties.add("townhall");
            parties.add("Lp");
            return parties;

        }
    }
