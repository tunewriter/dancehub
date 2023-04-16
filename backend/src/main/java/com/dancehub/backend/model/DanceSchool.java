package com.dancehub.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "dance_school")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DanceSchool {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "main_location_id", referencedColumnName = "location_id", insertable = false, updatable = false)
    @JsonProperty("location")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Location location;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dance_school_id")
    private Long id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "dance_school_name")
    @JsonProperty("dance_school_name")
    private String name;

    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name = "website")
    @JsonProperty("website")
    private String website;

    @Column(name = "main_location_id")
    private Long mainLocationId;
}
