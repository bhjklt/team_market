package team.market.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class Base64Util {

    public static String encoder(InputStream in) {
        String encoderString = null;
        ByteArrayOutputStream output = null;
        Base64.Encoder encoder = Base64.getEncoder();
        int len = 0;
        byte[] buff = new byte[1024];
        try {
            output = new ByteArrayOutputStream();
            while((len = in.read(buff)) != -1) {
                output.write(buff, 0, len);
            }
            encoderString = encoder.encodeToString(output.toByteArray());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        return encoderString;
    }



    public static byte[] decoder(String encodeString) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decode = decoder.decode(encodeString);
        return decode;
    }

}
