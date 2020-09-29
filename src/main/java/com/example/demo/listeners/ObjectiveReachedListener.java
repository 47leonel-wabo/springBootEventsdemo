package com.example.demo.listeners;

import com.example.demo.controllers.ObjectiveReachedRestController;
import com.example.demo.events.ObjectiveReached;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class ObjectiveReachedListener implements ApplicationListener<ObjectiveReached> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectiveReachedRestController.class);

    @Override
    public void onApplicationEvent(ObjectiveReached event) {
        LOGGER.info("*** Objective reached successfully "+ event.getClass().getTypeName() +" **");
    }

}
