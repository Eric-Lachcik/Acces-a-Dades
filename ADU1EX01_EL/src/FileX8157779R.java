import java.io.File;
public class FileX8157779R {
    private File file;

    public FileX8157779R(File file) {
        this.file = file;
    }

    public boolean PermissionsRemover(){
        return file.setWritable(false);
    }

    public boolean PermsViewer(){
        return file.canWrite();
    }

    public boolean PermissionsGranter(){
        return file.setWritable(true);
    }
}
