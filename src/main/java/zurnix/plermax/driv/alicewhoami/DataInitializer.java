package zurnix.plermax.driv.alicewhoami;

import java.io.File;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import zurnix.plermax.driv.alicewhoami.model.Phrase;
import zurnix.plermax.driv.alicewhoami.repository.PhraseRepository;

@Component
public class DataInitializer implements CommandLineRunner {
    @Value("${phrases.file.name}")
    private String phrasesFileName;

    private final PhraseRepository phraseRepository;

    public DataInitializer(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        File file = new File(phrasesFileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String phrase = scanner.nextLine();
            phraseRepository.save(new Phrase(phrase));
        }
        scanner.close();
    }

}