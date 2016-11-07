package httpfs.object;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileObject {

	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	private static int BYTE_SIZE = 1024;

	private String name;
	private String path;

	private long size;
	private Date lastModified;

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

	public String getSize() {
		if (size < BYTE_SIZE) {
			return size + " B";
		} else if (size > BYTE_SIZE * BYTE_SIZE) {
			return size / BYTE_SIZE / BYTE_SIZE + " MB";
		} else {
			return size / BYTE_SIZE + " KB";
		}
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getLastModified() {
		return DATE_FORMAT.format(lastModified);
	}

	public void setLastModified(long lastModified) {
		this.lastModified = new Date(lastModified);
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
