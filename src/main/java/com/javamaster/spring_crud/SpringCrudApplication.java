package com.javamaster.spring_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//указывает что приложение будет запускаться как Spring Boot приложение
//также указывает спрингу, что для всего что у нас есть в файле зависимостей pom.xml нужно подключить авто конфигурацию

@SpringBootApplication
//часть автоконфигураций можно отключить
//@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class, AnotherClassConfigToExclude.class})
public class SpringCrudApplication {

	//точка входа в приложение
    public static void main(String[] args) {
    	SpringApplication.run(SpringCrudApplication.class, args);
    }

}
