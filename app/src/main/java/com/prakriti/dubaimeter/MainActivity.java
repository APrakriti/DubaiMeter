package com.prakriti.dubaimeter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {
    EditText editText;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.listview);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Nepali");
        listDataHeader.add("English");
        listDataHeader.add("Hindi");

        // Adding child data
        List<String> Nepali = new ArrayList<String>();
        Nepali.add("Chakka Panja");
        Nepali.add("Nai Nabhannu la");
        Nepali.add("Prem Geet");
        Nepali.add("Kabaddi");
        Nepali.add("Ma Yesto Geet Gauxu");
        Nepali.add("Loot");
        Nepali.add("Chapali Height");
        Nepali.add("How Funny");
        Nepali.add("Woda Number:6");
        Nepali.add("Kalo Pothi");
        Nepali.add("Dhana Patti");
        Nepali.add("Pashupati Prasad");
        Nepali.add("Darpan Chaya");
        Nepali.add("First Love");
        Nepali.add("Kabaddi Kabaddi");

        List<String> English = new ArrayList<String>();
        English.add("The Conjuring");
        English.add("Despicable Me 2");
        English.add("Turbo");
        English.add("Titanic");
        English.add("Van Helsing");
        English.add("Red Ridding Hood");
        English.add("The Wolverine");
        English.add("The Chronicals of Narniya");
        English.add("Ghost Rider");
        English.add("Avatar");

        List<String> Hindi = new ArrayList<String>();
        Hindi.add("Student of the year");
        Hindi.add("Kal Ho Na Ho");
        Hindi.add("DDLJ");
        Hindi.add("Yeh Jawani Heh Diwani");
        Hindi.add("Barfi");
        Hindi.add("Jagga Jasus");
        Hindi.add("Happy New Year");
        Hindi.add("Dilwale");
        Hindi.add("Sing Is King");
        Hindi.add("Hera Phir");
        Hindi.add("Don");


        listDataChild.put(listDataHeader.get(0), Nepali);
        listDataChild.put(listDataHeader.get(1), English);
        listDataChild.put(listDataHeader.get(2), Hindi);
    }
}
