package com.example.sistemaJava.service;

import com.example.sistemaJava.dto.User;
import com.example.sistemaJava.dto.UserDTOGenerator;
import com.example.sistemaJava.exceptions.LoginAlreadyExistsException;
import com.example.sistemaJava.exceptions.PasswordVerifyCaracterSpecialException;
import com.example.sistemaJava.exceptions.PasswordVerifyCaractersException;
import com.example.sistemaJava.exceptions.PasswordVerifyNumberException;
import com.example.sistemaJava.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Test
    public void shouldSucessCreate() {
        User user = UserDTOGenerator.buildFullCreateDTO();

        Mockito.when(repository.save(any())).thenReturn(user);

        User userCreated = service.saveUser(user);

        Assertions.assertEquals("Anderson749", userCreated.getDcrUsuario());
        Assertions.assertEquals("AndersonSantiago", userCreated.getDcrLogin());
        Assertions.assertEquals("Anderson123#", userCreated.getDcrSenha());

        Mockito.verify(repository, times(1)).save(any());

    }

    @Test
    public void shouldSucessUpdate() {
        User user = UserDTOGenerator.buildFullUpdateDTO();

        Mockito.when(repository.save(any())).thenReturn(user);

        User userUpdated = service.saveUser(user);

        Assertions.assertEquals(1L, userUpdated.getIdcadusuario());
        Assertions.assertEquals("Anderson749", userUpdated.getDcrUsuario());
        Assertions.assertEquals("Anderson74", userUpdated.getDcrLogin());
        Assertions.assertEquals("Anderson321#", userUpdated.getDcrSenha());

        Mockito.verify(repository, times(1)).save(any());
    }

    @Test
    public void shouldExeceptionLogin() {
        User user = UserDTOGenerator.buildExistsLogin();

        Mockito.when(repository.existsByDcrLogin(user.getDcrLogin())).thenReturn(true);

        LoginAlreadyExistsException exception = assertThrows(LoginAlreadyExistsException.class, () -> service.saveUser(user));

        Assertions.assertEquals("Login já utilizado, tente outro!", exception.getMessage());

    }

    @Test
    public void shouldExeceptionPasswordCaracters() {
        User user = UserDTOGenerator.buildIncompletePasswordCaracter();

        PasswordVerifyCaractersException exception = assertThrows(PasswordVerifyCaractersException.class, () -> service.validationPassword(user));

        Assertions.assertEquals("A senha deve conter no mínimo 8 caracteres", exception.getMessage());

    }

    @Test
    public void shouldExeceptionPasswordCaracterSpecial() {
        User user = UserDTOGenerator.buildIncompletePasswordCaracterSpecial();

        PasswordVerifyCaracterSpecialException exception = assertThrows(PasswordVerifyCaracterSpecialException.class, () -> service.validationPassword(user));

        Assertions.assertEquals("A senha deve conter pelo menos um caracter especial", exception.getMessage());

    }

    @Test
    public void shouldExeceptionPasswordCNumber() {
        User user = UserDTOGenerator.buildIncompletePasswordNumber();

        PasswordVerifyNumberException exception = assertThrows(PasswordVerifyNumberException.class, () -> service.validationPassword(user));

        Assertions.assertEquals("A senha deve conter pelo menos um número", exception.getMessage());

    }


}
