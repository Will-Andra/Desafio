package com.e.dhfood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.e.dhfood.Adapter.ComidaAdapter;
import com.e.dhfood.Interface.RecyclerOnClick;
import com.e.dhfood.R;
import com.e.dhfood.model.Comidas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerOnClick {

    private RecyclerView recyclerView;
    private ComidaAdapter adapter;
    private List<Comidas> listaComidas = new ArrayList<>();

    public static final String COMIDAS_KEY = "Comidas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewComidas);
        adapter = new ComidaAdapter(retornarListaComidas(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Comidas> retornarListaComidas(){
        listaComidas.add(new Comidas("Tony Romas","Aberto todo dia","Fecha as 22hs", R.drawable.tony_romas));
        listaComidas.add(new Comidas("Aoyama Moema","Aberto todo dia","Fecha as 20hs", R.drawable.aoyama_moema));
        listaComidas.add(new Comidas("Outback - Moema","Segunda a Sexta","Fecha as 19hs", R.drawable.outback_moema));

        return listaComidas;

    }


    @Override
    public void onClick(Comidas comidas) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(COMIDAS_KEY,comidas);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
