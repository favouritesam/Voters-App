package semicolon.africa.updatedVotersApp.repositories;

import semicolon.africa.updatedVotersApp.models.Party;
import semicolon.africa.updatedVotersApp.models.UserInformation;
import semicolon.africa.updatedVotersApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BvasPartyRepository implements PartyRepository {

    private final List<Party> politicalParties = new ArrayList<>();
    private final UserInformationRepository userInformationRepository = new BvasUserInformationRepository();



    @Override
    public List<Party> findAll() {
        List<Party> foundParties = new ArrayList<>();
        for(Party party: politicalParties){
            String userInformationId = AppUtils.getUserInformationId(party.getId());
            if (userInformationId != null){
                UserInformation foundUserInformation = userInformationRepository.findById(userInformationId);
                party.setUserInformation(foundUserInformation);
            }
            foundParties.add(party);
        }
        return foundParties;
    }

    @Override
    public Party save(Party party) {
        party.setId(AppUtils.generatedId());
        boolean isPartyWithUserInformation = party.getUserInformation() != null;
        if (isPartyWithUserInformation) saveUserInformation(party);
        politicalParties.add(party);
        return party;
    }

    public void saveUserInformation(Party party){
        UserInformation savedUserInformation = userInformationRepository.save(party.getUserInformation());
        String partyId = party.getId();
        String userInformationId = savedUserInformation.getUserId();
        AppUtils.linkUserToUserInformation(partyId, userInformationId);
    }

    @Override
    public void deleteById(String id) {
        var foundParty = findById(id);
        if (foundParty != null) politicalParties.remove(foundParty);
    }

    @Override
    public Party findByName(String name) {
        for(Party party: politicalParties){
            if (Objects.equals(party.getName(),name)) return party;
            }

        return null;
    }

    @Override
    public Party findById(String id) {
        Party foundParty = null;
        for (Party party : politicalParties) {
            if (party.getId().equals(id)) foundParty = party;

        }
        if (foundParty != null){
            String userInformationId = AppUtils.getUserInformationId(foundParty.getId());
            UserInformation userInformation = userInformationRepository.findById(userInformationId);
            foundParty.setUserInformation(userInformation );
        }
    return  foundParty;

    }
}
