import java.io.FileInputStream;
import java.io.IOException;

public class AccesFileInputX8157779R {
    private String filePath;

    public AccesFileInputX8157779R(String filePath) {
        this.filePath = filePath;
    }

    public void readFile() throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int data;
            System.out.println("Reading file byte by byte:");
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println(); // Newline after reading
        } catch (IOException e) {
            throw new IOException("File cannot be read (byte by byte).");
        }
    }
}

