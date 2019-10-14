package com.e.dhfood.Adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.dhfood.model.Comidas;
import com.e.dhfood.R;
import com.e.dhfood.Interface.RecyclerOnClick;

import java.util.List;

public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ViewHolder> {

    private List<Comidas> listaComidas;
    private RecyclerOnClick listener;


    public ComidaAdapter(List<Comidas> listaComidas, RecyclerOnClick listener) {
        this.listaComidas = listaComidas;
        this.listener = listener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int posicao) {
        final Comidas comidas = listaComidas.get(posicao);
        viewHolder.onBind(comidas);

        viewHolder.itemView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(comidas);
            }
        }));


    }

    @Override
    public int getItemCount() {
        return listaComidas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNome;
        private TextView txtAvenida;
        private TextView txtHorario;
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNome = itemView.findViewById(R.id.txtNomeRestRCV);
            txtAvenida = itemView.findViewById(R.id.txtAvenidaRCV);
            txtHorario= itemView.findViewById(R.id.txtFechaRCVs);
            imageView = itemView.findViewById(R.id.imgViewRCV);
        }

        public void onBind(Comidas comidas){
            txtNome.setText(comidas.getTxNomeRest());
            txtAvenida.setText(comidas.getTxtAvenidaRest());
            txtHorario.setText(comidas.getTxtHorarioRest());
            Drawable drawable = itemView.getResources().getDrawable(comidas.getImgViewLocal());

            imageView.setImageDrawable(drawable);

        }
    }
}
