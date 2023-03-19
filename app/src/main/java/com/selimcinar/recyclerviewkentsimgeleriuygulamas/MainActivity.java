package com.selimcinar.recyclerviewkentsimgeleriuygulamas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.selimcinar.recyclerviewkentsimgeleriuygulamas.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    //Global kapsamlar
    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            binding = ActivityMainBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);
            //Listeyi initilaze etme yükleme
            landmarkArrayList=new ArrayList<>();

            //Classta tutulan datalar veriler.
            Landmark anitkabir=new Landmark("Anıtkabir","Türkiye",R.drawable.anitkabir);
            Landmark saatkulesi=new Landmark("Saat kulesi","Türkiye",R.drawable.izmir_saat_kulesi);
            Landmark kizkulesi=new Landmark("Kız kulesi","Türkiye",R.drawable.kiz_kulesi);
            Landmark SelimiyeCami=new Landmark("Selimiye Cami","Türkiye",R.drawable.selimiye_camii);
            //Listeye classta tutulan verileri ekleme
            landmarkArrayList.add(anitkabir);
            landmarkArrayList.add(saatkulesi);
            landmarkArrayList.add(kizkulesi);
            landmarkArrayList.add(SelimiyeCami);

            /*
            //Adapter : Layoutu ve veriyi birbirine bağlar.
            //Listview

            //mapping : Bir yapıyı başka bir yapıya döndürür classı yazıya dönüştürme gibi örnek
            ArrayAdapter arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,landmarkArrayList.stream().map(landmark -> landmark.name ).collect(Collectors.toList()));
            binding.listView.setAdapter(arrayAdapter);

            //Listviewde herhangi biryere tıklanınca ne olsunu =   binding.listView.setOnClickListener();
            //Listview içerisinde iteme nesneye tıklanınca neolsun  binding.listView.setOnItemClickListener();
            //Listview içerisinde uzun tıklanınca ne olsun binding.listView.setOnLongClickListener();
            binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Tıklanan liste elemanınını toast mesajı olarak gösterme
                    Toast.makeText(MainActivity.this, landmarkArrayList.get(position).name, Toast.LENGTH_SHORT).show();
                    //Tıklanan liste elemanının adını diğer aktiviteye veri olarak yollama
                    Intent intent =new Intent(MainActivity.this,DetailsActivity.class);
                    intent.putExtra("landmark",landmarkArrayList.get(position));
                    startActivity(intent);
                }
            });
             */

        /*Recycler View Kent simgeleri uygulaması */
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);
        //Liner layout yada grid layout çeşitleri var görünümde xmli grid layout yaparsan new GridLayoutManager(this) yazmalısın
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }


