package kz.daulatbek.onlinecourseplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MamadalievDaulatbekOnlineCoursePlatformApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                MamadalievDaulatbekOnlineCoursePlatformApplication.class,
                args
        );
    }
}