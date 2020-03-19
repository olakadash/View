package com.ola.utils;

public enum  Constants {

    STUDENT_ID("studentId"),PASSWORD("password"),TOKEN("token"),COURSE_ID("courseId"),
    COURSE_Name("courseName"),FIRST_NAME("firstName"),LAST_NAME("lastName"),
    EMAIL("email");

    private String value;

    Constants(String value) {

        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
