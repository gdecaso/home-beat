package ar.curiosidadesespaciales.homebeat.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class BeatEntryDto {
    @JsonProperty
    private final ZonedDateTime dateTime;

    public BeatEntryDto(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
