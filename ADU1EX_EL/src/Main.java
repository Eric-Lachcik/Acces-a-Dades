import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        String OriginalPathTXT = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Original.txt";
        String CopyPathTXT = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Copied.txt";
        String OriginalPathJPG = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Pingu.jpg";
        String CopyPathJPG = "C:\\DAM2\\Acces-a-Dades\\ADU1EX_EL\\Copied1.txt";

        AccesFileWriterX8157779R FileWriter = new AccesFileWriterX8157779R(OriginalPathTXT, CopyPathTXT);
        AccesFileOutputX8157779R FileOutputer = new AccesFileOutputX8157779R(OriginalPathJPG, CopyPathJPG);
        String extension = getFileExtension(OriginalPathTXT);
        if(extension.equals("txt")){
            try{
                FileWriter.copyFile();
                try {
                    File Fichero = new File(CopyPathTXT);
                    Fichero.setReadable(false);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }catch (IOException e){
                System.out.println("Error: File Not Copied or Found " + e.getMessage() );
            }
        }else if(extension.equals("jpg")){
            FileOutputer.copyFile();
            System.out.println("Successfully copied the copy file");
        }

    }

    public static String getFileExtension(String filePath)
    {
        int lastIndexOfDot = filePath.lastIndexOf('.');
        if (lastIndexOfDot == -1) {
            return "No extension";
        }

        return filePath.substring(lastIndexOfDot + 1);
    }
}