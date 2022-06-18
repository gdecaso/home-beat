package ar.curiosidadesespaciales.homebeat.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BeatPageDto {
    private final List<BeatEntryDto> entries;
    private final BeatPageLinksDto links;

    public BeatPageDto(List<BeatEntryDto> entries, BeatPageLinksDto links) {
        this.entries = entries;
        this.links = links;
    }

    @JsonProperty
    public List<BeatEntryDto> getEntries() {
        return entries;
    }

    @JsonProperty("_links")
    public BeatPageLinksDto getLinks() {
        return links;
    }
}
