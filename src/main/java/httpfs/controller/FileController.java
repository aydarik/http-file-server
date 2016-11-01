package httpfs.controller;

import httpfs.dao.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @ModelAttribute("fileList")
    public List<String> fileList() {
        return fileService.list();
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/add")
    public String add(@RequestParam(value = "name", required = false, defaultValue = "new") String name) {
        fileService.add(name);
        return "index";
    }

    @RequestMapping("/clear")
    public String clear() {
        fileService.clear();
        return "index";
    }
}
