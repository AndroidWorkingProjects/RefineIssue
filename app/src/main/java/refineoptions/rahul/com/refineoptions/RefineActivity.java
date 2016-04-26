package refineoptions.rahul.com.refineoptions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class RefineActivity extends AppCompatActivity {

    Button button;
    LinearLayout back;
    ListView refineList;
    ArrayList filterNamesList;
    ArrayList filterObject;
    public LinkedHashMap filterMap=new LinkedHashMap<String,ArrayList<RefineSubListDto>>();
    RefineAdapter refineAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);
        button= (Button) findViewById(R.id.button6);
        back= (LinearLayout) findViewById(R.id.refine_back);
        refineList = (ListView) findViewById(R.id.refine_list);

        filterNamesList = new ArrayList();


        refineAdapter = new RefineAdapter(this,R.layout.refine_adapter_listview,filterNamesList,filterMap);
        refineList.setAdapter(refineAdapter);
        Utility.setListViewHeightBasedOnChildren(refineList);
        dummyData();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void dummyData(){
        filterNamesList.add("brands");filterNamesList.add("colors");filterNamesList.add("OS");

        filterObject=new ArrayList();
        RefineSubListDto dto;
        for (int i=0;i<5;i++){
            dto=new RefineSubListDto();
            dto.setFilterName("Ability");
            dto.setFilterCount("10");
            filterObject.add(dto);
        }
        filterMap.put(filterNamesList.get(0),filterObject);
        filterMap.put(filterNamesList.get(1),filterObject);
        filterMap.put(filterNamesList.get(2),filterObject);
        refineAdapter.notifyDataSetChanged();
//        Utility.setListViewHeightBasedOnChildren(refineList);
    }




    public void refineback()
    {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
