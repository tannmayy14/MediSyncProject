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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Thomas Shelby", "Hospital Address : Bandra","Exp : 8yrs","Mobile : 9969890724","600"},
                    {"Doctor Name : Bruce Wayne", "Hospital Address : Govandi","Exp : 15yrs","Mobile : 9824746230","900"},
                    {"Doctor Name : Martha Nielsen", "Hospital Address : Churchgate","Exp : 7yrs","Mobile : 9276265369","800"},
                    {"Doctor Name : Jim Halpert", "Hospital Address : Andheri","Exp : 6yrs","Mobile : 9826764390","750"},
                    {"Doctor Name : Vikram Rathore", "Hospital Address : Borivali","Exp : 12yrs","Mobile : 9120365249","900"},
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name : John Doe", "Hospital Address : Downtown Medical Center","Exp : 12yrs","Mobile : 9845551234","750"},
                    {"Doctor Name : Sarah Johnson", "Hospital Address : Northside Hospital", "Exp : 10yrs", "Mobile : 5552345678","650"},
                    {"Doctor Name : Michael Smith", "Hospital Address : Central Clinic", "Exp : 15yrs", "Mobile : 5553456789","450"},
                    {"Doctor Name : Emily Davis", "Hospital Address : Westside Medical", "Exp : 7yrs", "Mobile : 5554567890","980"},
                    {"Doctor Name : David Lee", "Hospital Address : East End Healthcare", "Exp : 9yrs", "Mobile : 5555678901","775"},
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Jessica Brown", "Hospital Address : South Medical Center", "Exp : 11yrs", "Mobile : 5556789012","700"},
                    {"Doctor Name : Robert Jackson", "Hospital Address : Riverside Clinic", "Exp : 13yrs", "Mobile : 5557890123","450"},
                    {"Doctor Name : Olivia Martinez", "Hospital Address : Lakeside Healthcare", "Exp : 14yrs", "Mobile : 5558901234","800"},
                    {"Doctor Name : Ethan Wilson", "Hospital Address : Parkview Medical", "Exp : 6yrs", "Mobile : 5559012345","1000"},
                    {"Doctor Name : Ava Anderson", "Hospital Address : Mountainview Clinic", "Exp : 8yrs", "Mobile : 5550123456","800"},
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Benjamin Garcia", "Hospital Address : Hilltop General", "Exp : 10yrs", "Mobile : 5556789012","500"},
                    {"Doctor Name : Sophia Rodriguez", "Hospital Address : Lakeshore Medical Center", "Exp : 8yrs", "Mobile : 5557890123","600"},
                    {"Doctor Name : Liam Martinez", "Hospital Address : Sunset Clinic", "Exp : 12yrs", "Mobile : 5558901234","900"},
                    {"Doctor Name : Emma Smith", "Hospital Address : Valleyview Healthcare", "Exp : 9yrs", "Mobile : 5559012345","700"},
                    {"Doctor Name : Noah Davis", "Hospital Address : Oceanfront Hospital", "Exp : 11yrs", "Mobile : 5550123456","450"},
            };

    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Isabella Johnson", "Hospital Address : Riverside Medical Center", "Exp : 7yrs", "Mobile : 5551234567","600"},
                    {"Doctor Name : Lucas Wilson", "Hospital Address : Mountainview Clinic", "Exp : 14yrs", "Mobile : 5552345678","800"},
                    {"Doctor Name : Mia Brown", "Hospital Address : Hillside General", "Exp : 13yrs", "Mobile : 5553456789","6969"},
                    {"Doctor Name : Ethan Lee", "Hospital Address : Seaside Healthcare", "Exp : 15yrs", "Mobile : 5554567890","500"},
                    {"Doctor Name : Ava Jackson", "Hospital Address : Lakeside Clinic", "Exp : 6yrs", "Mobile : 5555678901","900"},
            };
    TextView tv;
    Button btn;
    String[][] doctor_details ={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
                }
            });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("Line1",doctor_details[i][0]);
            item.put("Line2",doctor_details[i][1]);
            item.put("Line3",doctor_details[i][2]);
            item.put("Line4",doctor_details[i][3]);
            item.put("Line5","Cons Fee:" +doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,int i,long l){
                Intent it =new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}