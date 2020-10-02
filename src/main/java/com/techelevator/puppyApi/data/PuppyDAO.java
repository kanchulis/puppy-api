package com.techelevator.puppyApi.data;

import java.util.List;

import com.techelevator.puppyApi.model.Puppy;

public interface PuppyDAO {

	public List<Puppy> getPuppies();
	
	public Puppy getPuppy(int id);
	
	public void savePuppy(Puppy puppyToSave);
	
	public void removePuppy(int id);
	
	public void editPuppy(Puppy puppyToSave);
	
}
