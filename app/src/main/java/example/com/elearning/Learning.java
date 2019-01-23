package example.com.elearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Learning extends AppCompatActivity {


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
        listDataHeader.add("K.G.");
        listDataHeader.add("Std. I");
        listDataHeader.add("Std. II");
        listDataHeader.add("Std. III");
        listDataHeader.add("Std. IV");
        listDataHeader.add("Std. V");

        // Adding child data

        List<String> KG = new ArrayList<String>();
        KG.add("ABCD");
        KG.add("Basic Maths");

        List<String> Std_I = new ArrayList<String>();
        Std_I.add("Maths");

        List<String> Std_II = new ArrayList<String>();
        Std_II.add("English");

        List<String> Std_III = new ArrayList<String>();
        Std_III.add("Marathi");
        Std_III.add("Parts of Body");

        List<String> Std_IV = new ArrayList<String>();
        Std_IV.add("History");
        Std_IV.add("Geography-Solar System");

        List<String> Std_V = new ArrayList<String>();
        Std_V.add("Geography");


        listDataChild.put(listDataHeader.get(0),KG);
        listDataChild.put(listDataHeader.get(1), Std_I); // Header, Child data
        listDataChild.put(listDataHeader.get(2), Std_II);
        listDataChild.put(listDataHeader.get(3), Std_III);
        listDataChild.put(listDataHeader.get(4), Std_IV);
        listDataChild.put(listDataHeader.get(5), Std_V);


        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(Learning.this,Videos.class);
                position = listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);

                if (position == "ABCD"){
                    intent.putExtra("url","https://www.youtube.com/embed/hq3yfQnllfQ");
                }else if(position == "Maths"){
                    intent.putExtra("url","https://www.youtube.com/embed/JUKU0zJolig");
                }else if (position == "English"){
                    intent.putExtra("url","https://www.youtube.com/embed/QD8WgUz3uUU");
                }else if (position == "Marathi"){
                    intent.putExtra("url","https://www.youtube.com/embed/kBhq5nbK_OM");
                }else if (position == "History"){
                    intent.putExtra("url","https://www.youtube.com/embed/OjfQlJLyAfA");
                }else if (position == "Geography"){
                    intent.putExtra("url","https://www.youtube.com/embed/qbxGzGBtp40");
                }else if(position == "Parts of Body"){
                    intent.putExtra("url","https://www.youtube.com/embed/rhd7YsYZErg");
                }else if(position == "Geography-Solar System"){
                    intent.putExtra("url","https://www.youtube.com/embed/nBbTLBNOv3M");
                }else if(position == "Basic Maths"){
                    intent.putExtra("url","https://www.youtube.com/embed/N0_TWQTrJ-k&t=88s");
                }
                startActivity(intent);
                return false;
            }
        });
    }
}
