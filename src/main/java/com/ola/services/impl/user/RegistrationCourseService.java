package com.ola.services.impl.user;

import com.ola.controller.RegistrationCourseController;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class RegistrationCourseService implements Service {


    public String serve(Map<String, String> params) {

        RegistrationCourseController registerController=new
                RegistrationCourseController("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

        registerController.register(params.get(Constants.STUDENT_ID.getValue()),params.get(Constants.COURSE_ID.getValue()));

        return String.format("your registered in : %s,%s ",params.get(Constants.STUDENT_ID.getValue())
                ,params.get(Constants.COURSE_ID.getValue())+" Successfully");
    }


    public Map<String, String> parse(String command) {

        String []param =command.split(" ");
        String studentId=param[1];
        String courseId=param[2];
        String  token=param[3];

        Map<String,String> serviceParam=new HashMap<String, String>();

        serviceParam.put(Constants.STUDENT_ID.getValue(),studentId);
        serviceParam.put(Constants.COURSE_ID.getValue(),courseId);
        serviceParam.put(Constants.TOKEN.getValue(),token);

        return serviceParam;
    }

    public boolean requiredAuthentication() {
        return true;
    }
}
