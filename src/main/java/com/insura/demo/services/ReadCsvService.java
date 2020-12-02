package com.insura.demo.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insura.demo.config.PropertiesConfig;
import com.insura.demo.model.Nilai;
import com.insura.demo.model.Siswa;
import com.insura.demo.repositories.NilaiRepo;
import com.insura.demo.repositories.SiswaRepo;

@Service
public class ReadCsvService {

	@Autowired
	private PropertiesConfig prop;

	@Autowired
	NilaiRepo nilaiRepo;

	@Autowired
	SiswaRepo siswaRepo;

	private final static Logger logger = LoggerFactory.getLogger(ReadCsvService.class);

	public void ReadCsvSiswa() throws IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(prop.getDirSiswa()));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim());) {

			List<Siswa> listSiswa = new ArrayList<>();
			for (CSVRecord csvRecord : csvParser) {
				Siswa siswa = new Siswa();
				siswa.setNomorInduk(csvRecord.get("nomor_induk"));
				siswa.setNama(csvRecord.get("nama"));
				siswa.setKelas(csvRecord.get("kelas"));
				listSiswa.add(siswa);
			}
			siswaRepo.saveAll(listSiswa);
		} catch (Exception ex) {
			throw new RuntimeException("fail read CSV: " + ex.getMessage());
		}

	}

	public void ReadCsvNilai() throws IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(prop.getDirNilai()));
				CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim());) {

			List<Nilai> listNilai = new ArrayList<>();
			for (CSVRecord csvRecord : csvParser) {
				Nilai nilai = new Nilai();
				nilai.setNomorInduk(csvRecord.get("nomor_induk"));
				nilai.setMataPelajaran(csvRecord.get("mata_pelajaran"));
				nilai.setNilai(Integer.valueOf(csvRecord.get("nilai")));
				listNilai.add(nilai);
			}
			nilaiRepo.saveAll(listNilai);
		} catch (Exception ex) {
			throw new RuntimeException("fail read CSV: " + ex.getMessage());
		}

	}

}
