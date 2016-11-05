package httpfs.dao;

import httpfs.exception.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@PropertySource("classpath:message.properties")
public class FileService {

    @Value("${file.upload.empty}")
    private String msgFileEmpty;

    @Value("${file.upload.exists}")
    private String msgFileExists;

    public List<File> list() {
        List<File> files = new ArrayList<File>();

        File folder = new File("files");
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                files.add(file);
            }
        }

        return files;
    }

    public void upload(String pathname, MultipartFile content) throws FileUploadException {
        File file = new File(pathname);
        if (!file.exists()) {
            if (!content.isEmpty()) {
                try {
                    byte[] bytes = content.getBytes();
                    BufferedOutputStream stream =
                            new BufferedOutputStream(new FileOutputStream(file));
                    stream.write(bytes);
                    stream.close();
                } catch (IOException e) {
                    throw new FileUploadException(e.getLocalizedMessage());
                }
            } else {
                throw new FileUploadException(msgFileEmpty);
            }
        } else {
            throw new FileUploadException(msgFileExists);
        }
    }

    public void remove(File file) {

    }
}
