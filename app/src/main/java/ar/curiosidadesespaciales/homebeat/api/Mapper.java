package ar.curiosidadesespaciales.homebeat.api;

import ar.curiosidadesespaciales.homebeat.api.dto.BeatEntryDto;
import ar.curiosidadesespaciales.homebeat.api.dto.BeatPageDto;
import ar.curiosidadesespaciales.homebeat.api.dto.BeatPageLinksDto;
import ar.curiosidadesespaciales.homebeat.api.dto.LinkDto;
import ar.curiosidadesespaciales.homebeat.data.BeatEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    private final UriHelper uriHelper;

    @Autowired
    public Mapper(UriHelper uriHelper) {
        this.uriHelper = uriHelper;
    }

    public BeatPageDto modelToApis(List<BeatEntry> beatEntries, int page, int size) {
        return new BeatPageDto(
                modelToApis(beatEntries),
                new BeatPageLinksDto(
                        page > 0 ? new LinkDto(uriHelper.withPageSize(page - 1, size)) : null,
                        new LinkDto(uriHelper.withPageSize(page + 1, size))));
    }

    private List<BeatEntryDto> modelToApis(List<BeatEntry> beatEntries) {
        return beatEntries.stream()
                .map(this::modelToApi)
                .collect(Collectors.toList());
    }

    private BeatEntryDto modelToApi(BeatEntry beatEntry) {
        return new BeatEntryDto(beatEntry.getDateTime());
    }
}
