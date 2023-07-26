package my.sky.pro.homework2_7.service;

import my.sky.pro.homework2_7.exception.EmployeeAlreadyAddedException;
import my.sky.pro.homework2_7.exception.EmployeeNotFoundException;
import my.sky.pro.homework2_7.exception.EmployeeStorageIsFullException;
import my.sky.pro.homework2_7.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    // в комментариях методы сделаны для массива
//    private final Employee[] employees;
    private final List<Employee> employees;

    //    public EmployeeService() {
//        this.employees = new  Employee[LIMIT];
//    }
    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    //    public Employee addEmployee (String firstName, String lastName){
//        Employee employee = new Employee(firstName,lastName);
//        int indexForAdd = -1;
//        for (int i = 0; i < employees.length; i++) {
//            if(employees[i] == null){
//                indexForAdd = i;
//                break;
//            }
//            if (employees[i].equals(employee)){
//                throw new EmployeeAlreadyAddedException();
//            }
//        }
//        if (indexForAdd != -1){
//            return employees[indexForAdd] = employee;
//        } else {
//            throw new EmployeeStorageIsFullException();
//        }
//    }
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
//    public Employee findEmployee (String firstName, String lastName){
//        Employee employee = new Employee(firstName,lastName);
//        for (Employee value :employees) {
//            if (value.equals(employee)){
//                return employee;
//            }
//        }
//        throw new EmployeeNotFoundException();
//    }
//
//   public Employee removeEmployee  (String firstName, String lastName) {
//    Employee employee = new Employee(firstName, lastName);
//    if (!employees.contains(employee)) {
//        throw new EmployeeNotFoundException();
//    }
//    employees.remove(employee);
//    return employee;
//}
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

//    public Employee removeEmployee (String firstName, String lastName){
//        Employee employee = new Employee(firstName,lastName);
//        for (int i = 0; i < employees.length; i++) {
//            if (employees[i].equals(employee)){
//                employees[i] = null;
//                return employee;
//            }
//        }
//        throw new EmployeeNotFoundException();
//    }
    public List<Employee> getAll() {
//        return Collections.unmodifiableList(employees) // делает list не модифицируемым
        return new ArrayList<>(employees);
    }
}
