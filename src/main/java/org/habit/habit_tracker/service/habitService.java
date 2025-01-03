package org.habit.habit_tracker.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
            repository.save(habit);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Record successfully saved");
            map.put("Data", habit);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getHabits() {
        List<habit> habits = repository.findAll();
        
        if(habits.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Habits Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Habits Found");
            map.put("Data", habits);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> deleteHabits(int id) {
        Optional<habit> habit = repository.findById(id);

        if(habit.isPresent()){
            repository.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Record deleted successfully");
            map.put("Data", habit);

            return new ResponseEntity<Object>(map, HttpStatus.ACCEPTED);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Record not found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public ResponseEntity<Object> putMethodName(String id, habit habit) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putMethodName'");
    }

    
}
