package com.ola.services.impl.user;

import com.ola.controller.ScheduleController;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class DeleteMyScheduleCourse implements Service {
    public String serve(Map<String, String> params) {


        ScheduleController scheduleController=new ScheduleController
                ("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

     return    scheduleController.deleteScheduleByUser(params.get(Constants.STUDENT_ID.getValue()),
                params.get(Constants.COURSE_ID.getValue()));
    }

    public Map<String, String> parse(String command) {


        String studentId=command.split(" ")[1];
        String courseId=command.split(" ")[2];
        String token=command.split(" ")[3];

        Map<String , String> serviceParams=new HashMap<String, String>();

        serviceParams.put(Constants.STUDENT_ID.getValue(),studentId);
        serviceParams.put(Constants.COURSE_ID.getValue(),courseId);
        serviceParams.put(Constants.TOKEN.getValue(),token);

        return serviceParams;

    }

    public boolean requiredAuthentication() {
        return true;
    }
}
