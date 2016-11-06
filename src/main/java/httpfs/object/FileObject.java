package httpfs.object;

import java.io.File;

public class FileObject {

    private String name;
    private String path;

    private long size;
    private long lastModified;

    private boolean isFile;
    private boolean isHidden;

    public static FileObject fromFile(File file) {
        FileObject object = new FileObject();
        object.setName(file.getName());
        object.setPath(file.getPath());
        object.setSize(file.length());
        object.setLastModified(file.lastModified());
        object.setFile(file.isFile());
        object.setHidden(file.isHidden());

        return object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getLastModified() {
        return lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }
}
