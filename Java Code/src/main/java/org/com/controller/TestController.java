package org.com.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.com.dao.TestDao;
import org.com.error.RecordNotFoundException;
import org.com.model.Test1;
import org.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin("http://localhost:4200")

public class TestController {
	User user;
	
	@Autowired
	TestDao dao;
	
//////////////////////////////////////////////////////////////////////////////////////////////	
/*
	@GetMapping("/getTest")
	//@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Test1> saveTest(@RequestBody Test1 test)
	{
	
	try {
		//if(user.isAdmin()) {
		Optional<Test1> findById= dao.findById(test.getTestId());
		
		//try {
		if(!findById.isPresent())
		{
			dao.save(test);
			System.out.println("Test added...");
		
		return new ResponseEntity<Test1>(test,HttpStatus.OK);
		}		
		else
			throw new RecordNotFoundException("Test already present...");
		
		}
		//else
			//throw new RecordNotFoundException("You are not admin");
		
		//}
	catch(RecordNotFoundException e)
		{
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
		*/
	@PostMapping("/getTest")
	public Test1 saveTest (@Valid @RequestBody Test1 test)
	{
		return dao.save(test);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////

	@PutMapping("/getTest")
	//@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Test1> updateTest(@Valid @RequestBody Test1 test)
	{

		Optional<Test1> findById=dao.findById(test.getTestId());
		try {
		if(findById.isPresent())
		{
			 dao.save(test);
			 System.out.println("Test Updated...");
			 return new ResponseEntity<Test1>(test,HttpStatus.OK);
			
			
		}
		else {
			throw new RecordNotFoundException("Test not present...");
			}
		}
		catch(RecordNotFoundException e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		
	}
		}
	
//////////////////////////////////////////////////////////////////////////////////////////////
	
	@DeleteMapping("/getTest/{id}")
	//@ExceptionHandler(RecordNotFoundException.class)
		public ResponseEntity<?> removeTest(@RequestBody Test1 test, @PathVariable("id") int tid)
		{
			try {
	//		if(user.isAdmin()) {
			Optional<Test1> findById=dao.findById(tid);
			if(findById.isPresent())
			{
				dao.deleteById(tid);
				System.out.println("Test removed...");
				return new ResponseEntity<Test1>(test,HttpStatus.OK);
			}
			else
				throw new RecordNotFoundException("Test not present...");
			}
			
			
	catch(RecordNotFoundException e)
	{
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////		
	@PostMapping("/getTest")
	public List<Test1> showAllTest()
	{
		return dao.findAll();	
	}

//////////////////////////////////////////////////////////////////////////////////////////////	
	public void assignTest()
	{
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////	

	public void addQuestions()
	{
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////	
	public void deleteQuestions()
	{
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////	
	public void getResult()
	{
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////	
}
