package com.insura.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "siswa")
public class Siswa {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "nomor_induk")
	private String nomorInduk;
	
	@Column
	private String nama;
	
	@Column
	private String kelas;

}
