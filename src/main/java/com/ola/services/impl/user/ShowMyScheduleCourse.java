package com.ola.services.impl.user;

import com.ola.controller.ScheduleController;
import com.ola.registration.model.entity.Course;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowMyScheduleCourse implements Service {

    public String serve(Map<String, String> params) {

        ScheduleController scheduleController=new ScheduleController("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");
        List<Course> listCourses=scheduleController.showMyCourse(params.get(Constants.STUDENT_ID.getValue()));

        for(Course course:listCourses){

            System.out.println(course.toString());
        }

        return " These are your available courses  ";

    }

    public Map<String, String> parse(String command) {

        String studentId=command.split(" ")[1];
        String token=command.split(" ")[2];
        Map<String,String> params=new HashMap<String, String>();

        params.put(Constants.STUDENT_ID.getValue(),studentId);
        params.put(Constants.TOKEN.getValue(),token);

        return params;
    }

    public boolean requiredAuthentication() {
        return true;
    }
}
