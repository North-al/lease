package online.northal.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("online.northal.mapper")
public class MybatisPlusConfiguration {
}
