package com.itc.pmb.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import static com.twilio.rest.api.v2010.account.Message.creator;


public class SmsUtils {
    public static final String FROM_NUMBER = "+683842031984";
    public static final String SID_KEY = "ACcf0756227139ec01a78d94d48ad5fe32";
    public static final String TOKEN_KEY = "fda189bc31d55fd78ba764499ee6be44";

    public static void sendSMS(String to, String messageBody) {
        Twilio.init(SID_KEY, TOKEN_KEY);
        Message message = creator(new PhoneNumber("+" + to), new PhoneNumber(FROM_NUMBER), messageBody).create();
        System.out.println(message);
    }
}
