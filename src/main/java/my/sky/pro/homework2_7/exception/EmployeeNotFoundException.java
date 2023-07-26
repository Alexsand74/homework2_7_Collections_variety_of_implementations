package my.sky.pro.homework2_7.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND) // не найден запрашиваемый объект - ошибка номер 404
public class EmployeeNotFoundException extends RuntimeException {//наследуемся от непроверяемого исключения
}
