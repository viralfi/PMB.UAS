package com.itc.pmb.query;

public class UserQuery {
    public static final String COUNT_USER_EMAIL_QUERY =
            "SELECT COUNT(*) " +
                    "FROM Users " +
                    "WHERE email = :email";
    public static final String INSERT_USER_QUERY =
            "INSERT INTO Users " +
                    "(full_name, phone, email, password)" +
                    " VALUES " +
                    "(:fullName, :phone, :email, :password)";
    public static final String INSERT_ACCOUNT_VERIFICATION_URL_QUERY =
            "INSERT INTO AccountVerifications " +
                    "(user_id, url, date) " +
                    "VALUES " +
                    "(:userId, :url, :date)";

    public static final String SELECT_USER_BY_EMAIL_QUERY =
            "SELECT * FROM Users " +
                    "WHERE " +
                    "email = :email";
    public static final String DELETE_VERIFICATION_CODE_BY_USER_ID =
            "DELETE FROM TwoFactorVerifications WHERE user_id = :id";
    public static final String INSERT_VERIFICATION_CODE_QUERY =
            "INSERT INTO twoFactorVerifications " +
                    "(user_id, code, expiration_date) " +
                    "VALUES " +
                    "(:userId, :code, :expirationDate)";
    public static final String SELECT_USER_BY_USER_CODE_QUERY =
            "SELECT * FROM Users " +
                    "WHERE " +
                    "id = (SELECT user_id " +
                    "FROM TwoFactorVerifications WHERE code = :code)";
    public static final String DELETE_CODE = "DELETE FROM TwoFactorVerifications WHERE code = :code";
    public static final String SELECT_CODE_EXPIRATION_QUERY = "SELECT expiration_date < NOW() AS is_expired FROM TwoFactorVerifications WHERE code = :code";
    public static final String DELETE_PASSWORD_VERIFICATION_BY_USER_ID_QUERY =
            "DELETE FROM ResetPasswordVerifications " +
                    "WHERE " +
                    "user_id = :userId";
    public static final String INSERT_PASSWORD_VERIFICATION_QUERY =
            "INSERT INTO ResetPasswordVerifications " +
                    "(user_id, url, expiration_date) " +
                    "VALUES " +
                    "(:userId, :url, :expirationDate)";
    public static final String SELECT_EXPIRATION_BY_URL =
            "SELECT expiration_date < NOW() " +
                    "AS is_expired " +
                    "FROM ResetPasswordVerifications " +
                    "WHERE url = :url";
    public static final String SELECT_USER_BY_PASSWORD_URL_QUERY =
            "SELECT * FROM Users " +
                    "WHERE id = " +
                    "(SELECT user_id FROM ResetPasswordVerifications WHERE url = :url)";
    public static final String UPDATE_USER_PASSWORD_BY_URL_QUERY =
            "UPDATE Users SET password = :password " +
                    "WHERE id = (SELECT user_id FROM ResetPasswordVerifications WHERE url = :url)";
    public static final String DELETE_VERIFICATION_BY_URL_QUERY =
            "DELETE FROM ResetPasswordVerifications WHERE url = :url";
    public static final String SELECT_USER_BY_ACCOUNT_URL_QUERY =
            "SELECT * FROM Users " +
                    "WHERE " +
                    "id = (SELECT user_id FROM AccountVerifications WHERE url = :url)";

    public static final String UPDATE_USER_ENABLED_QUERY =
            "UPDATE Users " +
                    "SET " +
                    "enabled = :enabled WHERE id = :id";

    public static final String UPDATE_USER_DETAILS_QUERY =
            "UPDATE Users " +
                    "SET " +
                    "full_name = :fullName,  email = :email, " +
                    "phone = :phone, address = :address, title = :title, bio = :bio " +
                    "WHERE id = :id";
    public static final String SELECT_USER_BY_ID_QUERY =
            "SELECT * FROM Users " +
                    "WHERE id = :id";
    public static final String UPDATE_USER_PASSWORD_BY_ID_QUERY =
            "UPDATE Users " +
                    "SET password = :password " +
                    "WHERE id = :userId";
    public static final String UPDATE_USER_SETTINGS_QUERY =
            "UPDATE Users " +
                    "SET enabled = :enabled, non_locked = :notLocked " +
                    "WHERE id = :userId";
    public static final String TOGGLE_USER_MFA_QUERY =
            "UPDATE Users " +
                    "SET using_mfa = :isUsingMfa " +
                    "WHERE email = :email";
    public static final String UPDATE_USER_IMAGE_QUERY =
            "UPDATE Users " +
                    "SET image_url = :imageUrl " +
                    "WHERE id = :id";
    public static final String UPDATE_USER_PASSWORD_BY_USER_ID_QUERY =
            "UPDATE Users " +
                    "SET password = :password " +
                    "WHERE id = :id";
    public static final String COUNT_USER_PHONE_QUERY =
            "SELECT COUNT(*) FROM Users " +
                    "WHERE " +
                    "phone = :phone";
}
