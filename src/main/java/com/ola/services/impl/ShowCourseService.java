package com.ola.services.impl;

import com.ola.controller.CoursesController;
import com.ola.registration.model.entity.Course;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowCourseService implements Service {

    public String serve(Map<String, String> params) {

        CoursesController coursesController=new CoursesController
                ("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

        if (params.get(Constants.COURSE_Name.getValue())!=null){

           Course courseByName= coursesController.showCourseByName(params.get(Constants.COURSE_Name.getValue()));

            System.out.println(courseByName.toString());

            return "course know available ";
        }

         List<Course>listCourse=coursesController.showCourse();

        for(Course course:listCourse){

            System.out.println(course.toString());
        }
        return " These are all available courses  ";
    }


    public Map<String, String> parse(String command) {
        Map<String, String> serviceParam = new HashMap<String, String>();;

        if (command.length()!= 11) {

            String param = command.split(" ")[1];

            serviceParam.put(Constants.COURSE_Name.getValue(), param);
        }

        return serviceParam;

    }

    public boolean requiredAuthentication() {
        return false;
    }
}
