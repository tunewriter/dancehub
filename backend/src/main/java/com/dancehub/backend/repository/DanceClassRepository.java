package com.dancehub.backend.repository;

import com.dancehub.backend.model.DanceClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DanceClassRepository extends JpaRepository<DanceClass, Integer> {

    List<DanceClass> findByWeekday(String weekday);
}
