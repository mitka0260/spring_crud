package com.javamaster.spring_crud.dto;

//data transfer object - служит для передачи данных между слоями

//то есть, данные из БД превращаются в эту сущность
//  +служит трансфером между клиентом, контроллером и сервисом.

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data       //генерирует геттеры, сеттеры и др. (аннотация Lombok)
@Builder    //фишка библиотеки Lombok - реализовывает в данном классе паттерн билдер. Теперь можно создавать объекты UsersDto через builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private Integer id;
    private String name;
    private String login;
    private String email;

}

