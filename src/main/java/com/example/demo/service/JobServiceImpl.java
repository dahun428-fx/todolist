package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.JobDao;
import com.example.demo.vo.Job;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private JobDao jobDao;
	
	public List<Job> getAllJobs() {
		return jobDao.getAllJobs();
	}
}
