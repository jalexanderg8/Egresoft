package com.example.foxconntech.egresoft.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.vo.Evento_Vo;

import java.util.ArrayList;

/**
 * Created by JULIAN HENAO on 20/08/2017.
 */

public class Adaptador_Eventos extends RecyclerView.Adapter<Adaptador_Eventos.ViewHolderEventos>implements View.OnClickListener {


ArrayList<Evento_Vo> ListaEventos;
private View.OnClickListener listener;

    public Adaptador_Eventos(ArrayList<Evento_Vo> listaEventos) {
        ListaEventos = listaEventos;
    }

    @Override
    public ViewHolderEventos onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_eventos,null,false);

        view.setOnClickListener(this);
        return new ViewHolderEventos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderEventos holder, int position) {

        holder.nombre.setText(ListaEventos.get(position).getNombre());
        holder.direccion.setText(ListaEventos.get(position).getDireccion());
        holder.fecha.setText(ListaEventos.get(position).getFecha());
        holder.foto.setImageResource(ListaEventos.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return ListaEventos.size();
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



    public class ViewHolderEventos extends RecyclerView.ViewHolder {

        TextView nombre,fecha,direccion;
        ImageView foto;

        public ViewHolderEventos(View itemView) {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.nombre_Evento);
            fecha=(TextView)itemView.findViewById(R.id.fecha_Evento);
            direccion=(TextView)itemView.findViewById(R.id.direccion_Evento);
            foto=(ImageView)itemView.findViewById(R.id.FotoEvento);
        }
    }
}
