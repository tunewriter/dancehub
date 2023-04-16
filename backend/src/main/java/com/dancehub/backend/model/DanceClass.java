package com.dancehub.backend.model;

import java.io.Serializable;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "dance_class")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DanceClass implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id", referencedColumnName = "instructor_id", insertable = false, updatable = false)
    @JsonProperty("instructor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Instructor instructor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", insertable = false, updatable = false)
    @JsonProperty("location")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Location location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dance_school_id", referencedColumnName = "dance_school_id", insertable = false, updatable = false)
    @JsonProperty("dance_school")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DanceSchool danceSchool;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dance_class_id")
    private Long danceClassId;

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "dance_class_name")
    @JsonProperty("dance_class_name")
    private String className;

    @Column(name = "class_weekday")
    @JsonProperty("weekday")
    private String weekday;

    @Column(name = "class_start_time")
    @JsonProperty("start_time")
    private LocalTime startTime;

    @Column(name = "class_end_time")
    @JsonProperty("end_time")
    private LocalTime endTime;

    @Column(name = "class_description", columnDefinition = "TEXT")
    @JsonProperty("description")
    private String description;

    @Column(name = "instructor_id")
    private Long instructorId;

    @Column(name = "dance_school_id")
    private Long danceSchoolId;

    @Column(name = "dance_genre")
    @JsonProperty("dance_style")
    private String danceGenre;

    @Column(name = "room_name")
    @JsonProperty("room_name")
    private String roomName;

    // Getters and Setters

}

