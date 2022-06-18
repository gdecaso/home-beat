package ar.curiosidadesespaciales.homebeat.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BeatPageLinksDto {
    private final LinkDto prev;
    private final LinkDto next;

    public BeatPageLinksDto(LinkDto prev, LinkDto next) {
        this.prev = prev;
        this.next = next;
    }

    @JsonProperty
    public LinkDto getPrev() {
        return prev;
    }

    @JsonProperty
    public LinkDto getNext() {
        return next;
    }
}
