package cz.expertkom.ju.L07HomeWorkProduts;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.expertkom.ju.DownloadProductToDb;

@Service
public class InitSequence {
	
	@Autowired
	DownloadProductToDb dpToDb;

	@PostConstruct
	public void initSequence() {
		
	/* stáhni products z web Page do databáze */
		dpToDb.downloadProductTodb();
		
	}

}
