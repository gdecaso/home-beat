package ar.curiosidadesespaciales.homebeat.api;

import ar.curiosidadesespaciales.homebeat.api.dto.BeatPageDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
public interface HomeBeatApi {
    @RequestMapping(value = "/beats", produces = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<String> beatsPost();

    @RequestMapping(value = "/beats", produces = {"application/json"}, method = RequestMethod.GET)
    ResponseEntity<BeatPageDto> beatsGet(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size);
}