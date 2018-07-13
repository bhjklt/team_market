package team.market.common.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.InputStream;

public class FileUtil {

    public static String copyFileInput(InputStream input,String toPath,String fileName){
        String newFilePath = null;
        try{
            newFilePath = toPath+"\\"+makeFileName(fileName);
            OutputStream out = new FileOutputStream(newFilePath,true);
            int len = 0;
            byte[] buf = new byte[128];
            while ((len = input.read(buf))!=-1) {
                out.write(buf,0,len);
            }
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return newFilePath;
    }


    public static String makeFileName(String filename) {
        return UUIDUtils.get8UUID()+filename;
    }
}
