package br.com.brunodegan.room.libraryexample.view;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import br.com.brunodegan.room.libraryexample.R;
import br.com.brunodegan.room.libraryexample.model.BorrowModel;
import br.com.brunodegan.room.libraryexample.viewmodel.BorrowedListViewModel;

public class AddActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
	
	private Date date;
	private DatePickerDialog datePickerDialog;
	private Calendar calendar;
	
	private EditText itemEditText;
	private EditText nameEditText;
	
	private BorrowedListViewModel addBorrowViewModel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		itemEditText = findViewById(R.id.itemName);
		nameEditText = findViewById(R.id.personName);
		
		calendar = Calendar.getInstance();
		addBorrowViewModel = ViewModelProviders.of(this).get(BorrowedListViewModel.class);
		
		datePickerDialog = new DatePickerDialog(this, AddActivity.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		
		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (itemEditText.getText() == null || nameEditText.getText() == null || date == null)
					Toast.makeText(AddActivity.this, "Missing fields", Toast.LENGTH_SHORT).show();
				else {
					addBorrowViewModel.addNewModel(new BorrowModel(
							itemEditText.getText().toString(),
							nameEditText.getText().toString(),
							date
					));
					finish();
				}
			}
		});
		
		
		findViewById(R.id.dateButton).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				datePickerDialog.show();
			}
		});
	}
	
	
	@Override
	public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		date = calendar.getTime();
		
	}
	
	
}