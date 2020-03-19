package com;

import com.ola.controller.LogoutController;
import com.ola.dispatcher.Controller;
import com.ola.services.impl.LogoutService;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        System.out.println("enter command \n" +
                "login             with your id and password\n"+
                "signUp            with your id,firstName,LastName,email andPassword\n"
                +"registerCourse    with your id,courseId and key\n"+
                "showCourses       to show all courses or showCourses with specificCourse name \n"+"exit\n");

        Scanner input=new Scanner(System.in);

        String line=input.nextLine();

        while (!"exit".equals(line)){

            Controller controller=new Controller();
            controller.dispatch(line);

            line=input.nextLine();
        }


        System.exit(0);

    }

    }



