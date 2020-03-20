package com.ola.services.impl.admin;

import com.ola.controller.CoursesController;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class SaveNewCourse implements Service {
    public String serve(Map<String, String> params) {

        CoursesController coursesController=new CoursesController
                ("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

        return coursesController.saveNewCourse(params);
    }

    public Map<String, String> parse(String command) {

        String [] params=command.split(" ");

        String adminId=params[1];
        String token=params[2];
        String courseId=params[3];
        String courseName=params[4];
        String instructor=params[5];
        String courseCode=params[6];
        String capacity=params[7];
        String startingDate=params[8];
        String duration=params[9];
        String hours=params[10];

        Map<String ,String> serviceParams=new HashMap<String, String>();

        serviceParams.put(Constants.USER_ID.getValue(),adminId);
        serviceParams.put(Constants.TOKEN.getValue(),token);
        serviceParams.put(Constants.COURSE_ID.getValue(),courseId);
        serviceParams.put(Constants.COURSE_Name.getValue(),courseName);
        serviceParams.put(Constants.INSTRUCTOR.getValue(),instructor);
        serviceParams.put(Constants.COURSE_CODE.getValue(),courseCode);
        serviceParams.put(Constants.CAPACITY.getValue(),capacity);
        serviceParams.put(Constants.STARTING_DATE.getValue(),startingDate);
        serviceParams.put(Constants.DURATION.getValue(),duration);
        serviceParams.put(Constants.HOURS.getValue(),hours);

        return serviceParams;


    }

    public boolean requiredAuthentication() {
        return true;
    }
}
