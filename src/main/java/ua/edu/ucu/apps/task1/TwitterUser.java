package ua.edu.ucu.apps.task1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class TwitterUser {
    
    private String userMail;
    private String country;
    private String lastActiveTime;

    public String getUserMail() {
        return userMail;
    }
    public String getCountry() {
        return country;
    }
    public String getLastActiveTime() {
        return lastActiveTime;
    }
    
}
