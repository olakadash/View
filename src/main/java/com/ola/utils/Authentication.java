package com.ola.utils;

import com.ola.controller.AuthenticationController;


public class Authentication {


    public static boolean isAuthentication(String token,String studentId){

        AuthenticationController authenticate = new AuthenticationController
                ("jdbc:mysql://localhost:3306/student1?useSSL=false","root", "root@JEA");

       return authenticate.isAuthenticate(token,studentId);

    }
}
