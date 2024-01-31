package com.itc.pmb.service;

import com.itc.pmb.enumeration.EventType;
import com.itc.pmb.domain.UserEvent;

import java.util.Collection;

public interface EventService {
    Collection<UserEvent> getEventsByUserId(Long userId);
    void addUserEvent(String email, EventType eventType, String device, String ipAddress);
    void addUserEvent(Long userId, EventType eventType, String device, String ipAddress);

}
