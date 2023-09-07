package com.crud.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Employee;
import com.crud.repository.EmplRepository;

@Service
public class EmplService {
	
	@Autowired
	private EmplRepository emplRepository;

	public Employee saveEmp(Employee empl)
	{
		return emplRepository.save(empl);
	}
	
	public List<Employee> saveEmpls(List<Employee> empls)
	{
		return emplRepository.saveAll(empls);
	}

	public List<Employee> getEmpls() {
		return emplRepository.findAll();
	}

	public Employee getEmplById(int eId) {
		return emplRepository.findById(eId).orElse(null);
	}

	public Employee updateEmpl(UUID uId,Employee updatedEmployee) {
        if (updatedEmployee.geteId() != 0) {
            return emplRepository.save(updatedEmployee);
        }
        return null;
    }
	

	public List<Employee> getLatestEmpl(UUID uId) {
		return emplRepository.findFirstByuIdOrderByTimestampMillisDesc(uId);

	}

	public List<Employee> getEmplsByUid(UUID uId) {
		return emplRepository.findAllByuId(uId);
	}

	public String deleteEmplById(int eId) {
		emplRepository.deleteById(eId);
        return "Product is deleted "+eId;
		
	}
}
