import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AccesFileOutputX8157779R {
    private String sourceFile;
    private String destFile;

    public AccesFileOutputX8157779R(String sourceFile, String destFile) {
        this.sourceFile = sourceFile;
        this.destFile = destFile;
    }

    public void copyFile() throws IOException {
        try (FileInputStream FileInput = new FileInputStream(sourceFile);
             FileOutputStream FileOutput = new FileOutputStream(destFile))
        {
            int data;
            while ((data = FileInput.read()) != -1) {
                FileOutput.write(data);
            }
            FileInput.close();
            FileOutput.close();
            System.out.println("File copied" + destFile);
        } catch (IOException e) {
            throw new IOException("Error copying");
        }
    }
}
