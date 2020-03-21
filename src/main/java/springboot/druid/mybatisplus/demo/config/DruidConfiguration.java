package springboot.druid.mybatisplus.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@Configuration
public class DruidConfiguration {

    /**
     *  将自定义的 Druid数据源添加到容器中，不再让 Spring Boot 自动创建
     *  @ConfigurationProperties(prefix = "spring.datasource")：作用就是将application.yml或
     *  application.properties中的属性绑定到该bean上，作为初始化参数注入该bean
     *  方法： prefix = "xxx.xxx"
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return  new DruidDataSource();
    }

    /* druid 数据监控DashBoard Servlet */
    @Bean
    public ServletRegistrationBean statViewSevlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean();

        bean.setServlet(new StatViewServlet());

        /* 服务于/druid/* */
        bean.setUrlMappings(Arrays.asList("/druid/*"));

        /* 以下代码块：初始化Servlet */
        HashMap<String,String> initParameters = new HashMap<>();
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");
        /* 允许访问ip: ""为所有人，"localhost"为本机，"xxx.xxx.xxx.xxx"为指定ip */
        initParameters.put("allow","");
        /* 拒绝访问ip: ""为所有人，"localhost"为本机，"xxx.xxx.xxx.xxx"为指定ip */
//        initParameters.put("deny","");
        bean.setInitParameters(initParameters);

        return bean;
    }

    /* druid 数据监控DashBoard Filter */
    @Bean
    public FilterRegistrationBean statViewFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        /* 过滤于所有请求 */
        bean.setUrlPatterns(Arrays.asList("/*"));

        HashMap<String,String> initParameters = new HashMap<>();
        /* 不监控的url */
        initParameters.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);

        return bean;
    }
}
