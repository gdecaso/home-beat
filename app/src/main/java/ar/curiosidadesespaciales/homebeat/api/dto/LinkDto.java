package ar.curiosidadesespaciales.homebeat.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LinkDto {
    private final String href;

    public LinkDto(String href) {
        this.href = href;
    }

    @JsonProperty
    public String getHref() {
        return href;
    }
}
