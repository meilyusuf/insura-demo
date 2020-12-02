package com.insura.demo.scheduler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.insura.demo.config.PropertiesConfig;
import com.insura.demo.services.ReadCsvService;

@Component
public class InputScheduler {
	
	private static final Logger logger = LoggerFactory.getLogger(InputScheduler.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Autowired
	ReadCsvService readCsvService;
	
	@Scheduled(cron = "${cron.expression}")
	public void cronJobInputCsv() throws IOException {
		
		logger.info("mulai job : {}", dateTimeFormatter.format(LocalDateTime.now()));
		readCsvService.ReadCsvNilai();
		readCsvService.ReadCsvSiswa();
		
	}

}
