package zurnix.plermax.driv.alicewhoami;

import org.springframework.boot.SpringApplication;

public class TestAlicewhoamiApplication {

	public static void main(String[] args) {
		SpringApplication.from(AlicewhoamiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
