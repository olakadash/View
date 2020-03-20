package com.ola.utils;

public enum  Constants {

    STUDENT_ID("studentId"),PASSWORD("password"),TOKEN("token"),COURSE_ID("courseId"),
    COURSE_Name("courseName"),FIRST_NAME("firstName"),LAST_NAME("lastName"),
    EMAIL("email"),ADMIN_ID("adminId"),USER_ID("userId"),INSTRUCTOR("instructor"),
    COURSE_CODE("courseCode"),CAPACITY("capacity"),STARTING_DATE("startingDate")
    ,DURATION("duration"),HOURS("hours");

    private String value;

    Constants(String value) {

        this.value=value;
    }

    public String getValue() {
        return value;
    }
}
