package ar.curiosidadesespaciales.homebeat.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class BeatEntryDto {
    @JsonProperty("dateTime")
    private final ZonedDateTime dateTime;

    public BeatEntryDto(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
