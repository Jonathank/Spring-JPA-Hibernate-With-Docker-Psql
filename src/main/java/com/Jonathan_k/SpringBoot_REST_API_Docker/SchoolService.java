/**
 * 
 */
package com.Jonathan_k.SpringBoot_REST_API_Docker;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * @author JONATHAN
 */
@Service
public class SchoolService {

    private final SchoolRepository repo;
    private final SchoolMapper schoolMapper;
    /**
     * @param repo
     * @param schoolMapper
     */
    public SchoolService(SchoolRepository repo, SchoolMapper schoolMapper) {
	this.repo = repo;
	this.schoolMapper = schoolMapper;
    }
    
    public SchoolDto addSchool(SchoolDto schooldto) {
    var school =schoolMapper.toStudent(schooldto);
	 repo.save(school);
	 return schooldto;
    }
    
    public School addStudent(School school) {
	return repo.save(school);
    }
    
    public List<SchoolDto>getAllSchoolsDto(){
	return repo.findAll()
		.stream()
		.map(schoolMapper::toSchoolDto)
		.collect(Collectors.toList());
    }
    
    public List<School>getAllSchools(){
	return repo.findAll();
       }
}
