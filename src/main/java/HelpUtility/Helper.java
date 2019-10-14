package HelpUtility;

import java.util.Random;

//simple help utility class
//e.g. to create emails
public class Helper {

    private static final int LOCAL_LENGTH = 12;
    private static final String LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-_";

    //return an random email address
    public String generateRandomEmail() {
        return  generateLocalPart() + "@test" + getRandNumber() + ".com";
    }

    //generate the local part of the email address
    private String generateLocalPart() {
        StringBuffer addr = new StringBuffer();
        for(int i=0; i<LOCAL_LENGTH; i++) {
            int num = getRandNumber();
            char c = LIST.charAt(num);
            addr.append(c);
        }
        return addr.toString();
    }

    //random integer used as an index and part of domain address
    private int getRandNumber() {
        int randNum = 0;
        Random generator = new Random();
        randNum = generator.nextInt(LIST.length()-1);
        return randNum;
    }

}
