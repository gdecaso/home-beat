package ar.curiosidadesespaciales.homebeat.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBeatEntryRepository extends BeatEntryRepository, JpaRepository<BeatEntry, Long> {

}