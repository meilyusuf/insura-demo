package com.insura.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insura.demo.model.Siswa;

@Repository
public interface SiswaRepo extends CrudRepository<Siswa, Long> {

	List<Siswa> findByNomorInduk(String nomorInduk);

	Siswa findByNama(String nama);

}
