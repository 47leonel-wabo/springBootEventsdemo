package com.example.demo.listeners;

import com.example.demo.controllers.ObjectiveReachedRestController;
import com.example.demo.events.ObjectiveReached;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class AnotherListenerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectiveReachedRestController.class);

    @EventListener
    public void otherAchievement(ObjectiveReached event) {
        LOGGER.info("## Other Service receive the event from ##" + event.getSource().toString());
    }

    @EventListener(ApplicationEvent.class)
    public void springApplicationEvent(ApplicationEvent event) {
        LOGGER.info("°°°° Spring app event ##" + event.getClass().getName());
    }
}
