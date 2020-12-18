package com.javamaster.spring_crud.entity;

/*
слой доступа к базе данных.
Создаем сперва класс отображения сущности.
Если у нас таблица users_table нужно создать класс, который будет ее отображением в java.

В данном классе создадим поля, которые есть в базе и навешаем на наш класс и поля аннотации
java persistence: Table, Entity, Column, Id.

Чтобы избежать написание геттеров, сеттеров, equals, hashCode, toString,
я воспользуюсь аннотациями библиотеки Lombok.
 */

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="users_table")
@Data   //ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor  //ломбок аннотация: конструктор без аргуметов
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String login;

    @Column
    private String email;

}
