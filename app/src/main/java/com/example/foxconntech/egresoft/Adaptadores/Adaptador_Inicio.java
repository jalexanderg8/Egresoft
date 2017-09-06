package com.example.foxconntech.egresoft.Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.vo.InicioVo;

import java.util.ArrayList;

/**
 * Created by lenovo on 6/09/2017.
 */

public class Adaptador_Inicio extends RecyclerView.Adapter<Adaptador_Inicio.ViewHolder> implements View.OnClickListener
{

    ArrayList<InicioVo> arrayList;

    public Adaptador_Inicio(ArrayList<InicioVo> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inicio,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.texto.setText(arrayList.get(position).getInfo());
        holder.imagen.setImageResource(arrayList.get(position).getImagen());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView texto;
        ImageView imagen;

        public ViewHolder(View itemView) {
            super(itemView);
            texto = (TextView) itemView.findViewById(R.id.texto);
            imagen = (ImageView) itemView.findViewById(R.id.idicono);
        }
    }
}