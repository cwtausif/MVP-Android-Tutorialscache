package com.tutorialscache.datafilter.presenter;

import android.util.Log;
import com.tutorialscache.datafilter.model.DataModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivityPresenter {

    private View view;
    DataModel dataModel;
    ArrayList<DataModel> datas=new ArrayList<DataModel>();

    public MainActivityPresenter(View view ) {
       this.view = view;
    }
    public void initData() {
        // student 1
        dataModel = new DataModel(1, "Oliver",11);
        datas.add(dataModel);

        //student 2
        dataModel = new DataModel(2, "George", 12);
        datas.add(dataModel);

        //student 3
        dataModel = new DataModel(3, "Harry" , 4);
        datas.add(dataModel);

        //student 4
        dataModel = new DataModel(4,  "Jack" , 7);
        datas.add(dataModel);

        //student 5
        dataModel = new DataModel(5, "Jacob", 8);
        datas.add(dataModel);

        //student 6
        dataModel = new DataModel(6, "Noah", 5);
        datas.add(dataModel);

        //student 7
        dataModel = new DataModel(7, "Charlie", 6);
        datas.add(dataModel);

        //student 8
        dataModel = new DataModel(8, "Thomas", 3);
        datas.add(dataModel);

        //student 9
        dataModel = new DataModel(10,  "Oscar", 1);
        datas.add(dataModel);

        //student 10
        dataModel = new DataModel(11, "William", 2);
        datas.add(dataModel);

        //student 11
        dataModel = new DataModel(12,  "Henry", 9);
        datas.add(dataModel);

        //student 12
        dataModel = new DataModel(13, "Freddie", 10);
        datas.add(dataModel);

        Log.d("response", "initData: " + datas + "");

        //passing data to interface method addDatas
        view.addDatas(datas);
    }

    //interface of main activity presenter to add data in arraylist of data model
    public interface View {
        void addDatas(ArrayList<DataModel> datas);
    }

   //methods for sorting name in ascending order
    public void sortNameASC()
    {
        Collections.sort(datas, new Comparator<DataModel>() {
            @Override
            public int compare(DataModel o1, DataModel o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        Log.d("response", "sortNameASC: "+datas+"");
    }

    //methods for sorting name in dscending order
    public void sortNameDSC()
    {
        Collections.sort(datas, new Comparator<DataModel>() {
            @Override
            public int compare(DataModel o1, DataModel o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        Log.d("response", "sortNameDSC: "+datas+"");
    }

    //methods for sorting Roll number in ascending order
    public void sortRollNoASC()
    {
        Collections.sort(datas, new Comparator<DataModel>() {
            @Override
            public int compare(DataModel o1, DataModel o2) {
                return o1.getRollNumber()-o2.getRollNumber();
            }
        });
        Log.d("response", "sortRollNoASC: "+datas+"");
    }

    //methods for sorting Roll number in dscending order
    public void sortRollNoDSC()
    {
        Collections.sort(datas, new Comparator<DataModel>() {
            @Override
            public int compare(DataModel o1, DataModel o2) {
                return o2.getRollNumber()-o1.getRollNumber();
            }
        });
        Log.d("response", "sortRollNoDSC: "+datas+"");
    }
}

