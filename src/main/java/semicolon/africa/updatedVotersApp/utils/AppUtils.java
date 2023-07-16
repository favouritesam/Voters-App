package semicolon.africa.updatedVotersApp.utils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    private  static  int currentId;

    private final static Map<String,String> userInformationJoinTable = new HashMap<>();
    public  static  final int ZERO = BigInteger.ZERO.intValue();

    public  static  final int ONE = BigInteger.valueOf(1).intValue();
    public static  final  int FIVE = BigInteger.valueOf(5).intValue();
    public static  final  int EIGHT = BigInteger.valueOf(8).intValue();
    public static String generatedId(){
        currentId+=1;
        int generatedId = currentId;
        return String.valueOf(generatedId);
    }

    public static  void linkUserToUserInformation(String userId, String userInformationId){
        userInformationJoinTable.put(userId,userInformationId);
    }

    public static String getUserInformationId(String userId){
        String userInformationId = userInformationJoinTable.get(userId);
        if (userInformationJoinTable.containsKey(userId))
            return userInformationId;
        return "ERROR: INCORRECT KEY";
    }
}
