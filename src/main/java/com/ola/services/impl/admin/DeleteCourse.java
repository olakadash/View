package com.ola.services.impl.admin;

import com.ola.controller.CoursesController;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class DeleteCourse implements Service {
    public String serve(Map<String, String> params) {

        CoursesController coursesController=new CoursesController
                ("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

        return coursesController.deleteCourseByAdmin(params.get(Constants.USER_ID.getValue()),
                params.get(Constants.COURSE_ID.getValue()));
    }

    public Map<String, String> parse(String command) {

        String[] params=command.split(" ");
        String adminId=params[1];
        String token=params[2];
        String courseId=params[3];

        Map<String,String> serviceParams=new HashMap<String, String>();

        serviceParams.put(Constants.USER_ID.getValue(),adminId);
        serviceParams.put(Constants.TOKEN.getValue(),token);
        serviceParams.put(Constants.COURSE_ID.getValue(),courseId);

        return serviceParams;

    }

    public boolean requiredAuthentication() {
        return true;
    }
}
