import java.io.FileInputStream;
import java.io.IOException;

public class AccesFileInputX8157779R {
    private String filePath;

    public AccesFileInputX8157779R(String filePath) {
        this.filePath = filePath;
    }

    public void readFile() throws IOException {
        try (FileInputStream FileInput = new FileInputStream(filePath))
        {
            int data;
            System.out.println("Reading file");
            while ((data = FileInput.read()) != -1) {
                System.out.print((char) data);
            }
            FileInput.close();
            System.out.println();
        } catch (IOException e) {
            throw new IOException("File not readable");
        }
    }
}

