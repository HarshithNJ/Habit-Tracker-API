package org.habit.habit_tracker.controller;

import org.habit.habit_tracker.dto.habit;
import org.habit.habit_tracker.service.habitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public  class habitController{

    @Autowired
    habitService service;

    @PostMapping("/habits")
    public ResponseEntity<Object> saveHabit(@RequestBody habit habit){
        return service.saveHabit(habit);
    }

    @GetMapping("/habits")
    public ResponseEntity<Object> getHabits(){
        return service.getHabits();
    }

    @DeleteMapping("/habits/{id}")
    public ResponseEntity<Object> deleteHabits(@PathVariable int id){
        return service.deleteHabits(id);
    }

    @PatchMapping("/habits/{id}")
    public ResponseEntity<Object> putMethodName(@PathVariable String id, @RequestBody habit habit) {
        return service.putMethodName(id, habit);
    }
    
}
