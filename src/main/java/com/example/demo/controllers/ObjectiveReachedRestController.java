package com.example.demo.controllers;

import com.example.demo.events.ObjectiveReached;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("/objective")
public class ObjectiveReachedRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectiveReachedRestController.class);

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public ObjectiveReachedRestController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @GetMapping("/exam")
    public String passExam(){
        LOGGER.info("Objective reached - REST CONTROLLER");
        /*
            Here, we create an event and publish it
            anyone listening to 'ObjectiveReached' event can hear it
         */
        var obr = new ObjectiveReached(this);
        applicationEventPublisher.publishEvent(obr);

        return "Exam passed: Successfully at "+ LocalDateTime.now();
    }

}
