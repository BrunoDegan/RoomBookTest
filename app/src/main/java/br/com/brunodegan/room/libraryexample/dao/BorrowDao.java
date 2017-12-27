package br.com.brunodegan.room.libraryexample.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.brunodegan.room.libraryexample.model.BorrowModel;
import br.com.brunodegan.room.libraryexample.model.DateConverter;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters(DateConverter.class)
public interface BorrowDao {
	
	@Insert(onConflict = REPLACE)
	void insertNewBorrow(BorrowModel borrow);
	
	@Delete
	void deleteBorrow(BorrowModel borrow);
	
	@Update
	void updateBorrow(BorrowModel borrow);
	
	@Query("select * from BorrowModel where id = :id")
	LiveData<BorrowModel> getItemById(int id);
	
	@Query("select * from BorrowModel")
	LiveData<List<BorrowModel>> getAllBorrow();
	
	@Query("select * from BorrowModel where itemName = :itemName")
	LiveData<List<BorrowModel>> getBorrowModelByName(String itemName);
	
	@Query("select * from BorrowModel where personName = :personName")
	LiveData<List<BorrowModel>> getBorrowModelByPersonName(String personName);
	
	@Query("select * from BorrowModel where DATALENGHT(personName) <> '' AND personName IS NOT NULL")
	LiveData<List<BorrowModel>> getAllBorrowedBooks();
	
}
