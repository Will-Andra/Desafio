package com.e.dhfood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.e.dhfood.Adapter.ComidaAdapter;
import com.e.dhfood.Adapter.ComidaAdapterTwo;
import com.e.dhfood.Interface.RecyclerOnClick;
import com.e.dhfood.Interface.RecyclerOnViewClick;
import com.e.dhfood.R;
import com.e.dhfood.model.ComidaTwo;
import com.e.dhfood.model.Comidas;

import java.util.ArrayList;
import java.util.List;

import static com.e.dhfood.Activity.MainActivity.COMIDAS_KEY;

public class Main2Activity extends AppCompatActivity implements RecyclerOnViewClick {



    private RecyclerView recyclerViews;
    private GridLayoutManager gridLayoutManager;
    private ComidaAdapterTwo adapters;
    private List<ComidaTwo> listaComidasTw = new ArrayList<>();
    private ImageView imageView;
    private TextView txtNomme;

    public static final String FOOD_KEY = "Food";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerViews = findViewById(R.id.recyclerTwo);
        adapters = new ComidaAdapterTwo(retornarComidasTwo(), this);
        recyclerViews.setAdapter(adapters);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerViews.setLayoutManager(gridLayoutManager);
        imageView = findViewById(R.id.imgMain2);
        txtNomme = findViewById(R.id.txtNomeMain2);


        //recyclerViews.setLayoutManager(new LinearLayoutManager(this));


        if (getIntent() != null && getIntent().getExtras() != null){

            Comidas comidas = getIntent().getExtras().getParcelable(COMIDAS_KEY);

            Drawable drawable = getResources().getDrawable(comidas.getImgViewLocal());
            imageView.setImageDrawable(drawable);
            txtNomme.setText(comidas.getTxNomeRest());

        }



    }

    public List<ComidaTwo> retornarComidasTwo() {
        listaComidasTw.add(new ComidaTwo(R.drawable.aoyama_moema));
        listaComidasTw.add(new ComidaTwo(R.drawable.aoyama_moema));
        listaComidasTw.add(new ComidaTwo(R.drawable.aoyama_moema));
        listaComidasTw.add(new ComidaTwo(R.drawable.aoyama_moema));
        listaComidasTw.add(new ComidaTwo(R.drawable.aoyama_moema));
        listaComidasTw.add(new ComidaTwo(R.drawable.aoyama_moema));




        return listaComidasTw;
    }

    @Override
    public void onClick(ComidaTwo comidastw) {
        Intent intent = new Intent(Main2Activity.this,DetalheComidaActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(FOOD_KEY,comidastw);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}