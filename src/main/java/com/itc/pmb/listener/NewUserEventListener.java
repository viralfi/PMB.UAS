package com.itc.pmb.listener;

import com.itc.pmb.event.NewUserEvent;
import com.itc.pmb.service.EventService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.itc.pmb.utils.RequestUtils.getDevice;
import static com.itc.pmb.utils.RequestUtils.getIpAddress;

@Component
@RequiredArgsConstructor
public class NewUserEventListener {
    private final EventService eventService;
    private final HttpServletRequest request;
    @EventListener
    public void onNewUserEvent(NewUserEvent event) {
        eventService.addUserEvent(event.getEmail(), event.getType(),
                getDevice(request), getIpAddress(request));
    }
}
