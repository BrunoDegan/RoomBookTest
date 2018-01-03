package br.com.brunodegan.room.libraryexample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import br.com.brunodegan.room.libraryexample.asynctask.InsertAsyncTask;
import br.com.brunodegan.room.libraryexample.database.BorrowDatabase;
import br.com.brunodegan.room.libraryexample.model.BorrowModel;

public class AddedBorrowViewModel extends AndroidViewModel {
	private BorrowDatabase appDatabase;
	
	public AddedBorrowViewModel(Application application) {
		super(application);
		appDatabase = BorrowDatabase.getInstance(application);
	}
	
	public void addBorrow(BorrowModel model) {
		new InsertAsyncTask(appDatabase).execute(model);
	}
}
