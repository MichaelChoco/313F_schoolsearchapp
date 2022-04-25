package hk.edu.hkmu.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class searching extends AppCompatActivity {

    public static ArrayList<HashMap<String, String>> searchlist = new ArrayList<>();

    static void ensearchname(String searchstr){
        searchlist.clear();
        Object[] strarray = SchoolInfo.eninfoList.get(0).keySet().toArray();
        for(int i =0; i< SchoolInfo.eninfoList.size();i++){
            if(SchoolInfo.eninfoList.get(i).get("English Name").toLowerCase().contains(searchstr.toLowerCase()) || SchoolInfo.chinfoList.get(i).get("名稱").contains(searchstr)){  //check if text match any school name
                HashMap<String, String> search = new HashMap<>();
                for(int j=0; j<SchoolInfo.eninfoList.get(0).keySet().toArray().length;j++){
                    search.put((String)(strarray[j]),SchoolInfo.eninfoList.get(i).get(SchoolInfo.eninfoList.get(i).keySet().toArray()[j])); //using another arraylist to store the filtered result
                }
                addarray(search);
            }
        }
    }

    static void chsearchname(String searchstr){
        searchlist.clear();
        Object[] strarray = SchoolInfo.chinfoList.get(0).keySet().toArray();
        for(int i =0; i< SchoolInfo.chinfoList.size();i++){
            if(SchoolInfo.chinfoList.get(i).get("名稱").contains(searchstr) || SchoolInfo.eninfoList.get(i).get("English Name").toLowerCase().contains(searchstr.toLowerCase())){  //check if text match any school name
                HashMap<String, String> search = new HashMap<>();
                for(int j=0; j<SchoolInfo.chinfoList.get(0).keySet().toArray().length;j++){
                    search.put((String)(strarray[j]),SchoolInfo.chinfoList.get(i).get(SchoolInfo.chinfoList.get(i).keySet().toArray()[j])); //using another arraylist to store the filtered result
                }
                addarray(search);
            }
        }
    }

    static void ensearchcrit(ArrayList<String> list) {
        searchlist.clear();
        Object[] strarray = SchoolInfo.eninfoList.get(0).keySet().toArray();
        for (int i = 0; i < SchoolInfo.eninfoList.size(); i++) {
            if ((list.get(0).equals("ANY") || SchoolInfo.eninfoList.get(i).get("Category").toLowerCase().equals(list.get(0).toLowerCase()))
                    && (list.get(1).equals("ANY") || SchoolInfo.eninfoList.get(i).get("Students Gender").toLowerCase().equals(list.get(1).toLowerCase()))
                    && (list.get(2).equals("ANY") || SchoolInfo.eninfoList.get(i).get("Session").toLowerCase().equals(list.get(2).toLowerCase()))
                    && (list.get(3).equals("ANY") || SchoolInfo.eninfoList.get(i).get("District").toLowerCase().equals(list.get(3).toLowerCase()))
                    && (list.get(4).equals("ANY") || SchoolInfo.eninfoList.get(i).get("Finance Type").toLowerCase().equals(list.get(4).toLowerCase()))
                    && (list.get(5).equals("ANY") || SchoolInfo.eninfoList.get(i).get("School Level").toLowerCase().equals(list.get(5).toLowerCase()))
                    && (list.get(6).equals("ANY") || SchoolInfo.eninfoList.get(i).get("Religion").toLowerCase().equals(list.get(6).toLowerCase()))
            ){  //check if text match any school name
                HashMap<String, String> search = new HashMap<>();
                for (int j = 0; j < SchoolInfo.eninfoList.get(0).keySet().toArray().length; j++) {
                    search.put((String) (strarray[j]), SchoolInfo.eninfoList.get(i).get(SchoolInfo.eninfoList.get(i).keySet().toArray()[j])); //using another arraylist to store the filtered result
                }
                addarray(search);
            }
        }
    }

    static void chsearchcrit(ArrayList<String> list){
        searchlist.clear();
        Object[] strarray = SchoolInfo.chinfoList.get(0).keySet().toArray();
        for (int i = 0; i < SchoolInfo.chinfoList.size(); i++) {
            if ((list.get(0).equals("任何") || SchoolInfo.chinfoList.get(i).get("類別").equals(list.get(0)))
                    && (list.get(1).equals("任何") || SchoolInfo.chinfoList.get(i).get("就讀學生性別").equals(list.get(1)))
                    && (list.get(2).equals("任何") || SchoolInfo.chinfoList.get(i).get("學校授課時間").equals(list.get(2)))
                    && (list.get(3).equals("任何") || SchoolInfo.chinfoList.get(i).get("分區").equals(list.get(3)))
                    && (list.get(4).equals("任何") || SchoolInfo.chinfoList.get(i).get("資助種類").equals(list.get(4)))
                    && (list.get(5).equals("任何") || SchoolInfo.chinfoList.get(i).get("學校類型").equals(list.get(5)))
                    && (list.get(6).equals("任何") || SchoolInfo.chinfoList.get(i).get("宗教").equals(list.get(6)))
            ){  //check if text match any school name
                HashMap<String, String> search = new HashMap<>();
                for (int j = 0; j < SchoolInfo.chinfoList.get(0).keySet().toArray().length; j++) {
                    search.put((String) (strarray[j]), SchoolInfo.chinfoList.get(i).get(SchoolInfo.chinfoList.get(i).keySet().toArray()[j])); //using another arraylist to store the filtered result
                }
                addarray(search);
            }
        }
    }

    private static void addarray(HashMap hm){
        searchlist.add(hm);
    }
}