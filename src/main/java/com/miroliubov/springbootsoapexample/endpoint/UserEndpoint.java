package com.miroliubov.springbootsoapexample.endpoint;

import com.miroliubov.spring_boot_soap_example.CreateUserRequest;
import com.miroliubov.spring_boot_soap_example.CreateUserResponse;
import com.miroliubov.spring_boot_soap_example.GetUserRequest;
import com.miroliubov.spring_boot_soap_example.GetUserResponse;
import com.miroliubov.springbootsoapexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = "http://miroliubov.com/spring-boot-soap-example",
        localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }

    @PayloadRoot(namespace = "http://miroliubov.com/spring-boot-soap-example",
            localPart = "createUserRequest")
    @ResponsePayload
    public CreateUserResponse creeateUserRequest(@RequestPayload CreateUserRequest request) {
        CreateUserResponse response = new CreateUserResponse();
        userService.createUser(request.getUser());
        response.setUser(request.getUser());
        return response;
    }


}
