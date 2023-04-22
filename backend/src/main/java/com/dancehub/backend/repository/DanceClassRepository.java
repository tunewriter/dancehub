package com.dancehub.backend.repository;

import com.dancehub.backend.model.DanceClass;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DanceClassRepository extends JpaRepository<DanceClass, Integer> {

    List<DanceClass> findByWeekday(String weekday);

    @Cacheable("danceClasses")
    @Query("SELECT DISTINCT d FROM DanceClass d JOIN FETCH d.instructor i JOIN FETCH d.location l JOIN FETCH d.danceSchool ds")
    List<DanceClass> findAllWithInstructorLocationAndDanceSchool();
}
