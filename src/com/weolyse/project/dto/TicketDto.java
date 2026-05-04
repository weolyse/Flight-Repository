package com.weolyse.project.dto;

public class TicketDto {

    private Long id;
    private String seatNo;

    public TicketDto(Long id, String seatNo) {
        this.id = id;
        this.seatNo = seatNo;
    }

    public Long getId() {
        return id;
    }

    public String getSeatNo() {
        return seatNo;
    }
}
