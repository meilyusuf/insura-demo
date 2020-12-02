package com.insura.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "nilai")
public class Nilai {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "nomor_induk")
	private String nomorInduk;
	
	@Column
	private String mataPelajaran;
	
	@Column
	private Integer nilai;
	
	

}
