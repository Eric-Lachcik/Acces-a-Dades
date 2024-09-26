import com.sun.security.jgss.GSSUtil;

import java.io.*;
public class AccesFileInputX8157779R {

    public int ByteReader(String variable){
        InputStream input = new FileInputStream(variable);

        int data = 0;
        try {
            data = input.read();
            while(data != -1) {

                data = input.read();
            }
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
            System.out.println("Ha Fallado el FileInputStream");
            System.out.print(e.getMessage());
        }
        return data;
    }

}
