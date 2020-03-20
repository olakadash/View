package com.ola.dispatcher;

import com.ola.services.Service;
import com.ola.services.impl.*;
import com.ola.services.impl.admin.*;
import com.ola.services.impl.user.DeleteMyScheduleCourse;
import com.ola.services.impl.user.RegistrationCourseService;
import com.ola.services.impl.user.ShowMyScheduleCourse;

import java.util.HashMap;
import java.util.Map;


public class ServiceLocator {

      private static final Map<String, Service> services;

     static {

            services= new HashMap<String, Service>();

                  services.put(  "signUp"               ,new SignUpService()              );
                  services.put(  "login"                ,new LoginService()               );
                  services.put(  "registerCourse"       ,new RegistrationCourseService()  );
                  services.put(  "showCourses"          ,new ShowCourseService()          );
                  services.put(  "logout"               ,new LogoutService()              );
                  services.put(  "myScheduleCourse"     ,new ShowMyScheduleCourse()       );
                  services.put(  "deleteMyCourse"       ,new DeleteMyScheduleCourse()     );
                  services.put(  "deleteSchedule"       ,new DeleteSchedule()             );
                  services.put(  "deleteCourse"         ,new DeleteCourse()               );
                  services.put(  "deleteLoginStudent"   ,new DeleteLoginStudent()         );
                  services.put(  "deleteStudent"        ,new DeleteStudent()              );
                  services.put(  "showLoginStudent"     ,new ShowLoginStudent()           );
                  services.put(  "saveNewCourse"        ,new SaveNewCourse()              );

     }

     public static Service getService(String serviceName){

             return services.get(serviceName);
         }

  }
