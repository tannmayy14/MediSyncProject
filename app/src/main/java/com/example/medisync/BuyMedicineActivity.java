package com.example.medisync;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Uprise-03 Capsule","","","","50"},
                    {"Healthwit 200mcg Capsule","","","","305"},
                    {"Vitamin B Capsules","","","","530"},
                    {"Dolo 650 Tablet","","","","30"},
                    {"Strepsils","","","","20"},
            };

    private String[] package_details={
      "Building and keeping the bones & teeth strong\n" +
            "Reducing Fatigue/Stress and muscular pain\n"+
            "Boosting immunity and increasing resistance against infection",
      "Chromium is an essential trace mineral that plays an important role in helping insulin regulation\n"+
      "Provides Relief from vitamin B deficiencies\n"+
            "Helps in formation of red blood cells\n"+
            "Maintains healthy nervous system",
      "It promotes health as well as skin benefit.\n"+
            "It helps reduce skin blemish and pigmentation\n"+
            "It acts as safeguard to the skin",
      "DOLO 650 tablet helps relieve pain and fever by blocking the release of certain chemical messengers\n"+
      "Helps relieve fever and bring down a high temperature\n"+
            "Suitable for people with a heart condition",
      "Relieves the symptoms of bacterial throat infection and soothes recovery process\n"+
            "Provides a warm and comforting feeling during sore throat",
      "Reduces the risk of calcium deficiency,rickets and osteoporosis\n"+
            "Promotes mobility and flexibility of joints",
      "Helps to reduce iron deficiency due to chronic blood loss"
    };

    HashMap<String,String> item;
    SimpleAdapter sa;
    ArrayList list;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i< packages.length;i++){
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
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}