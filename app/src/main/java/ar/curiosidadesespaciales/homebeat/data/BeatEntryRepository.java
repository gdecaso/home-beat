package ar.curiosidadesespaciales.homebeat.data;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BeatEntryRepository {
    List<BeatEntry> findAllByOrderByIdDesc(Pageable pageable);

    BeatEntry save(BeatEntry beatEntry);
}
