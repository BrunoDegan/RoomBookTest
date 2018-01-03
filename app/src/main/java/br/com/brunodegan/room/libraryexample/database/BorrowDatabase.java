package br.com.brunodegan.room.libraryexample.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import java.util.List;

import br.com.brunodegan.room.libraryexample.dao.BorrowDao;
import br.com.brunodegan.room.libraryexample.model.BorrowModel;

@Database(entities = {BorrowModel.class}, version = 1,exportSchema = false)
public abstract class BorrowDatabase extends RoomDatabase {
	
	private static final String BORROW_DB = "borrow_db";
	private static BorrowDatabase borrowDatabaseInstance;
	private LiveData<List<BorrowModel>> itemModel;
	
	public static BorrowDatabase getInstance(final Context context) {
		
		if (borrowDatabaseInstance == null) {
			synchronized (BorrowDatabase.class) {
				if (borrowDatabaseInstance == null) {
					borrowDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(),
							BorrowDatabase.class, BORROW_DB).build();
				}
			}
		}
		return borrowDatabaseInstance;
	}
	
	public LiveData<List<BorrowModel>> getItemModel() {
		return itemModel;
	}
	
	public abstract BorrowDao getItemByPerson();
}
