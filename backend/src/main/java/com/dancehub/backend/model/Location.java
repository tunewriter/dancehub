package com.dancehub.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "location")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "dance_school_id")
    private Long danceSchoolId;

    @Column(name = "canton")
    @JsonProperty("canton")
    private String canton;

    @Column(name = "zip_code")
    @JsonProperty("zip_code")
    private String zipCode;

    @Column(name = "city")
    @JsonProperty("city")
    private String city;

    @Column(name = "street")
    @JsonProperty("street")
    private String street;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "note")
    @JsonProperty("note")
    private String note;
}
