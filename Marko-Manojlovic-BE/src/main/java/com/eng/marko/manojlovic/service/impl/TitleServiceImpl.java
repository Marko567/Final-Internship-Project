package com.eng.marko.manojlovic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.entity.Title;
import com.eng.marko.manojlovic.repository.TitleRepository;
import com.eng.marko.manojlovic.service.TitleService;

@Service
@Transactional
public class TitleServiceImpl implements TitleService {
	@Autowired
	private TitleRepository titleRepository;
	
	@Override
	public List<Title> findAll() {
		return titleRepository.findAll();
	}

}
