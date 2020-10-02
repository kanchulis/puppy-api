package com.techelevator.puppyApi.data;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.puppyApi.model.Puppy;


public class PuppyJdbcDAO implements PuppyDAO {
	
	private JdbcTemplate template;
	
	public PuppyJdbcDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Puppy> getPuppies() {
		// TODO Auto-generated method stub
		
		String sqlGetAllPuppies = "SELECT * FROM puppies";
		
		List<Puppy> puppyList = new ArrayList<>();
		
		SqlRowSet result = template.queryForRowSet(sqlGetAllPuppies);
		
		while(result.next()) {
			
			int id = result.getInt("id");
			String name = result.getString("name");
			int weight = result.getInt("weight");
			String gender = result.getString("gender");
			boolean paperTrained = result.getBoolean("paper_trained");
			
			Puppy puppy = new Puppy(id, name, weight, gender, paperTrained);
			puppyList.add(puppy);
			
		}
		
		return puppyList;
	}

	@Override
	public Puppy getPuppy(int id) {
		// TODO Auto-generated method stub
		
		String getPuppySQL = "SELECT * FROM puppies WHERE id = ?";
		SqlRowSet result = template.queryForRowSet(getPuppySQL, id);
		Puppy puppy = null;
		
		if (result.next()) {
			
			int id2 = result.getInt("id");
			String name = result.getString("name");
			int weight = result.getInt("weight");
			String gender = result.getString("gender");
			boolean paperTrained = result.getBoolean("paper_trained");
			
			puppy = new Puppy(id2, name, weight, gender, paperTrained);
			
		}
		
		return puppy;
	}

	@Override
	public void savePuppy(Puppy puppyToSave) {
		// TODO Auto-generated method stub
		
		int id = puppyToSave.getId();
		String name = puppyToSave.getName();
		int weight = puppyToSave.getWeight();
		String gender = puppyToSave.getGender();
		boolean paperTrained = puppyToSave.isPaperTrained();
		
		String sqlForSave = "INSERT INTO puppies(name, weight, gender, paper_trained) VALUES (?, ?, ?, ?)";
		template.update(sqlForSave, name, weight, gender, paperTrained);
		
	}

	@Override
	public void removePuppy(int id) {
		// TODO Auto-generated method stub
		
		String sqlForRemove = "DELETE FROM puppies WHERE id=?";
		template.update(sqlForRemove, id);
		
	}

	@Override
	public void editPuppy(Puppy puppyToSave) {
		// TODO Auto-generated method stub
		
		
	}

}
