package br.com.brunodegan.room.libraryexample.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.brunodegan.room.libraryexample.R;
import br.com.brunodegan.room.libraryexample.model.BorrowModel;
import br.com.brunodegan.room.libraryexample.viewmodel.BorrowedListViewModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder>{
	
	private final Context mContext;
	private List<BorrowModel> borrowModelList;
	private final View.OnLongClickListener longClickListener;
	static final class RecycleViewHolder extends RecyclerView.ViewHolder{
		private final TextView dateTextView;
		private final TextView itemNameTextView;
		private final TextView nameTextView;
		public RecycleViewHolder(View itemView) {
			super(itemView);
			itemNameTextView = itemView.findViewById(R.id.itemTextView);
			nameTextView = itemView.findViewById(R.id.nameTextView);
			dateTextView = itemView.findViewById(R.id.dateTextView);
		}
		
	}
	
	public RecyclerViewAdapter(Context context,
	                           List<BorrowModel> borrowModelList,
	                           View.OnLongClickListener onLongClickListener) {
		this.mContext = context;
		this.borrowModelList = borrowModelList;
		this.longClickListener = onLongClickListener;
	}
	
	public void addItem(List<BorrowModel> itemList) {
		borrowModelList = itemList;
	}
	
	@Override
	public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return new RecycleViewHolder(LayoutInflater.from(mContext)
				.inflate(R.layout.recycler_item,parent,false));
	}
	
	@Override
	public void onBindViewHolder(RecycleViewHolder holder, int position) {
		BorrowModel model = borrowModelList.get(position);
		holder.dateTextView.setText(model.borrowDate.toString().substring(0,11));
		holder.itemNameTextView.setText(model.getItemName());
		holder.nameTextView.setText(model.getPersonName());
		holder.itemView.setTag(model);
		holder.itemView.setOnLongClickListener(longClickListener);
	}
	
	@Override
	public int getItemCount() {
		return borrowModelList.size();
	}
}
