package com.vialfinaz.sisteminforklinik.Enumeration;

public enum EventType {
    LOGIN_ATTEMPT("You tried to log in"),
    LOGIN_ATTEMPT_FAILURE("You tried to log in and you failed"),
    LOGIN_ATTEMPT_SUCCESS("You tried to log in and you succeeded"),
    PROFILE_UPDATE("You update your profile information"),
    PROFILE_PICTURE_UPDATE("You update your profile picture"),
    ROLE_UPDATE("You update your role and permissions"),
    ACCOUNT_SETTINGS_UPDATE("You update your account settings"),
    MFA_UPDATE("You update your MFA settings"),
    PASSWORD_UPDATE("You update your password");

    private final String description;
    EventType(String description) {
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
}
