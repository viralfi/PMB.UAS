package com.itc.pmb.event;

import com.itc.pmb.enumeration.EventType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class NewUserEvent extends ApplicationEvent {
    private EventType type;
    private String email;
    private String name;
    public NewUserEvent(String email, EventType type) {
        super(email);
        this.type = type;
        this.email = email;
    }
//    public NewProductEvent(String name, EventType type) {
//        super(name);
//        this.type = type;
//        this.name = name;
//    }
}
