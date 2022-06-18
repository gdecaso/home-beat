package ar.curiosidadesespaciales.homebeat.service;

import ar.curiosidadesespaciales.homebeat.data.BeatEntry;
import ar.curiosidadesespaciales.homebeat.data.BeatEntryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class HomeBeatService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Environment env;

    private final BeatEntryRepository beatEntryRepository;

    @Autowired
    public HomeBeatService(BeatEntryRepository beatEntryRepository) {
        this.beatEntryRepository = beatEntryRepository;
    }

    public void beat(ZonedDateTime currentTimeSystem) {
        BeatEntry beatEntry = new BeatEntry();
        beatEntry.setDateTime(currentTimeSystem);
        beatEntryRepository.save(beatEntry);
    }

    private boolean isDevEnv() {
        return Arrays.stream(env.getActiveProfiles())
                .anyMatch(Predicate.isEqual("dev"));
    }

    public List<BeatEntry> listBeats(ZoneId zone, int page, int size) {
        return beatEntryRepository.findAllByOrderByIdDesc(PageRequest.of(page, size))
                .stream()
                .map(beatEntry -> beatEntry.withZonedDateTimeCopy(zone))
                .collect(Collectors.toList());
    }
}