package com.miroliubov.springbootsoapexample.service;

import com.miroliubov.spring_boot_soap_example.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService{

    private Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        User slava = new User();
        slava.setName("Slava");
        slava.setEmpId(123);
        slava.setSalary(10000);

        User kirill = new User();
        kirill.setName("Kirill");
        kirill.setEmpId(123);
        kirill.setSalary(11000);

        User anton = new User();
        anton.setName("Anton");
        anton.setEmpId(123);
        anton.setSalary(12000);

        users.put(slava.getName(), slava);
        users.put(kirill.getName(), kirill);
        users.put(anton.getName(), anton);
    }

    public User getUsers(String name) {
        return users.get(name);
    }

    public void createUser(User user) {
        users.put(user.getName(), user);
    }
}
