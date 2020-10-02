package com.techelevator.puppyApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.puppyApi.data.PuppyDAO;
import com.techelevator.puppyApi.model.Puppy;

@RestController
public class PuppyController {
	
	@Autowired
	PuppyDAO dao;

	@RequestMapping(path="/test", method = RequestMethod.GET)
	public void test() {
		System.out.println("It's working!");
	}
	
	// If our user wants to see a list of puppies:
	// 1. We need to read the data from the database
	// 2. Using that data, we create some puppy objects.
	// 3. Serialize the puppy objects into JSON.
	
	// What we want to do:
	// when the user goes to /allPuppies it will return a JSON array
	// containing all the puppies.
	
	@RequestMapping(path = "/allPuppies", method = RequestMethod.GET)
	public List<Puppy> getAllPuppies() {

		List<Puppy> allPuppies = dao.getPuppies();
		return allPuppies;
		
	}
	
	//What we want to do:
	// Given an id, return 1 JSON puppy object.
	// When the user goes to /puppy/1, it will return the puppy with an id of 1
	
	
	@RequestMapping(path="/puppy/{id}", method = RequestMethod.GET)	// If you dont have a method = , it defaults to a GET
	public Puppy returnPuppyById(@PathVariable int id) {
		
		Puppy puppy = dao.getPuppy(id);
		
		return puppy;
		
	}
	
	@RequestMapping(path="/puppy/{id}", method = RequestMethod.DELETE)
	public void adoptPuppy(@PathVariable int id) {
		
		dao.removePuppy(id);
	}
	
	@RequestMapping(path="/addPuppy", method = RequestMethod.POST)
	public void addPuppy(@Valid @RequestBody Puppy puppy) {
		
		dao.savePuppy(puppy);
	}
	
	
	
	
	
}
