package co.zhanglintc.springcloudprovider.controller;

import co.zhanglintc.springcloudapi.pojo.Student;
import co.zhanglintc.springcloudprovider.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/")
    public Object index() {
        Map<String, Object> restResult = new HashMap<>();

        Student student = new Student(8002L, null, 22, "");
        studentDao.insert(student);
        restResult.put("selectMaps", studentDao.selectMaps(null));
        studentDao.delete(null);

        return restResult;
    }
}
