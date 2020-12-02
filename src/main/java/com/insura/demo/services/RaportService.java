package com.insura.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insura.demo.dto.RaportDto;
import com.insura.demo.model.Nilai;
import com.insura.demo.model.Siswa;
import com.insura.demo.repositories.NilaiRepo;
import com.insura.demo.repositories.SiswaRepo;

@Service
public class RaportService {
	
	@Autowired
	NilaiRepo nilaiRepo;
	
	@Autowired
	SiswaRepo siswaRepo;

	public List<RaportDto> getAllRaport() {
		List<Nilai> listNilai = (List<Nilai>) nilaiRepo.findAll();
		List<Siswa> listSiswa = (List<Siswa>) siswaRepo.findAll();
		return modeltoReportDto(listNilai, listSiswa);
	}
	public List<RaportDto> findByNomorInduk(String nomorInduk) {
		List<Nilai> listNilai = (List<Nilai>) nilaiRepo.findByNomorInduk(nomorInduk);
		Siswa siswa =  (Siswa) siswaRepo.findByNomorInduk(nomorInduk);
		return modeltoReportDto(listNilai, siswa);
	}
	
	public List<RaportDto> findByNamaSiswa(String nama) {
		Siswa siswa =  (Siswa) siswaRepo.findByNama(nama);
		List<Nilai> listNilai = (List<Nilai>) nilaiRepo.findByNomorInduk(siswa.getNomorInduk());
		return modeltoReportDto(listNilai, siswa);
	}
	
	public List<RaportDto> findByMataPelajaran(String mataPelajaran) {
		List<Nilai> listNilai = (List<Nilai>) nilaiRepo.findByMataPelajaran(mataPelajaran);
		List<Siswa> listSiswa = (List<Siswa>) siswaRepo.findAll();
		return modeltoReportDto(listNilai, listSiswa);
	}
	
	public RaportDto updateRaportById(Long id, RaportDto raportDto) {
		Optional<Nilai> nilai = nilaiRepo.findById(id);
		if(nilai.isPresent()) {
			Nilai nilaiUpdt = toNilai(id,raportDto);
			nilaiRepo.save(nilaiUpdt);
			raportDto.setId(nilaiUpdt.getId());
		}
		return raportDto;
	}
	
	public void deleteRaportById(Long id) {
		nilaiRepo.deleteById(id);
	}
	
	private Nilai toNilai(Long id,RaportDto raportDto) {
		Nilai nilai = new Nilai();
		nilai.setId(raportDto.getId());
		nilai.setNomorInduk(raportDto.getNomorInduk());
		nilai.setMataPelajaran(raportDto.getMataPelajaran());
		nilai.setNilai(raportDto.getNilai());
		return nilai;
	}
	
	
	private List<RaportDto> modeltoReportDto(List<Nilai> listNilai, List<Siswa> listSiswa) {
		List<RaportDto> listRaport = new ArrayList<>();
		for (Nilai nilai : listNilai) {
			RaportDto raport = new RaportDto();
			raport.setId(nilai.getId());
			raport.setMataPelajaran(nilai.getMataPelajaran());
			raport.setNomorInduk(nilai.getNomorInduk());
			raport.setNilai(nilai.getNilai());
			for (Siswa siswa : listSiswa) {
				if(nilai.getNomorInduk().equalsIgnoreCase(nilai.getNomorInduk())) {
					raport.setNama(siswa.getNama());
				}
			}
			listRaport.add(raport);
		}
		return listRaport;
	}
	
	private List<RaportDto> modeltoReportDto(List<Nilai> listNilai, Siswa siswa) {
		List<RaportDto> listRaport = new ArrayList<>();
		for (Nilai nilai : listNilai) {
			RaportDto raport = new RaportDto();
			raport.setId(nilai.getId());
			raport.setMataPelajaran(nilai.getMataPelajaran());
			raport.setNomorInduk(nilai.getNomorInduk());
			raport.setNilai(nilai.getNilai());
			raport.setNama(siswa.getNama());
			listRaport.add(raport);
		}
		return listRaport;
	}
	
	
	

}
