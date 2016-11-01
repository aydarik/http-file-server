package httpfs.dao;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    private final List<String> list = new ArrayList<String>();

    public List<String> list() {
        return list;
    }

    public void add(String fileName) {
        list.add(fileName);
    }

    public void clear() {
        list.clear();
    }
}
