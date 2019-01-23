package example.com.elearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Documents extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    String position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);

        expListView = findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }


    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Applying for Documents");

        // Adding child data
        List<String> Applying_for_documents = new ArrayList<String>();
        Applying_for_documents.add("Applying for Caste Certificate");
        Applying_for_documents.add("Applying for Caste Validity");
        Applying_for_documents.add("Applying for Birth Certificate");
        Applying_for_documents.add("Applying for Aadhar Card");

        listDataChild.put(listDataHeader.get(0), Applying_for_documents); // Header, Child data

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Intent intent = new Intent(Documents.this,Videos.class);
                position = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

                if(position == "Applying for Caste Certificate"){
                    intent.putExtra("url","https://www.youtube.com/embed/bj6AJSxEqCo?start=21");
                }else if(position == "Applying for Caste Validity"){
                    intent.putExtra("url","https://www.youtube.com/embed/ZWC8F-e5Fgg");
                }else if (position == "Applying for Birth Certificate"){
                    intent.putExtra("url","https://www.youtube.com/embed/4QiN8eTOsOc?start=24");
                }else if(position == "Applying for Aadhar Card") {
                    intent.putExtra("url","https://www.youtube.com/embed/H_Q0QoA5zYk?start=65");
                }
                startActivity(intent);
                return false;
            }
        });
    }}
