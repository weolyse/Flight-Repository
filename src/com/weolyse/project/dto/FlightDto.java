package com.weolyse.project.dto;

import java.time.LocalDateTime;

public class FlightDto {

    private Long id;
    private String description;

    public FlightDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
