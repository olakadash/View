package com.ola.dispatcher;

import com.ola.services.Service;
import com.ola.utils.Authentication;
import com.ola.utils.Constants;

import java.util.Map;

public class Controller {

    public  void dispatch(String line){

        String serviceName=line.split(" ")[0];

        Service service=ServiceLocator.getService(serviceName);

        if(service==null){

            throw new UnsupportedOperationException(serviceName+" this Service Not Supported");

        }

        Map<String,String> params= service.parse(line);

        if (service.requiredAuthentication()){

           boolean authentication
                   =Authentication.isAuthentication(params.get(Constants.TOKEN.getValue()),
                                      params.get(Constants.STUDENT_ID.getValue()));

           if(!authentication){

               throw new RuntimeException ("Login Required ");

           }
        }

        System.out.println(service.serve(params));
    }

  }
