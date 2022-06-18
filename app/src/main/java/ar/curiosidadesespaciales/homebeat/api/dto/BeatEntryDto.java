package ar.curiosidadesespaciales.homebeat.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

public class BeatEntryDto {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss Z")
    private final ZonedDateTime dateTime;

    public BeatEntryDto(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
