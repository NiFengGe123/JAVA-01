package geek.study.demo;

import com.alibaba.fastjson.JSONObject;
import geek.study.work02.Student;
import geek.study.work03.JdbcCode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "geek.study.work03")
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);

        // 通过 spring boot 实现自动装配
        Student student = (Student) applicationContext.getBean("student01");
        System.out.println(JSONObject.toJSONString(student));

        //jdbc 操作库
        JdbcCode jdbcCode = (JdbcCode) applicationContext.getBean("jdbcCode");
        //执行一次 jdbc
        jdbcCode.addOneInfo();
        //批量执行 连接池
        try {
            jdbcCode.addBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean(name = "student01")
    public Student getStudent() {
        return new Student();
    }


}
