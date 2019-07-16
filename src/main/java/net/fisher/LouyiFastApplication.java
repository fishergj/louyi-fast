package net.fisher;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("net.fisher.project.*.*.mapper")
public class LouyiFastApplication {
	public static void main(String[] args) {
		SpringApplication.run(LouyiFastApplication.class, args);
	}
}
