package br.com.brunodegan.room.libraryexample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import br.com.brunodegan.room.libraryexample.asynctask.DeleteAsyncTask;
import br.com.brunodegan.room.libraryexample.asynctask.InsertAsyncTask;
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
	
	public LiveData<List<BorrowModel>> getModelList() {
		return modelList;
	}
	
	public void deleteItem (BorrowModel model) {
		new DeleteAsyncTask(database).execute(model);
	}
	
	public void addNewModel(BorrowModel model) {
		new InsertAsyncTask(database).execute(model);
	}
}
