package co.zhanglintc.springcloudprovider.controller;

import co.zhanglintc.springcloudapi.pojo.Student;
import co.zhanglintc.springcloudprovider.dao.StudentDao;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @Autowired
    private StudentDao studentDao;
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @HystrixCommand(fallbackMethod = "fallbackIndex")
    @RequestMapping("/")
    public Object index() throws RuntimeException {
        Map<String, Object> restResult = new HashMap<>();

        Student student = new Student(8011L, "hystrix-normal", 22, "");
        studentDao.delete(null);
        studentDao.insert(student);
        restResult.put("selectMaps", studentDao.selectMaps(null));
        studentDao.delete(null);

        long millis = System.currentTimeMillis();
        if (millis % 3 == 0) {
            RuntimeException ex = new RuntimeException("goto hystrix fallback");
            logger.error(ex.toString());
            throw ex;
        }

        return restResult;
    }

    private Object fallbackIndex() {
        Map<String, Object> restResult = new HashMap<>();

        Student student = new Student(8011L, "hystrix-fallback", 22, "");
        studentDao.insert(student);
        restResult.put("selectMaps", studentDao.selectMaps(null));
        studentDao.delete(null);

        return restResult;
    }
}
