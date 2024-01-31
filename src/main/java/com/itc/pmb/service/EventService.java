package com.vialfinaz.sisteminforklinik.service;

import com.vialfinaz.sisteminforklinik.Enumeration.EventType;
import com.vialfinaz.sisteminforklinik.domain.UserEvent;

import java.util.Collection;

public interface EventService {
    Collection<UserEvent> getEventsByUserId(Long userId);
    void addUserEvent(String email, EventType eventType, String device, String ipAddress);
    void addUserEvent(Long userId, EventType eventType, String device, String ipAddress);

}
