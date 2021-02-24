package com.example.colleagueslist;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFrag newInstance(String param1, String param2) {
        AddFrag fragment = new AddFrag();
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
        View V =  inflater.inflate(R.layout.fragment_add, container, false);

        return V;
    }

     public void addperson(String name , String phone , String institution , String email)
    {
        ColleagueDataHelper helper = new ColleagueDataHelper(getContext());
        SQLiteDatabase db = helper.getReadableDatabase();

        ContentValues values = new ContentValues() ;
        values.put(ColleagueListContract.Column.PERSON_NAME,name);
        values.put(ColleagueListContract.Column.INSTITUTION_NAME,institution);
        values.put(ColleagueListContract.Column.PHONE,phone);
        values.put(ColleagueListContract.Column.EMAIL,email);

        db.insert(ColleagueListContract.Table.NAME,null,values) ;
    }

}