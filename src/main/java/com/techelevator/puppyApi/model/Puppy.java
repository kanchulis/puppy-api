package com.techelevator.puppyApi.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class Puppy {
	
	private int id;
	
	@NotBlank (message = "You must give the puppy a name!")
	private String name;
	
	@Max (value = 100, message = "Uh oh, big doggo alert!")
	private int weight;
	
	private String gender;
	
	private boolean paperTrained;
	
	public Puppy(int id, String name, int weight, String gender, boolean paperTrained) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.gender = gender;
		this.paperTrained = paperTrained;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isPaperTrained() {
		return paperTrained;
	}

	public void setPaperTrained(boolean paperTrained) {
		this.paperTrained = paperTrained;
	}
	
	
	
	
}
