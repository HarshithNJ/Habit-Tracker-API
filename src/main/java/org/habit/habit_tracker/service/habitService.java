package org.habit.habit_tracker.service;

import java.util.HashMap;
import java.util.Map;

import org.habit.habit_tracker.dto.habit;
import org.habit.habit_tracker.repository.habitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class habitService {

    @Autowired
    habitRepository repository;

    public ResponseEntity<Object> saveHabit(habit habit) {
        if(repository.findByName(habit.getName()) != null){
            repository.save(habit);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Record successfully saved");
            map.put("Data", habit);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Enter the name of the habit");

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
        }
    }
    
}
