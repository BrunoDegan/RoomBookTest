package br.com.brunodegan.room.libraryexample.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.brunodegan.room.libraryexample.R;
import br.com.brunodegan.room.libraryexample.model.BorrowModel;
import br.com.brunodegan.room.libraryexample.viewmodel.BorrowedListViewModel;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
	
	private BorrowedListViewModel viewModel;
	private RecyclerViewAdapter recyclerViewAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(MainActivity.this, AddActivity.class));
			}
		});
		
		RecyclerView recyclerView = findViewById(R.id.rc_view);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		
		recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(),
				new ArrayList<BorrowModel>(),
				this);
		
		recyclerView.setAdapter(recyclerViewAdapter);
		
		viewModel = ViewModelProviders.of(this).get(BorrowedListViewModel.class);
		
		viewModel.getModelList().observe(MainActivity.this, new Observer<List<BorrowModel>>() {
			@Override
			public void onChanged(@Nullable List<BorrowModel> item) {
				recyclerViewAdapter.addItem(item);
				recyclerViewAdapter.notifyDataSetChanged();
			}
		});
	}
	
	@Override
	public boolean onLongClick(View view) {
		BorrowModel borrowModel = (BorrowModel) view.getTag();
		viewModel.deleteItem(borrowModel);
		return true;
	}
}
