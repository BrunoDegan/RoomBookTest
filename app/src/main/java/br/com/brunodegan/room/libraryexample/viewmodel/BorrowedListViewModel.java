package br.com.brunodegan.room.libraryexample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import br.com.brunodegan.room.libraryexample.database.BorrowDatabase;
import br.com.brunodegan.room.libraryexample.model.BorrowModel;

public class BorrowedListViewModel extends AndroidViewModel {
	
	private LiveData<List<BorrowModel>> modelList;
	private BorrowDatabase database;
	
	public BorrowedListViewModel(Application application) {
		super(application);
		
		database = BorrowDatabase.getInstance(application);
		
		modelList = database.getItemByPerson().getAllBorrow();
	}
	
}
