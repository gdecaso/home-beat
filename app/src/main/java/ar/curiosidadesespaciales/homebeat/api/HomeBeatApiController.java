package ar.curiosidadesespaciales.homebeat.api;

import ar.curiosidadesespaciales.homebeat.api.dto.BeatPageDto;
import ar.curiosidadesespaciales.homebeat.data.BeatEntry;
import ar.curiosidadesespaciales.homebeat.service.HomeBeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeBeatApiController implements HomeBeatApi {

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_SIZE = 10;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final HomeBeatService service;
    private final Mapper mapper;

    @Autowired
    public HomeBeatApiController(HomeBeatService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<String> beatsPost() {
        ZonedDateTime now = ZonedDateTime.now();
        service.beat(now);
        return ResponseEntity.ok(String.format("Beat received at %s", now));
    }

    @Override
    public ResponseEntity<BeatPageDto> beatsGet(Integer tzOffsetHours, Integer pageOrNull, Integer sizeOrNull) {
        ZoneId zone = calculateZone(tzOffsetHours);
        int page = pageOrNull != null ? pageOrNull : DEFAULT_PAGE;
        int size = sizeOrNull != null ? sizeOrNull : DEFAULT_SIZE;
        List<BeatEntry> beatEntries = service.listBeats(zone, page, size);
        return ResponseEntity.ok(mapper.modelToApis(beatEntries, page, size));
    }

    private ZoneId calculateZone(Integer tzOffsetHours) {
        return Optional.ofNullable(tzOffsetHours)
                .map(ZoneOffset::ofHours)
                .map(offset -> ZoneId.ofOffset("", offset))
                .orElse(ZoneId.systemDefault());
    }
}
