package br.com.brunodegan.room.libraryexample.model;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {
	
	@TypeConverter
	public Date toDate(Long timestamp) {
		 return timestamp != null ? new Date(timestamp) : null;
	}
	
	
	@TypeConverter
	public Long toLong(Date timestamp) {
		return timestamp != null ? timestamp.getTime() : null;
	}
}
