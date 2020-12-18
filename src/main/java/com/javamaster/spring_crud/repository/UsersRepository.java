package com.javamaster.spring_crud.repository;

import com.javamaster.spring_crud.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> { //<сущность, с которой работает, тип первичного ключа>

    //CRUD методы по работе с сущностью уже встроенны в JpaRepository
    //save(), saveAll(), delete(), findById()
    Users findByLogin(String login);

}
