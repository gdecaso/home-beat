package ar.curiosidadesespaciales.homebeat.api;

import ar.curiosidadesespaciales.homebeat.data.BeatEntry;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BeatEntryMapper {

    public BeatEntryDto modelToApi(BeatEntry beatEntry) {
        return new BeatEntryDto(beatEntry.getDateTime());
    }

    public List<BeatEntryDto> modelToApis(List<BeatEntry> beatEntries) {
        return beatEntries.stream()
                .map(this::modelToApi)
                .collect(Collectors.toList());
    }
}
