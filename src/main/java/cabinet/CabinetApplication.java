package cabinet;

import cabinet.service.FileStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.Resource;

@SpringBootApplication
public class CabinetApplication implements CommandLineRunner {
	@Resource
	FileStorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(CabinetApplication.class, args);
		System.out.println("work system");
	}

	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}
}
