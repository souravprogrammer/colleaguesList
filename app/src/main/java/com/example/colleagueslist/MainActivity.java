package com.example.colleagueslist;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.content.ClipData;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fabbuttion = null;
    public static ArrayList<PersonInfo> person = new ArrayList<PersonInfo>();
    boolean back_button_flag = false, cheakpoit = false;
    HomeFrag homeFrag;
    AddFrag addFrag;
    boolean ok_isvisible = false;
    final int ok_id = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeFrag = new HomeFrag();
        addFrag = new AddFrag();
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);// set drawable icon
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder, homeFrag).commit();
        fabbuttion = findViewById(R.id.fabbutton);
        fabbuttion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back_button_flag = true;
                if (ok_isvisible) {
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                    invalidateOptionsMenu();
                } else {
                    ok_isvisible = true;
                    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                    invalidateOptionsMenu();
                }

                addFrag = null;
                addFrag = new AddFrag();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder, addFrag).commit();
                fabbuttion.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (cheakpoit == false) {
            MenuItem item = null;
            if (menu.findItem(ok_id) == null && ok_isvisible) {
                item = menu.add(Menu.NONE, ok_id, 1, "Done");
                item.setIcon(R.drawable.ic_baseline_check_24);
                item.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS);

                /** This method call when  **/
                item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        EditText name = findViewById(R.id.namefield);
                        EditText phone = findViewById(R.id.phonenumber);
                        EditText instute = findViewById(R.id.collagename);
                        EditText email = findViewById(R.id.mail);

                        if (!name.getText().toString().equals("") && !phone.getText().toString().equals("")) {
                            fabbuttion.setVisibility(View.VISIBLE);
                            back_button_flag = false;

                            addFrag.addperson(name.getText().toString(),
                                    phone.getText().toString(),
                                    instute.getText().toString()
                                    , email.getText().toString());

                            item.setVisible(false);
                            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder, homeFrag).commit();
                            menu.removeItem(ok_id);
                            return true;
                        }
                        return true;
                    }
                });

            }
        } else {

            menu.removeItem(ok_id);
            cheakpoit = false;
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.delete_All:
                delete();
                break;
            default:
                if (getSupportActionBar().isShowing()) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder, homeFrag).commit();
                    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                    call();
                    fabbuttion.setVisibility(View.VISIBLE);
                }

        }


        return super.onOptionsItemSelected(item);
    }

    private void delete() {
        ColleagueDataHelper helper = new ColleagueDataHelper(this);
        SQLiteDatabase db  = helper.getReadableDatabase() ;
        Toast.makeText(this, "sup", Toast.LENGTH_SHORT).show();

        db.delete(ColleagueListContract.Table.NAME,null,null) ;
        homeFrag = null ;
        homeFrag = new HomeFrag() ;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder,homeFrag).commit() ;
    }

    private void call() {
        cheakpoit = true;
        supportInvalidateOptionsMenu();
    }
}