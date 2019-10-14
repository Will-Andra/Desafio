package com.e.dhfood.Adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.dhfood.Interface.RecyclerOnClick;
import com.e.dhfood.Interface.RecyclerOnViewClick;
import com.e.dhfood.R;
import com.e.dhfood.model.ComidaTwo;

import java.util.List;

public class ComidaAdapterTwo extends RecyclerView.Adapter<ComidaAdapterTwo.ViewHolder> {

    private List<ComidaTwo> listaComidaTw;
    private RecyclerOnViewClick listenerTw;

    public ComidaAdapterTwo(List<ComidaTwo> listaComidaTw, RecyclerOnViewClick listenerTw) {
        this.listaComidaTw = listaComidaTw;
        this.listenerTw = listenerTw;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclertwo,viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int posicao) {

        final ComidaTwo comidaTwo = listaComidaTw.get(posicao);
        viewHolder.onBind(comidaTwo);

        viewHolder.itemView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerTw.onClick(comidaTwo);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return listaComidaTw.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViews;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViews = itemView.findViewById(R.id.imgMini);
        }

        public void onBind(ComidaTwo comidaTwo) {

            Drawable drawable = itemView.getResources().getDrawable(comidaTwo.getImgViewTwo());

            imageViews.setImageDrawable(drawable);


        }
    }
}
