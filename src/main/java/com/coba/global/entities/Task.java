package com.coba.global.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String date;
    @NotEmpty
    private String startTime;
    @NotEmpty
    private String stopTime;
    @NotEmpty
    private String description;
    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;

    public Task() {
    }

    public Task(@NotEmpty String date, @NotEmpty String startTime, @NotEmpty String stopTime, @NotEmpty String description) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
    }
}
