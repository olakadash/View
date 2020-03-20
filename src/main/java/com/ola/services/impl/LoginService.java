package com.ola.services.impl;

import com.ola.controller.LoginController;
import com.ola.services.Service;
import com.ola.utils.Constants;

import java.util.HashMap;
import java.util.Map;

public class LoginService implements Service {

    public String serve(Map<String, String> params) {

        LoginController loginController=new LoginController
                ("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

        String tokenAndUserType =loginController.isSignUp(params.get(Constants.STUDENT_ID.getValue()),params.get(Constants.PASSWORD.getValue()));

        if ("student".equals(tokenAndUserType.split("\t")[1])) {

            return String.format("you are logged in with : %s , %s", params.get(Constants.STUDENT_ID.getValue()),
                    params.get(Constants.PASSWORD.getValue()) + "  your key is " + tokenAndUserType.split("\t")[0] + "\n" +
                            "enter\n" +
                            "showCourses        to show all courses or showCourses with specificCourse name\n" +
                            "myScheduleCourses  with your id and key\n" +
                            "registerCourses    with your id ,courseId and key\n" +
                            "deleteMyCourse     with id ,courseId,key\n" +
                            "logout             with your id\nexit");

        }

         if ("admin".equals(tokenAndUserType.split("\t")[1])) {

            return String.format("you are logged in with : %s , %s", params.get(Constants.STUDENT_ID.getValue()),
                    params.get(Constants.PASSWORD.getValue()) + "  your key is " + tokenAndUserType.split("\t")[0] + "\n" +
                            "enter\n" +
                            "showLoginStudent     with your id,key\n" +
                            "saveNewCourse        with your id,key,courseId,courseName,instructor,courseCode,capacity,startingDate,duration,hours\n" +
                            "deleteStudent        with your id,key,studentId\n" +
                            "deleteSchedule       with your id,key,studentId,courseId\n" +
                            "deleteCourse         with your id,key,courseId\n" +
                            "deleteLoginStudent   with your id,key,studentId");

        }
        return " ";
    }


    public Map<String, String> parse(String command) {

      Map<String,String> serviceParam=new HashMap<String, String>();

      String [] param=command.split(" ");

      String studentId=param[1];
      String password= param[2];

      serviceParam.put(Constants.STUDENT_ID.getValue(),studentId);
      serviceParam.put(Constants.PASSWORD.getValue(),password);

      return serviceParam;
    }

    public boolean requiredAuthentication() {
        return false;
    }
}
