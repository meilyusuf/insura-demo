package com.insura.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PropertiesConfig {
	
	@Value("${dir.siswa}")
	private String dirSiswa;
	
	@Value("${dir.nilai}")
	private String dirNilai;
	

}
