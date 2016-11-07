package httpfs.controller;

import httpfs.dao.FileService;
import httpfs.exception.FileUploadException;
import httpfs.object.FileObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public
	@ResponseBody
	List<FileObject> list(@RequestParam(value = "path", required = false, defaultValue = "files") String path) {
		return fileService.list(path);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json")
	public
	@ResponseBody
	FileObject upload(@RequestParam(value = "path", required = false, defaultValue = "files") String path,
	                  @RequestParam("file") MultipartFile file) throws FileUploadException {
		return fileService.upload(path, file);
	}

	@RequestMapping(value = "/del", method = RequestMethod.POST, produces = "application/json")
	public
	@ResponseBody
	boolean upload(@RequestParam(value = "path", required = false, defaultValue = "files") String path,
	               @RequestParam("name") String name) throws FileUploadException {
		return fileService.delete(path, name);
	}
}
