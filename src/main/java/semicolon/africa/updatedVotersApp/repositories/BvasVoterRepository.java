package semicolon.africa.updatedVotersApp.repositories;

import semicolon.africa.updatedVotersApp.models.Voter;
import semicolon.africa.updatedVotersApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasVoterRepository implements VoterRepository{
    List<Voter> voterList = new ArrayList<>();

    @Override
    public Voter findById(String id) {
        for(Voter voter : voterList){
            if(voter.getId().equals(id)) return voter;
        }
        return null;
    }

    @Override
    public List<Voter> findAll() {
        return voterList;
    }

    @Override
    public void deleteById(String id) {
        Voter foundVoter =  findById(id);
       if(foundVoter != null) voterList.remove(foundVoter);
    }

    @Override
    public Voter save(Voter voter) {
        String id = AppUtils.generatedId();
        voter.setId(id);
        voterList.add(voter);
        return voter;
    }
//    int lastIdCreated;
//    int idCounter = 1;
//    List<Voter>voterList = new ArrayList<>();
//
//    @Override
//    public Voter findById(String id) {
//        for(Voter voter : voterList){
//            if(Objects.equals(voter.getId(), id))return voter;
//        }
//        return null;
//    }
//
//    @Override
//    public List<Voter> findAll() {
//        return voterList;
//    }
//
//    @Override
//    public Voter save(Voter voter) {
//        Voter createVoter = new Voter();
//        createVoter.setName(voter.getName());
//        createVoter.setGender(voter.getGender());
//        createVoter.setAddress(voter.getAddress());
//        createVoter.setAge(voter.getAge());
//        createVoter.setVoterIdentificationNumber(voter.getVoterIdentificationNumber());
//        createVoter.setId( idCounter + "");
//        idCounter++;
//        voterList.add(createVoter);
//        return voter;
//    }
//
//    @Override
//    public void deleteById(String id) {
//
//    }
//
//
//    @Override
//    public int count() {
//        return voterList.size();
//    }
}
