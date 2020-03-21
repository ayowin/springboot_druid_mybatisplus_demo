package springboot.druid.mybatisplus.demo.mybatisplus.generator;


import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 *  class: MybatisPlusGeneralGenerator
 *  brief: 通用版mybatis plus代码生成器，基于官网定制
 *  author: ouyangwei
 *  date: 2020.03.20
 *  tips: 所有的配置，需对应application.properties或application.yml中的配置
 */
public class MybatisPlusGeneralGenerator {

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
    private static String tableNames = "user,role";

    public static void main(String[] args) {

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
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/springboot_druid_mybatisplus_demo?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
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
