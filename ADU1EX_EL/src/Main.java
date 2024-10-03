import java.io.*;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws IOException {
        String OriginalPathTXT = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Original.txt";
        String CopyPathTXT = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Copied.txt";
        String OriginalPathJPG = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Pingu.jpg";
        String CopyPathJPG = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Copied1.txt";

        AccesFileInputX8157779R FileInputer = new AccesFileInputX8157779R(OriginalPathTXT);
        AccesFileReaderX8157779R FileReader = new AccesFileReaderX8157779R(OriginalPathJPG);
        AccesFileWriterX8157779R FileWriter = new AccesFileWriterX8157779R(OriginalPathTXT, CopyPathTXT);
        AccesFileOutputX8157779R FileOutputer = new AccesFileOutputX8157779R(OriginalPathJPG, CopyPathJPG);
        FileX8157779R FileFiler = new FileX8157779R(OriginalPathTXT);
        String extension = getFileExtension(OriginalPathTXT);
        if (extension.equals("txt")) {
            try {
                FileWriter.copyFile();
                if(FileFiler.PermissionsRemover()){
                    System.out.println("Read perms removed");
                }else {
                    System.out.println("Read perms not removed");
                }
                try {
                    FileInputer.readFile();
                } catch (IOException e) {
                    System.out.println("YOU CAN NOT READ FILE");
                }
            } catch (IOException e) {
                System.out.println("Error: File Not Copied or Found " + e.getMessage());
            }
        } else if (extension.equals("jpg")) {
            FileOutputer.copyFile();
            try {

                System.out.println("Entro");
                try {
                    FileReader.readFile();
                    System.out.println("Entro mas");
                } catch (IOException e) {
                    System.out.println("YOU CAN NOT READ FILE");
                }
            } catch (Exception e) {
                System.out.println("No la puso " + e.getMessage());
                throw new RuntimeException(e);
            }
            System.out.println("Successfully copied the copy file");
        }

    }

    public static String getFileExtension(String filePath) {
        int lastIndexOfDot = filePath.lastIndexOf('.');
        if (lastIndexOfDot == -1) {
            return "No extension";
        }

        return filePath.substring(lastIndexOfDot + 1);
    }
}