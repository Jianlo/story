import com.jian.dao.RoleMapper;
import com.jian.entity.Role;
import com.jian.service.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {


    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleMapper roleMapper = (RoleMapper) context.getBean("roleMapper");
        List<Role> roles = roleMapper.queryAll();
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = (RoleService) context.getBean("roleService");
        List<Role> roles = roleService.queryAll();
        for (Role role : roles) {
            System.out.println(role);
        }
    }
}
