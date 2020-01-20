package com.tutorialscache.datafilter.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tutorialscache.datafilter.R;
import com.tutorialscache.datafilter.model.DataModel;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

//we will refactor our RecyclerView.Adapter to a ListAdapter ,so now list adapter will handle all operation
public class DataListAdapter extends ListAdapter<DataModel,DataListAdapter.ViewHolder> {

    //Constructor
    public DataListAdapter() {
        super(DIFF_CALLBACK);
    }
    //to check weather to items have same id or not
    private static final DiffUtil.ItemCallback<DataModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<DataModel>() {
        @Override
        public boolean areItemsTheSame(DataModel oldItem, DataModel newItem) {
            return oldItem.getId() == newItem.getId();
        }
        //to check weather to items have same contects or not
        @Override
        public boolean areContentsTheSame(DataModel oldItem, DataModel newItem) {
            return oldItem.getName().equals(newItem.getName()) &&
                    oldItem.getRollNumber()==newItem.getRollNumber();
        }
    };

        @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.data_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(getItem(position).getName());
        holder.rollNo.setText(String.valueOf(getItem(position).getRollNumber()));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView name, rollNo;
        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_item_name);
            rollNo = itemView.findViewById(R.id.tv_item_rollNo);
        }
    }
}