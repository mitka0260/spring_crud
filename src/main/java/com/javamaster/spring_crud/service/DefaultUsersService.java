package com.javamaster.spring_crud.service;

import com.javamaster.spring_crud.dto.UsersDto;
import com.javamaster.spring_crud.entity.Users;
import com.javamaster.spring_crud.exception.ValidationException;
import com.javamaster.spring_crud.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

//Здесь - реализация методов UsersService

@Service            //чтобы внедрить его в контроллер
@AllArgsConstructor //здесь ломбок сам инициализирует обе private в конструкторе
public class DefaultUsersService implements UsersService {

    private final UsersRepository usersRepository;  //внедрение зависимостей через конструктор
    private final UsersConverter usersConverter;    //ломбок поможет

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {    //на вход приходит объект UsersDto
        validateUserDto(usersDto);  //Мы должны провалидировать данные
        Users savedUser = usersRepository.save(usersConverter.fromUserDtoToUser(usersDto)); //конвертация UserDto в Users - затем сохраняю в БД
        return usersConverter.fromUserToUserDto(savedUser); //опять конвертирую в UserDto
        //вроде можно просто return usersDto;
    }

    //проверим чтобы объект UsersDto не был пустым и чтобы поле логин было заполнено
    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
        if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
        //здесь нет проверки, что email в правильном формате
    }


    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = usersRepository.findByLogin(login);
        if (users != null) {
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }

}
