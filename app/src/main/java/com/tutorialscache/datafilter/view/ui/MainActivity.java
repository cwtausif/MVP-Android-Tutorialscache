package com.tutorialscache.datafilter.view.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.tutorialscache.datafilter.R;
import com.tutorialscache.datafilter.model.DataModel;
import com.tutorialscache.datafilter.presenter.MainActivityPresenter;
import com.tutorialscache.datafilter.view.adapter.DataListAdapter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    RecyclerView recyclerView;
    MainActivityPresenter mainPresenter;
    DataListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //configuring recycler view
        recyclerView = findViewById(R.id.data_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //setting adapter to recycler view
        adapter = new DataListAdapter();
        recyclerView.setAdapter(adapter);

       //creating instance of presenter class
        mainPresenter = new MainActivityPresenter(this);

        //calling initData method of presenter class in which we added dtudent record
        mainPresenter.initData();
    }

   // interface method of mainActivityPresenter class
    @Override
    public void addDatas(ArrayList<DataModel> datas) {
        //adding array list in adapter
        adapter.submitList(datas);
        adapter.notifyDataSetChanged();
        Log.d("response","onCreate: "+datas+" ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.sortNameASC:
                //calling presenter class method for sorting name in ascending order.
                mainPresenter.sortNameASC();
                adapter.notifyDataSetChanged();
                break;
            case R.id.sortNameDSC:
                //calling presenter class method for sorting name in dscending order.
                mainPresenter.sortNameDSC();
                adapter.notifyDataSetChanged();
                break;
            case R.id.sortDateASC:
                //calling presenter class method for sorting roll no. in ascending order.
                mainPresenter.sortRollNoASC();
                adapter.notifyDataSetChanged();
                break;
            case R.id.sortDateDSC:
                //calling presenter class method for sorting roll no. in dscending order.
                mainPresenter.sortRollNoDSC();
                adapter.notifyDataSetChanged();
                break;
                default:
                    break;
        }
        return super.onOptionsItemSelected(item);
    }
}

