import java.io.FileReader;
import java.io.IOException;

public class AccesFileReaderX8157779R {
    private String filePath;

    public AccesFileReaderX8157779R(String filePath) {
        this.filePath = filePath;
    }
    public void readFile() throws IOException {
        try (FileReader FileReader = new FileReader(filePath)) {
            int data;
            System.out.println("Reading File by Char");
            while ((data = FileReader.read()) != -1) {
                System.out.print((char) data);
            }
            FileReader.close();
            System.out.println();
        }catch (IOException e) {
            throw new IOException("File not readable");
        }
    }
}

