package zurnix.plermax.driv.alicewhoami.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zurnix.plermax.driv.alicewhoami.model.Phrase;
import zurnix.plermax.driv.alicewhoami.repository.PhraseRepository;

@Service
public class PhraseService {

    @Autowired
    private PhraseRepository phraseRepository;

    private final Random random = new Random();

    // Метод для получения случайной фразы
    public String getRandomPhrase() {
        List<Phrase> phrases = phraseRepository.findAll();
        if (phrases.isEmpty()) {
            return "Фраз пока нет!";
        }
        return phrases.get(random.nextInt(phrases.size())).getContent();
    }
}
