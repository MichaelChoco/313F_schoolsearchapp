package hk.edu.hkmu.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import org.json.*;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Result extends AppCompatActivity {
    private String TAG = "Result";
    private ListView listView;
    private Button backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        listView = (ListView)findViewById(R.id.listview);
        backbutton = findViewById(R.id.back_button);
        backbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        SchoolInfo.eninfoList.clear();
        SchoolInfo.chinfoList.clear();
        SchoolInfo.infoList.clear();
        JsonHandlerThread jsonHandlerThread = new JsonHandlerThread();

        jsonHandlerThread.start();
        try {
            jsonHandlerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent = getIntent();
        String searchstr = intent.getStringExtra(InputName.EXTRA_MESSAGE);

        if(Locale.getDefault().getLanguage().equals(new Locale("en").getLanguage())) {
            searching.ensearchname(searchstr);
            SimpleAdapter adapter = new SimpleAdapter(
                    this,
                    searching.searchlist,
                    R.layout.list_view_layout,
                    new String[]{SchoolInfo.enname, SchoolInfo.entel, SchoolInfo.enaddress},
                    new int[]{R.id.name, R.id.tele, R.id.address}
            );
            listView.setAdapter(adapter);
        }else if(Locale.getDefault().getLanguage().equals(new Locale("zh").getLanguage())){
            searching.chsearchname(searchstr);
            SimpleAdapter adapter = new SimpleAdapter(
                    this,
                    searching.searchlist,
                    R.layout.list_view_layout,
                    new String[]{SchoolInfo.chname, SchoolInfo.chtel, SchoolInfo.chaddress},
                    new int[]{R.id.name,R.id.tele,R.id.address}
            );
            listView.setAdapter(adapter);
        }

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?>parent, View view, int position, long id){
                        HashMap<String,String> contact = searching.searchlist.get(position);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Result.this);

                        LayoutInflater inflater = LayoutInflater.from(view.getContext());
                        View skuDetail = inflater.inflate(R.layout.sku_details, null);
                        String locButton = "";
                        builder.setView(skuDetail);

                        TextView resultSkuName = skuDetail.findViewById(R.id.name);
                        TextView resultAddress = skuDetail.findViewById(R.id.address);
                        TextView resultTel = skuDetail.findViewById(R.id.tele);
                        TextView resultWeb = skuDetail.findViewById(R.id.web);
                        TextView resultCat = skuDetail.findViewById(R.id.skuCat);
                        TextView resultGender = skuDetail.findViewById(R.id.skuGender);
                        TextView resultSession = skuDetail.findViewById(R.id.skuSession);
                        TextView resultDISTRICT = skuDetail.findViewById(R.id.skuDistrict);
                        TextView resultFinance = skuDetail.findViewById(R.id.skuFinance);
                        TextView resultLevel = skuDetail.findViewById(R.id.skuLevel);
                        TextView resultFax = skuDetail.findViewById(R.id.skuFax);
                        TextView resultReligion = skuDetail.findViewById(R.id.skuReligion);
                        
                        ArrayList<JSONObject> result=Getdetail.getDetail(contact.get(SchoolInfo.schoolid),SchoolInfo.infoList);

                        if(Locale.getDefault().getLanguage().equals(new Locale("en").getLanguage())) {
                            resultSkuName.setText(contact.get(SchoolInfo.enname));
                            resultAddress.setText(contact.get(SchoolInfo.enaddress) + "\n");
                            resultTel.setText("Telephone: " + contact.get(SchoolInfo.entel));
                            resultWeb.setText(Html.fromHtml("Website: " + "<a href='" + contact.get(SchoolInfo.enweb) +
                                    "'> " + contact.get(SchoolInfo.enweb) + " </a>"));
                            resultCat.setText("CATEGORY:"+engGetdetail.getCategory(result));
                            resultGender.setText("STUDENTS GENDER: "+engGetdetail.getGender(result));
                            resultSession.setText("SESSION: "+engGetdetail.getSession(result));
                            resultDISTRICT.setText("DISTRICT: "+engGetdetail.getDistrict(result));
                            resultFinance.setText("FINANCE TYPE: "+engGetdetail.getFinance(result));
                            resultLevel.setText("SCHOOL LEVEL: "+engGetdetail.getLevel(result));
                            resultFax.setText("FAX NUMBER: "+engGetdetail.getFax(result));
                            resultReligion.setText("RELIGION: "+engGetdetail.getReligion(result));

                            locButton = "Show in map";
                        }else if(Locale.getDefault().getLanguage().equals(new Locale("zh").getLanguage())){
                            resultSkuName.setText(contact.get(SchoolInfo.chname));
                            resultAddress.setText(contact.get(SchoolInfo.chaddress) + "\n");
                            resultTel.setText("聯絡電話: " + contact.get(SchoolInfo.chtel));
                            resultWeb.setText(Html.fromHtml("網站: " + "<a href='" + contact.get(SchoolInfo.chweb) +
                                    "'> " + contact.get(SchoolInfo.chweb) + " </a>"));
                            resultSkuName.setText(contact.get(SchoolInfo.enname));
                            resultAddress.setText(contact.get(SchoolInfo.enaddress) + "\n");
                            resultTel.setText("電話: " + contact.get(SchoolInfo.entel));
                            resultWeb.setText(Html.fromHtml("Website: " + "<a href='" + contact.get(SchoolInfo.enweb) +
                                    "'> " + contact.get(SchoolInfo.enweb) + " </a>"));
                            resultCat.setText("類型 :"+zhGetdetail.getCategory(result));
                            resultGender.setText("就讀學生性別: "+zhGetdetail.getGender(result));
                            resultSession.setText("s: "+zhGetdetail.getSession(result));
                            resultDISTRICT.setText("分區: "+zhGetdetail.getDistrict(result));
                            resultFinance.setText("資助種類: "+zhGetdetail.getFinance(result));
                            resultLevel.setText("學校類型: "+zhGetdetail.getLevel(result));
                            resultFax.setText("傳真號碼: "+zhGetdetail.getFax(result));
                            resultReligion.setText("宗教: "+zhGetdetail.getReligion(result));
                            locButton = "顯示地圖";
                        }

                        builder.setNegativeButton(locButton, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query="+ contact.get(SchoolInfo.enname) + " " + contact.get(SchoolInfo.endistrict));
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                                    startActivity(mapIntent);
                                }
                            }
                        });
                        /*builder.setPositiveButton(detailButton,new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                setContentView(R.layout.sku_details);
                                TextView err = (TextView)findViewById(R.id.name);
                                err.setText(SchoolInfo.enname);
                            }
                        });*/

                        AlertDialog alertDialog = builder.create();

                        alertDialog.show();
                    }
                }
        );
    }
}
