package com.example.btktra;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<MenuItems> items = new ArrayList<>();
    MenuAdapter menuAdapter;
    Boolean kt=false;
    int j=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        items.add(new MenuItems("Sapa", "Du lich Sapa", "70$/ng", R.drawable.img_sapa)) ;
        items.add(new MenuItems("Vịnh Hạ Long", "Du lịch Vịnh Hạ Long", "25$/ng", R.drawable.img_halong)) ;
        items.add(new MenuItems("Campuchia", "Tham quan Campuchia", "50$/ng", R.drawable.img_camp)) ;
        items.add(new MenuItems("Vũng tàu", "Khu du lịch Vũng Tàu", "30$/ng", R.drawable.img_halong)) ;
        items.add(new MenuItems("Suối Tiên", "Khu du lịch suối tiên", "35$/ng", R.drawable.img_suoitien)) ;
        menuAdapter = new MenuAdapter(MainActivity.this,items);
        listView.setAdapter(menuAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,Detail.class);
                intent.putExtra("ten",items.get(i).getTen());
                if (kt!=true)
                    startActivity(intent);
                kt=false;
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                kt=true;
                Xacnhanxoa(i);
                return false;
            }
        });
    }
    public void Xacnhanxoa(final int pos){
        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(MainActivity.this);
        alertDiaLog.setTitle("Thong bao");
        alertDiaLog.setIcon(R.mipmap.ic_launcher);
        alertDiaLog.setMessage("Bạn có muốn sao không ?");
        alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                items.remove(pos);
                menuAdapter.notifyDataSetChanged();
            }
        });
        alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDiaLog.show();

    }
}