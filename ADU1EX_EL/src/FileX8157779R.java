import java.io.File;
public class FileX8157779R {
    private File file;

    public FileX8157779R(String filePath) {
        this.file = new File(filePath);
    }

    public boolean PermissionsRemover(){
        return file.setReadable(false, false);

    }
}
