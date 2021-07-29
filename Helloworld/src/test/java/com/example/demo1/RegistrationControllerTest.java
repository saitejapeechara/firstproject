package com.example.demo1;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;

import com.example.demo1.controller.RegistrationController;
import com.example.demo1.model.Coustmers;
import com.example.demo1.repo.CoustmerRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.exception.PasswordException;

class RegistrationControllerTest {

	
		@InjectMocks
		RegistrationController rc;
	    
	    
	    @Mock
		CoustmerRepo repo;
	    Coustmers p ;
	    @BeforeEach
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	        p = new Coustmers("sai","sai","saitejar",22,"1988-07-06","male",22);
	        System.out.println("Inside setup");
	    }

	 

	    @AfterEach
	    public void cleanup() {
	        System.out.println("Inside cleanup");
	    }

	 

	    @Test
	    @DisplayName("save to db-pw lenth>6")
	    void passwordTest1() throws PasswordException {
	    	
	       // p.setCpassword("password");
	        doReturn(p).when(repo).save(any(Coustmers.class));
	        
	       rc.details(p);
	        //ModelAndView mv = rc.details(p);
	        assertEquals(8, p.getCpassword().length(), "password length is greater than 6::criteria satisfied");
	    }

	 

	    @Test
	    @DisplayName("save to db-pw lenth=6")
	    void passwordTest2() throws PasswordException {
	        p.setCpassword("passwo");
	        doReturn(p).when(repo).save(any(Coustmers.class));
	        rc.details(p);
	        assertEquals(6, p.getCpassword().length(), "password length is 6::criteria satisfied");
	    }

	 

	    @Test
	    @DisplayName("dnt save to db,throw exceptn-pw lenth<6")
	    void passwordTest3() {
	        p.setCpassword("pass");
	        assertThrows(Exception.class, () -> rc.details(p),
	                "password length is less than 6::criteria violation,throws exception");
	    }

	 
	}

