package com.eng.marko.manojlovic.service;

import java.util.List;

import com.eng.marko.manojlovic.dto.SemesterDto;

public interface SemesterService {
	List<SemesterDto> findAll();
}
