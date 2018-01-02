package br.com.brunodegan.room.libraryexample.asynctask;

import android.os.AsyncTask;

import br.com.brunodegan.room.libraryexample.database.BorrowDatabase;
import br.com.brunodegan.room.libraryexample.model.BorrowModel;

public class InsertAsyncTask extends AsyncTask<BorrowModel, Void, Void> {
	
	private BorrowDatabase borrowDatabase;
	
	public InsertAsyncTask(BorrowDatabase database) {
		this.borrowDatabase = database;
	}
	
	@Override
	protected Void doInBackground(BorrowModel... borrowModels) {
		borrowDatabase.insertNewItem(borrowModels[0]);
		return null;
	}
}
