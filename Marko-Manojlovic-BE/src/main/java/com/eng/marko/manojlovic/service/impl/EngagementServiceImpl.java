package com.eng.marko.manojlovic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eng.marko.manojlovic.entity.Engagement;
import com.eng.marko.manojlovic.entity.EngagementIdUsingIdClass;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.MyException;
import com.eng.marko.manojlovic.repository.EngagementRepository;
import com.eng.marko.manojlovic.repository.ProfessorRepository;
import com.eng.marko.manojlovic.repository.SubjectRepository;
import com.eng.marko.manojlovic.service.EngagementService;

@Service
public class EngagementServiceImpl implements EngagementService {
	@Autowired
	private EngagementRepository engagementRepository;
	@Autowired
	private ProfessorRepository professorRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	
	
	
	@Override
	public void saveEngagements(List<Engagement> engagements) throws MyException {
		
		for(Engagement eng : engagements) {
			EngagementIdUsingIdClass id = new EngagementIdUsingIdClass(eng.getProfessorId(), eng.getSubjectId());
			if(!engagementRepository.findById(id).isEmpty()) {
				throw new EntityExistsException(eng, "Engagement with id {"+eng.getProfessorId()+", "+eng.getSubjectId()+"} is already present in the database");
			}
			if(professorRepository.findById(eng.getProfessorId()).isEmpty()) {
				throw new MyException("Professor with id: " + eng.getProfessorId() + " is already present in the database!");
			}
			if(subjectRepository.findById(eng.getSubjectId()).isEmpty()) {
				throw new MyException("Subject with id: " + eng.getSubjectId() + " is already present in the database");
			}
		}
		this.engagementRepository.saveAll(engagements);
	}

	@Override
	public List<Engagement> findAll() {
		return engagementRepository.findAll();
	}
}
