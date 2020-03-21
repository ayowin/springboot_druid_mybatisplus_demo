package springboot.druid.mybatisplus.demo.mybatisplus.generator;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;

/**
 *  class: MybatisPlusCustomGenerator
 *  brief: 定制版mybatis plus代码生成器，更符合项目直接使用，基于通用版修改
 *      修改项：
 *          从application.yml中获取数据库配置，无需再手动指定。
 *      解决的问题：
 *          自动读取项目中数据库配置
 *  author: ouyangwei
 *  date: 2020.03.21
 *  tips: 所有的配置，需对应application.properties或application.yml中的配置
 */
public class MybatisPlusCustomGenerator {

    /* 自动生成代码作者署名 */
    private static String author = "ouyangwei";

    /* 父包名 */
    private static String parentPackageName = "springboot.druid.mybatisplus.demo";

    /* 模块包名，""为不需要模块 */
    private static String modulePackageName = "";

    /* entity包名 */
    private static String entityPackageName = "entities";
    /* entity文件名规则,""为默认命名 */
    private static String entityNameFormat = "";

    /* mapper包名 */
    private static String mapperPackageName = "mappers";
    /* mapper文件名规则,""为默认命名 */
    private static String mapperNameFormat = "";

    /**
     *  mapper xml包名
     *  注意：本项目需要自行将生成的xml文件移动到classpath: mappers文件夹中
     *  即：resources/mappers
     *  对应application.properties或application.yml中的mybatis plus中mapper-locations配置
     *  原因：生成在src/main/java及其子目录下的所有非*.java文件，都不会参与编译、打包到发
     *      布目录中（即：target目录），推荐将所有的非*.java文件（配置、资源等）放到reso-
     *      urces下，以免导致配置、资源等文件找不到的异常。
     **/
    private static String mapperXmlPackageName = "mappers";
    /* mapper xml文件名规则,""为默认命名 */
    private static String mapperXmlNameFormat = "";

    /* controller包名 */
    private static String controllerPackageName = "controllers";
    /* controller文件名规则,""为默认命名 */
    private static String controllerNameFormat = "";

    /* service包名 */
    private static String servicePackageName = "services";
    /* service文件名规则,""为默认命名 */
    private static String serviceNameFormat = "%sService";

    /* service implement包名 */
    private static String serviceImplPackageName = "services.impls";
    /* service implement文件名规则,""为默认命名 */
    private static String serviceImplNameFormat = "";

    /* 数据库表名，多个表用英文逗号隔开 */
    private static String tableNames = "user,role,permission,token";

    public static void main(String[] args) throws Exception {

        /* 代码生成器 */
        AutoGenerator autoGenerator = new AutoGenerator();

        /* 全局配置 */
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        globalConfig.setAuthor(author);
        /* 生成完成是否打开输出目录: xxx/src/main/java */
        globalConfig.setOpen(false);
        autoGenerator.setGlobalConfig(globalConfig);
        /**
         *  命名格式配置
         *  命名格式请查官方文档：
         *  https://mp.baomidou.com/config/generator-config.html
         **/
        globalConfig.setEntityName(entityNameFormat);
        globalConfig.setMapperName(mapperNameFormat);
        globalConfig.setXmlName(mapperXmlNameFormat);
        globalConfig.setControllerName(controllerNameFormat);
        globalConfig.setServiceName(serviceNameFormat);
        globalConfig.setServiceImplName(serviceImplNameFormat);

        /* 数据源配置 */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        /* 读取application.yml */
        String applicationYamlPath = Thread.currentThread()
                .getContextClassLoader()
                .getResource("")
                .getPath()
                + "application.yml";
//        System.out.println(applicationYamlPath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(applicationYamlPath));
        StringBuffer content = new StringBuffer();
        String line = "";
        line = bufferedReader.readLine();
        while (line != null){
            content.append(line);
            content.append('\n');
            line = "";
            line = bufferedReader.readLine();
        }
//        System.out.println(content.toString());
        Yaml applicationYaml = new Yaml();
        HashMap<String,Object> allYamlObject = applicationYaml.load(content.toString());
//        System.out.println(allYamlObject);
        HashMap<String,Object> springObject = (HashMap<String,Object>)allYamlObject.get("spring");
//        System.out.println(springObject);
        HashMap<String,Object> datasourceObject = (HashMap<String,Object>)springObject.get("datasource");
//        System.out.println(datasourceObject);
//        System.out.println(datasourceObject.get("url"));
//        System.out.println(datasourceObject.get("driver-class-name"));
//        System.out.println(datasourceObject.get("username"));
//        System.out.println(datasourceObject.get("password"));
        dataSourceConfig.setUrl(datasourceObject.get("url").toString());
        dataSourceConfig.setDriverName(datasourceObject.get("driver-class-name").toString());
        dataSourceConfig.setUsername(datasourceObject.get("username").toString());
        dataSourceConfig.setPassword(datasourceObject.get("password").toString());
        autoGenerator.setDataSource(dataSourceConfig);

        /* 包配置 */
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(parentPackageName);
        packageConfig.setModuleName(modulePackageName);
        packageConfig.setEntity(entityPackageName);
        packageConfig.setMapper(mapperPackageName);
        packageConfig.setXml(mapperXmlPackageName);
        packageConfig.setController(controllerPackageName);
        packageConfig.setService(servicePackageName);
        packageConfig.setServiceImpl(serviceImplPackageName);
        autoGenerator.setPackageInfo(packageConfig);

        /* 策略配置 */
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        /* 是否使用lombok */
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(tableNames.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(packageConfig.getModuleName() + "_");
        autoGenerator.setStrategy(strategy);

        autoGenerator.execute();
    }

}
