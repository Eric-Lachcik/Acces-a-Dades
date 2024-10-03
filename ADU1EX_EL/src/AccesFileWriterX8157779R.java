import java.io.*;
public class AccesFileWriterX8157779R {
    private File sourceFile;
    private File destFile;

    public AccesFileWriterX8157779R(File sourceFile, File destFile) {
        this.sourceFile = sourceFile;
        this.destFile = destFile;
    }

    public void copyFile() throws IOException {
        try (FileReader FileReader = new FileReader(sourceFile);
            FileWriter FileWriter = new FileWriter(destFile))
        {
            int data;
            while((data = FileReader.read()) != -1){
                FileWriter.write(data);
            }
            FileWriter.close();
            System.out.println("File copied");
        } catch (IOException e) {
            throw new IOException("File not writeable");
        }
    }
}
