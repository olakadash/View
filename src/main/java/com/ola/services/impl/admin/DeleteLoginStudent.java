package com.ola.services.impl.admin;

import com.ola.controller.LoginController;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class DeleteLoginStudent implements Service {
    public String serve(Map<String, String> params) {

        LoginController loginController=new LoginController
                ("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

    return loginController.deleteLoginStudent(params.get(Constants.USER_ID.getValue()),
            params.get(Constants.STUDENT_ID.getValue()));

    }

    public Map<String, String> parse(String command) {

        String[]params=command.split(" ");
        String adminId=params[1];
        String token=params[2];
        String studentId=params[3];

        Map<String,String> serviceParams=new HashMap<String, String>();

        serviceParams.put(Constants.USER_ID.getValue(),adminId);
        serviceParams.put(Constants.TOKEN.getValue(),token);
        serviceParams.put(Constants.STUDENT_ID.getValue(),studentId);

        return serviceParams;
    }

    public boolean requiredAuthentication() {
        return true;
    }
}
