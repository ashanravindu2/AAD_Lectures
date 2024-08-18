package lk.ijse.gdse.notetaker.util;

import java.util.Random;
import java.util.UUID;

public class AppUtil {
    public static String createNoteId(){
     /*   return "N"+System.currentTimeMillis();*/
       // return "N"+ UUID.randomUUID().toString();
        return "N"+new Random().nextInt(10000);


    }
}
