import java.io.*;
public class AccesFileOutputX8157779R {

    public String ByteWriter(String variable, int data){
        FileOutputStream output = new FileOutputStream(variable);
        try {
            output.write(data);
            while(data != 0) {
                output.write(data);

            }
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return variable;
    }
}
