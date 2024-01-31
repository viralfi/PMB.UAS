package com.vialfinaz.sisteminforklinik.Repository;

import com.vialfinaz.sisteminforklinik.Enumeration.EventType;
import com.vialfinaz.sisteminforklinik.domain.UserEvent;

import java.util.Collection;

public interface EventRepository {
    Collection<UserEvent> getEventsByUserId(Long userId);
    void addUserEvent(String email, EventType eventType, String device, String ipAddress);
    void addUserEvent(Long userId, EventType eventType, String device, String ipAddress);
}
