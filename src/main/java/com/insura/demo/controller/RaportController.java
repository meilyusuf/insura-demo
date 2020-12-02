package com.insura.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insura.demo.dto.RaportDto;
import com.insura.demo.services.RaportService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class RaportController {
	
	@Autowired
	RaportService raportService;
		
	@GetMapping(value="/raport")
	@ApiOperation(value = "get raport with filter", response = RaportDto.class, responseContainer = "List")
	public ResponseEntity<List<RaportDto>> getRaport(@RequestParam(required = false) String nomorInduk,
			@RequestParam(required = false) String nama,
			@RequestParam(required = false) String mataPelajaran) {
		List<RaportDto> listRaport = new ArrayList<RaportDto>();
		if (StringUtils.isNotBlank(nomorInduk)) {
			listRaport = raportService.findByNomorInduk(nomorInduk);
		} else if (StringUtils.isNotBlank(nama)) {
			listRaport = raportService.findByNamaSiswa(nama);
		} else if (StringUtils.isNotBlank(mataPelajaran)) {
			listRaport = raportService.findByMataPelajaran(mataPelajaran);
		} else {
			listRaport = raportService.getAllRaport();
		}
		return new ResponseEntity<>(listRaport, HttpStatus.OK);
	}
	
	@PutMapping(value="/raport/{id}")
	public RaportDto updateRaport(@PathVariable("id") Long id, @RequestBody RaportDto raport) {	
		return raportService.updateRaportById(id,raport);
	}
	
	@DeleteMapping("/raport/{id}")
	public ResponseEntity<HttpStatus> deleteRaportById(@PathVariable("id") Long id) {
		try {
			  raportService.deleteRaportById(id);
		      return new ResponseEntity<>(HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
	}
	

}
