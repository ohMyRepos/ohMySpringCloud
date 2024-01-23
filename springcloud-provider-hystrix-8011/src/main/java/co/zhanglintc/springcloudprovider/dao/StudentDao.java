package co.zhanglintc.springcloudprovider.dao;

import co.zhanglintc.springcloudapi.pojo.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StudentDao extends BaseMapper<Student> {
}
