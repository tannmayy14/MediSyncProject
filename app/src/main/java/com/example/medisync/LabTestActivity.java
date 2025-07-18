package com.example.medisync;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Package 1: Full Body Checkup","","","","999"},
                    {"Package 2: Blood Glucose Fasting","","","","299"},
                    {"Package 3: COVID-19 Antibody","","","","899"},
                    {"Package 4: Thyroid Check","","","","499"},
                    {"Package 5: Immunity Check","","","","699"},
            };

    private String[] package_details =
            {
                    "Blood Glucose Fasting\n"+
                            "Complete Hemogram\n"+
                            "Iron Studies\n"+
                            "Lipid Profile\n"+
                            "Liver Function Test",
                    "Blood Glucose Fasting",
                    "COVID-19 Antibody",
                    "Thyroid Profile",
                    "Complete Hemogram\n"+
                            "CRP\n"+
                            "Kidney Fucntion test\n"+
                            "Vitamin D Total Hydroxy\n"+
                            "Liver Function Test\n"+
                            "Lipid Profile"
            };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoCart,btnBack;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoCart = findViewById(R.id.buttonLTGoToCart);
        btnBack = findViewById(R.id.buttonLTBack);
        listView = findViewById(R.id.listViewLT);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("Line1",packages[i][0]);
            item.put("Line2",packages[i][1]);
            item.put("Line3",packages[i][2]);
            item.put("Line4",packages[i][3]);
            item.put("Line5","Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

        btnGoCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });
    }
}