package com.dancehub.backend.controller;

import com.dancehub.backend.model.DanceClass;
import com.dancehub.backend.repository.DanceClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController     // Will handle incoming HTTP requests
public class DanceClassController {
    private final DanceClassRepository danceClassRepository;
    @Autowired
    public DanceClassController(DanceClassRepository danceClassRepository) {
        this.danceClassRepository = danceClassRepository;
    }

    @GetMapping("/hello")   // Will handle GET requests to /hello
    public String hello() {
        return "Hello World!";
    }

    // endpoint for getting all courses
    @GetMapping("/course/all")
    public ResponseEntity<List<DanceClass>> getCourses() {
        return ResponseEntity.ok().body(danceClassRepository.findAll());
    }

    // get course by class_weekday
    @GetMapping("/course")
    public ResponseEntity<List<DanceClass>> getCoursesByWeekday(@RequestParam("weekday") String weekday) {
        return ResponseEntity.ok().body(danceClassRepository.findByWeekday(weekday));
    }
}
