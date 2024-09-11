package zurnix.plermax.driv.alicewhoami;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import zurnix.plermax.driv.alicewhoami.model.Phrase;
import zurnix.plermax.driv.alicewhoami.repository.PhraseRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PhraseRepository phraseRepository;

    public DataInitializer(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        phraseRepository.save(new Phrase("Сегодня ты герой!"));
        phraseRepository.save(new Phrase("Ты мудрец, несущий свет знаний."));
        phraseRepository.save(new Phrase("Сегодня ты авантюрист, готовый на всё!"));
        phraseRepository.save(new Phrase("Ты миротворец, приносящий гармонию."));
        phraseRepository.save(new Phrase("Сегодня ты творец великих свершений!"));
    }
}
