package com.ola.services.impl;

import com.ola.controller.SignUpController;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class SignUpService implements Service {


    public String serve(Map<String, String> params) {

        SignUpController signUpController=new SignUpController("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

        return signUpController.signUpClient(params)+"\n please login know";


    }


    public Map<String, String> parse(String command) {

        String []param=command.split(" ");

        String id=param[1];
        String firstName=param[2];
        String lastName=param[3];
        String email=param[4];
        String password=param[5];

        Map<String,String> serviceParam=new HashMap<String, String>();

        serviceParam.put(Constants.STUDENT_ID.getValue(),id);
        serviceParam.put(Constants.FIRST_NAME.getValue(),firstName);
        serviceParam.put(Constants.LAST_NAME.getValue(),lastName);
        serviceParam.put(Constants.EMAIL.getValue(),email);
        serviceParam.put(Constants.PASSWORD.getValue(),password);

        return serviceParam;
    }


    public boolean requiredAuthentication() {
        return false;
    }
}
