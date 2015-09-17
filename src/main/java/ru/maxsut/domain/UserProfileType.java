package ru.maxsut.domain;

/**
 * Created by Максим on 10.08.2015.
 */
public enum UserProfileType {

    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    String userProfileType;

    UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return userProfileType;
    }
}
