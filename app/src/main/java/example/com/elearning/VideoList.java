package example.com.elearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VideoList extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    String position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        // get the listview
        expListView = findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Tutorial on Apps");
        listDataHeader.add("Tutorials on Website");
        listDataHeader.add("Toturials on Hardware");

        // Adding child data
        List<String> Tutorial_on_Apps = new ArrayList<String>();
        Tutorial_on_Apps.add("Farm pond on Demand Scheme");
        Tutorial_on_Apps.add("Plantyzers");

        List<String> Tutorial_on_Website = new ArrayList<String>();
        Tutorial_on_Website.add("Websites");

        List<String> Tutorial_on_Hardware = new ArrayList<String>();
        Tutorial_on_Hardware.add("hardwares");
        listDataChild.put(listDataHeader.get(0), Tutorial_on_Apps); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Tutorial_on_Website);
        listDataChild.put(listDataHeader.get(2), Tutorial_on_Hardware);


        expListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(VideoList.this,Videos.class);

                position = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

                if(position == "Farm pond on Demand Scheme"){
                    intent.putExtra("url","https://www.youtube.com/embed/QQlymbTxEP8");
                }else if(position == "Plantyzers"){
                    intent.putExtra("url","https://www.youtube.com/embed/4xx3ScDIbG0");
                }
                startActivity(intent);
                return false;
            }
        });
    }
}