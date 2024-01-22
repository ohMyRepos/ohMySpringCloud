package co.zhanglintc.springcloudapi.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("Student")
public class Student implements Serializable {
    private Long id;
    private String name;
    private Integer age;

    @TableField("e_mail")
    private String email;
}
