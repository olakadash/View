package com.ola.services;


import java.util.Map;

public interface Service {

    String serve(Map<String,String> params);

    Map<String,String> parse(String command);

    boolean requiredAuthentication();
}
