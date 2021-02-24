package com.example.colleagueslist;

import android.provider.BaseColumns;

public class ColleagueListContract {
    public static class Table {
       public final static String NAME = "colleague" ;


    }
    public static class Column implements BaseColumns {
        final public static String _ID = BaseColumns._ID ;
        public static String PERSON_NAME = "name" ;
        public static String EMAIL = "email" ;
        public static String PHONE = "phone" ;
        public static String INSTITUTION_NAME = "institution_name";


    }
}
