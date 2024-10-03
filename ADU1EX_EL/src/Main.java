import java.io.*;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws IOException {
        String OriginalPathTXT = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Original.txt";
        File OriginalFileTXT = new File(OriginalPathTXT);
        String CopyPathTXT = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Copied.txt";
        File CopyFileTXT = new File(CopyPathTXT);
        String OriginalPathJPG = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Pingu.jpg";
        File OriginalFileJPG = new File(OriginalPathJPG);
        String CopyPathJPG = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Copied1.txt";
        File CopyFileJPG = new File(CopyPathJPG);

        AccesFileInputX8157779R FileInputer = new AccesFileInputX8157779R(OriginalPathTXT);
        AccesFileReaderX8157779R FileReader = new AccesFileReaderX8157779R(OriginalPathJPG);
        AccesFileWriterX8157779R FileWriter = new AccesFileWriterX8157779R(OriginalFileTXT, CopyFileTXT);
        AccesFileOutputX8157779R FileOutputer = new AccesFileOutputX8157779R(OriginalFileJPG, CopyFileJPG);
        FileX8157779R FileFilerPng = new FileX8157779R(CopyFileTXT);
        FileX8157779R FileFilerJpg = new FileX8157779R(CopyFileJPG);
        String extension = getFileExtension(OriginalPathTXT);

        if (extension.equals("txt")) {
            try {
                FileFilerPng.PermissionsGranter();
                FileWriter.copyFile();
                System.out.print("Results of the copied file: ༼ つ ◕_◕ ༽つ ");
                FileReader.readFile();
                if (FileFilerPng.PermissionsRemover()) {
                    System.out.println("Write perms removed");
                    try {
                        FileWriter.copyFile();
                    } catch (IOException e) {
                        System.out.println("YOU CAN NOT READ FILE");
                    }
                } else {
                    System.out.println("Write perms not  removed");
                }
            } catch (IOException e) {
                System.out.println("Error: File Not Copied or Found " + e.getMessage());
            }
        } else if (extension.equals("jpg")) {
            try {
                FileFilerJpg.PermissionsGranter();
                FileOutputer.copyFile();
                System.out.print("Results of the copied file: ༼ つ ◕_◕ ༽つ ");
                FileInputer.readFile();
                if (FileFilerJpg.PermissionsRemover()) {
                    System.out.println("Write perms removed");
                    try {
                        FileOutputer.copyFile();
                    } catch (IOException e) {
                        System.out.println("YOU CAN NOT READ FILE");
                    }
                } else {
                    System.out.println("Write perms not  removed");
                }
            } catch (IOException e) {
                System.out.println("Error: File Not Copied or Found " + e.getMessage());
            }
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