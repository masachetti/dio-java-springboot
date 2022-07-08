package dio.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DioJavaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioJavaSpringbootApplication.class, args);
	}

}
