import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class AccesFileOutputX8157779R {
    private String sourceFile;
    private String destFile;

    public AccesFileOutputX8157779R(String sourceFile, String destFile) {
        this.sourceFile = sourceFile;
        this.destFile = destFile;
    }

    public void copyFile() throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("File copied byte by byte to: " + destFile);
        } catch (IOException e) {
            throw new IOException("Error copying file byte by byte.");
        }
    }
}
