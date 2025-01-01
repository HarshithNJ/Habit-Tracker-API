package org.habit.habit_tracker.repository;

import org.habit.habit_tracker.dto.habit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface habitRepository extends JpaRepository<habit, Integer> {

    Object findByName(String name);

}
