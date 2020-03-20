package com.ola.services.impl.admin;

import com.ola.controller.ScheduleController;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class DeleteSchedule implements Service {
    public String serve(Map<String, String> params) {

        ScheduleController scheduleController=new ScheduleController
                ("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

        return scheduleController.deleteScheduleByAdmin(params.get(Constants.USER_ID.getValue())
                ,params.get(Constants.STUDENT_ID.getValue()),params.get(Constants.COURSE_ID.getValue()));
    }

    public Map<String, String> parse(String command) {

        String [] params=command.split(" ");
        String adminId=params[1];
        String token=params[2];
        String studentId=params[3];
        String courseId=params[4];

        Map<String,String> serviceParams=new HashMap<String, String>();

        serviceParams.put(Constants.USER_ID.getValue(),adminId);
        serviceParams.put(Constants.TOKEN.getValue(),token);
        serviceParams.put(Constants.STUDENT_ID.getValue(),studentId);
        serviceParams.put(Constants.COURSE_ID.getValue(),courseId);

        return serviceParams;
    }

    public boolean requiredAuthentication() {
        return true;
    }
}
