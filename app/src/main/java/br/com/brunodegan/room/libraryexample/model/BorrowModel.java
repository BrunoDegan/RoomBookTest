package br.com.brunodegan.room.libraryexample.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;


@Entity
public class BorrowModel {
	
	@PrimaryKey(autoGenerate = true)
	private int id;
	
	private String itemName;
	
	private String personName;
	
	@TypeConverters(DateConverter.class)
	private Date borrowDate;
	
	public BorrowModel(String itemName, String personName, Date borrowDate) {
		this.borrowDate = borrowDate;
		this.itemName = itemName;
		this.personName = personName;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getPersonName() {
		return personName;
	}
	
	public void setPersonName(String personName) {
	
		this.personName = personName;
	}

}
