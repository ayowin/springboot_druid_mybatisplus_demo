package springboot.druid.mybatisplus.demo;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.druid.mybatisplus.demo.mappers.PermissionMapper;
import springboot.druid.mybatisplus.demo.mappers.RoleMapper;
import springboot.druid.mybatisplus.demo.mappers.TokenMapper;
import springboot.druid.mybatisplus.demo.mappers.UserMapper;
import springboot.druid.mybatisplus.demo.services.PermissionService;
import springboot.druid.mybatisplus.demo.services.RoleService;
import springboot.druid.mybatisplus.demo.services.TokenService;
import springboot.druid.mybatisplus.demo.services.UserService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	DataSource dataSource;

	@Autowired
	UserService userService;
	@Autowired
	UserMapper userMapper;
	@Autowired
	RoleService roleService;
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	PermissionService permissionService;
	@Autowired
	PermissionMapper permissionMapper;
    @Autowired
	TokenService tokenService;
    @Autowired
	TokenMapper tokenMapper;

	@Test
	public void testDruidDataSource() throws SQLException {
		System.out.println("========Test: testDruidDataSource()===========");

		System.out.println("datasource: " + dataSource.getClass().getName());
		//获得连接
		Connection connection = dataSource.getConnection();
		System.out.println(connection);

		DruidDataSource druidDataSource = (DruidDataSource) dataSource;
		System.out.println("druidDataSource initialSize: " + druidDataSource.getInitialSize());
		System.out.println("druidDataSource maxActive: " + druidDataSource.getMaxActive());
		System.out.println("druidDataSource filters: " + druidDataSource.getFilterClassNames());
		System.out.println("druidDataSource useGlobalDataSourceStat: " + druidDataSource.isUseGlobalDataSourceStat());

		//关闭连接
		connection.close();
	}

	@Test
	public void testMybatisPlus(){
		System.out.println("========Test: testMybatisPlus()===========");
		System.out.println(userService);
		System.out.println(userMapper);
		System.out.println(roleService);
		System.out.println(roleMapper);
		System.out.println(permissionService);
		System.out.println(permissionMapper);
		System.out.println(tokenService);
		System.out.println(tokenMapper);
	}
}
