package com.proj3.videoapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.proj3.videoapp.Dao")
/**
 * 指定所扫的包，会自动扫描指定包下的全部标有@Component的类，并注册成bean，
 * 当然包括@Component下的子注解@Service,@Repository,@Controller。
 * @author 85060
 *
**/

public class VideoappApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoappApplication.class, args);
    }

}
