package com.example.colleagueslist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFrag extends Fragment {
    listadapter listadapter = null ;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFrag newInstance(String param1, String param2) {
        HomeFrag fragment = new HomeFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View  V  =  inflater.inflate(R.layout.fragment_home, container, false);
       MainActivity.person.clear();
       getdatafromdatabase();
      // person.add(new PersonInfo("sourav","email","hindu","2323000")) ;
        ListView listView = V.findViewById(R.id.listhomeholder) ;
       listadapter = new listadapter(getActivity(),MainActivity.person);
       listView.setAdapter(listadapter);
        return V ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void getdatafromdatabase()
    {
        ColleagueDataHelper helper = new ColleagueDataHelper(getContext()) ;
        SQLiteDatabase db = helper.getReadableDatabase();

          String [] projection  = {ColleagueListContract.Column.PERSON_NAME
          ,ColleagueListContract.Column.PHONE};
        Cursor cursor = db.query(ColleagueListContract.Table.NAME,projection,null,null,null
        ,null,null) ;

        while (cursor.moveToNext()) {
            PersonInfo info = new PersonInfo(cursor.getString(0), "", "",
                    cursor.getString(1));
            MainActivity.person.add(info);
        }


        cursor.close();
    }
}