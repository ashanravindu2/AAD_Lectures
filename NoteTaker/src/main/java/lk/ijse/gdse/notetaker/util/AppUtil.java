package lk.ijse.gdse.notetaker.util;

import java.util.Base64;
import java.util.Random;
import java.util.UUID;

public class AppUtil {
    public static String createNoteId(){
        /*   return "N"+System.currentTimeMillis();*/
        // return "N"+ UUID.randomUUID().toString();
        return "NOTE"+new Random().nextInt(10000);
    }

    public static String createUserId(){
        /*   return "N"+System.currentTimeMillis();*/
        // return "N"+ UUID.randomUUID().toString();
        return "USER"+new Random().nextInt(10000);
    }

    public static String toBase64ProfilePic(String profilrPic){
        return Base64.getEncoder().encodeToString((profilrPic.getBytes()));
    }

}
