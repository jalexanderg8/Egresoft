package com.example.foxconntech.egresoft.Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.vo.Estudio_Vo;

import java.util.ArrayList;


public class Adaptador_P_Academico extends RecyclerView.Adapter<Adaptador_P_Academico.ViewHolderP_Academico>implements View.OnClickListener{

ArrayList<Estudio_Vo> Lista_Estudios;

    View.OnClickListener listener;

    public Adaptador_P_Academico(ArrayList<Estudio_Vo> lista_Estudios) {
        Lista_Estudios = lista_Estudios;
    }

    @Override
    public ViewHolderP_Academico onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_p_academico,null,false);

        view.setOnClickListener(this);

        return new ViewHolderP_Academico(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderP_Academico holder, int position) {

        holder.nombre.setText(Lista_Estudios.get(position).getNombre());
        holder.direccion.setText(Lista_Estudios.get(position).getDireccion());
        holder.horarios.setText(Lista_Estudios.get(position).getHorarios());

    }

    @Override
    public int getItemCount() {
        return Lista_Estudios.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
this.listener=listener;
    }

    @Override
    public void onClick(View view) {

        if (listener!=null){
listener.onClick(view);
        }
    }

    public class ViewHolderP_Academico extends RecyclerView.ViewHolder {
        TextView nombre,horarios,direccion;
       // ImageView imagen;

        public ViewHolderP_Academico(View itemView) {
            super(itemView);

            nombre=(TextView)itemView.findViewById(R.id.nombre_Estudio);
            horarios=(TextView)itemView.findViewById(R.id.horarios_Estudio);
            direccion=(TextView)itemView.findViewById(R.id.direccion_Estudio);
           // imagen=(ImageView)itemView.findViewById(R.id.Foto_P_Academico);
        }
    }
}
