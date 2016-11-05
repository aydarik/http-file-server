package httpfs.controller;

import httpfs.dao.FileService;
import httpfs.exception.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Controller
@PropertySource("classpath:message.properties")
public class FileController {

    @Value("${file.upload.success}")
    private String msgFileSuccess;

    @Autowired
    private FileService fileService;

    @ModelAttribute("fileList")
    public List<File> fileList() {

        // TODO: return JSON + AJAX request

        return fileService.list();
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    String handleFileUpload(@RequestParam("name") String name,
                            @RequestParam("path") String path,
                            @RequestParam("file") MultipartFile file) {

        // TODO: return JSON

        try {
            fileService.upload(path + "/" + name, file);
            return msgFileSuccess;
        } catch (FileUploadException e) {
            return e.getMessage();
        }
    }
}
