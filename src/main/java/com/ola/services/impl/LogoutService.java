package com.ola.services.impl;

import com.ola.controller.LogoutController;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class LogoutService implements Service {


    public String serve(Map<String, String> params) {

        LogoutController logoutController=new LogoutController("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

        return logoutController.logoutUser(params.get(Constants.STUDENT_ID.getValue()));

    }

    public Map<String, String> parse(String command) {

        String userId=command.split(" ")[1];

        Map<String,String> params=new HashMap<String, String>();

        params.put(Constants.STUDENT_ID.getValue(),userId);


        return params;
    }

    public boolean requiredAuthentication() {
        return false;
    }
}
