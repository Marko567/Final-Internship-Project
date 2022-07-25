package com.eng.marko.manojlovic.service;

import java.util.List;

import com.eng.marko.manojlovic.entity.Engagement;
import com.eng.marko.manojlovic.exception.EntityExistsException;
import com.eng.marko.manojlovic.exception.MyException;

public interface EngagementService {
	void saveEngagements(List<Engagement> engagements) throws MyException;
	List<Engagement> findAll();
}
