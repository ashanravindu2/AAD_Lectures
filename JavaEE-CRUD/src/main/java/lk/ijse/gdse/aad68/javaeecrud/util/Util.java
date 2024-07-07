package lk.ijse.gdse.aad68.javaeecrud.util;

import java.util.UUID;

public class Util {
    public static String idGenerator(){

        /* ** This is how you can generate a UUID,
         UUID is a 128-bit number used to identify information in computer systems and
         it can be used to generate a unique identifier for an object.*/
        return UUID.randomUUID().toString();
    }
}
