package com.insura.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.insura.demo.model.Nilai;

public interface NilaiRepo extends CrudRepository<Nilai, Long> {

	List<Nilai> findByNomorInduk(String nomorInduk);

	List<Nilai> findByMataPelajaran(String mataPelajaran);

}
