package com.crud.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Employee;
import com.crud.entity.Helper;
import com.crud.entity.Product;
import com.crud.service.EmplService;

@RestController
@RequestMapping("/mongo")
public class EmplController {
	
	@Autowired
	private EmplService emplService;

	@GetMapping("/endpoint")
	public ResponseEntity<String> getEndpoint() {
		return ResponseEntity.ok("   *********************This is the GET response.");

	}
	
	@PostMapping("/save")
	public Employee addEmpl(@RequestBody Employee empl)
	{
		UUID uId= Helper.generateUUID();
		empl.setuId(uId);
    	
    	empl.setTimestampMillis(System.currentTimeMillis());
		return emplService.saveEmp(empl);
	}
	
	@PostMapping("/saveAll")
	public List<Employee> addEmpls(@RequestBody List<Employee> empls) 
	{
		UUID uId= Helper.generateUUID();
		((Employee) empls).setuId(uId);
    	
    	((Employee) empls).setTimestampMillis(System.currentTimeMillis());
		return emplService.saveEmpls(empls);
	}
	
	 @GetMapping("/empl")
	 public List<Employee> getAllEmpls() 
	    {
	        return emplService.getEmpls();
	    }
	    
		@GetMapping("/empl/{eId}")
		public Employee getEmpl(@PathVariable int eId) {
			return emplService.getEmplById(eId);
		}
		
	
		 @DeleteMapping("/empl/{id}")
		    public String deleteEmpl(@PathVariable int eId) {
		        return emplService.deleteEmplById(eId);
		    }
		    
		    @PutMapping("/updateEmpl/{eId}")
		    public ResponseEntity<Employee> updateEmpl(@PathVariable int eId, @RequestBody Employee updatedEmpl) 
		    {
		        Employee existingEmployee = emplService.getEmplById(eId);

		        updatedEmpl.setuId(existingEmployee.getuId());
		        
		        if(updatedEmpl.geteName() != null)
		        {
		        	updatedEmpl.seteName(updatedEmpl.geteName());
		        }
		        else
		        {
		        	updatedEmpl.seteName(existingEmployee.geteName());
		        }
		        
		        
		        updatedEmpl.setTimestampMillis(System.currentTimeMillis());
		        
		        Employee savedNewEmployee = emplService.saveEmp(updatedEmpl);

		        return ResponseEntity.ok(savedNewEmployee);
		    }
		    
		    @GetMapping("/byUid/{uId}")
		    public List<Employee> getEmplBYUid(@PathVariable UUID uId)
		    {
		    	
		        return emplService.getEmplsByUid(uId);
		    }
		    
		    @GetMapping("/getLatest/product/{uId}")
		    public List<Employee> getLatestEmpl(@PathVariable UUID uId)
		    {
		    	
		    	return emplService.getLatestEmpl(uId);
		    }
		    
		    
}
