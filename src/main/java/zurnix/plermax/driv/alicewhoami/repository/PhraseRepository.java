package zurnix.plermax.driv.alicewhoami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zurnix.plermax.driv.alicewhoami.model.Phrase;

@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
}
