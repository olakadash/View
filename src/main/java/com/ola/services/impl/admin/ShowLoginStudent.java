package com.ola.services.impl.admin;

import com.ola.controller.LoginController;
import com.ola.registration.model.entity.Login;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowLoginStudent implements Service {
    public String serve(Map<String, String> params) {

        LoginController loginController=new LoginController
                ("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

        List<Login> listLogin=loginController.showLoginStudent(params.get(Constants.USER_ID.getValue()));

        for (Login login: listLogin){
            System.out.println(login.toString());
        }

        return "Logged Users ";
    }

    public Map<String, String> parse(String command) {

        String adminId=command.split(" ")[1];
        String token=command.split(" ")[2];

        Map<String,String> params=new HashMap<String, String>();

        params.put(Constants.USER_ID.getValue(),adminId);
        params.put(Constants.TOKEN.getValue(),token);

        return params;

    }

    public boolean requiredAuthentication() {
        return true;
    }
}
