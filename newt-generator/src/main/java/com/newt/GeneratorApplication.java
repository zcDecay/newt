package com.newt;

import org.mybatis.generator.api.ShellRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Description 引入了mybatis-spring-boot-starter，需要记载加载数据源，没有使用需要排除
 * @Author zcc
 * @Date 18/09/14
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class GeneratorApplication {
    public static void main(String[] args) {
        args = new String[] { "-configfile", "D:\\GitHubWorkSpace\\GitRepository\\newt\\newt-generator\\src\\main\\resources\\generator\\generatorConfig.xml", "-overwrite" };
        ShellRunner.main(args);
    }
}
