package org.habit.habit_tracker.controller;

import org.habit.habit_tracker.dto.habit;
import org.habit.habit_tracker.service.habitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public  class habitController{

    @Autowired
    habitService service;

    @PostMapping("/habits")
    public ResponseEntity<Object> saveHabit(@RequestBody habit habit){
        return service.saveHabit(habit);
    }
    
}
