package ar.curiosidadesespaciales.homebeat.api;

import ar.curiosidadesespaciales.homebeat.data.BeatEntry;
import ar.curiosidadesespaciales.homebeat.service.HomeBeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
public class HomeBeatApiController implements HomeBeatApi {

    public static final int DEFAULT_PAGE = 0;
    public static final int DEFAULT_SIZE = 10;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final HomeBeatService service;
    private final BeatEntryMapper mapper;

    @Autowired
    public HomeBeatApiController(HomeBeatService service, BeatEntryMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<String> beatsPost() {
        service.beat(ZonedDateTime.now());
        return ResponseEntity.ok("Beat received");
    }

    @Override
    public ResponseEntity<List<BeatEntryDto>> beatsGet(Integer pageOrNull, Integer sizeOrNull) {
        int page = pageOrNull != null ? pageOrNull : DEFAULT_PAGE;
        int size = sizeOrNull != null ? sizeOrNull : DEFAULT_SIZE;
        List<BeatEntry> beatEntries = service.listBeats(page, size);
        return ResponseEntity.ok(mapper.modelToApis(beatEntries));
    }
}
