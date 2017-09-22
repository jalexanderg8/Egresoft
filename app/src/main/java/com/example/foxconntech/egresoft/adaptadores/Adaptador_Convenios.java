package com.example.foxconntech.egresoft.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.vo.Convenio_vo;

import java.util.ArrayList;

/**
 * Created by lenovo on 6/09/2017.
 */

public class Adaptador_Convenios extends RecyclerView.Adapter<Adaptador_Convenios.ViewHolderConvenios> implements View.OnClickListener
{

    ArrayList<Convenio_vo> listaConvenios;

    private View.OnClickListener listener;

    public Adaptador_Convenios(ArrayList<Convenio_vo> listaConvenios) {
        this.listaConvenios = listaConvenios;
    }


    @Override
    public ViewHolderConvenios onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_convenio,null,false);

        view.setOnClickListener(this);

        return new ViewHolderConvenios(view);


    }

    @Override
    public void onBindViewHolder(ViewHolderConvenios holder, int position) {

        holder.nombre.setText(listaConvenios.get(position).getNombre());
        holder.descripcion.setText(listaConvenios.get(position).getDescripcion());
        holder.contacto.setText(listaConvenios.get(position).getContacto());
        holder.imagen.setImageResource(listaConvenios.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return listaConvenios.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {

        if(listener!=null){
            listener.onClick(v);
        }
    }



    public class ViewHolderConvenios extends RecyclerView.ViewHolder {

        TextView nombre;
        TextView descripcion;
        TextView contacto;
        ImageView imagen;

        public ViewHolderConvenios(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombreConvenio);
            descripcion = (TextView) itemView.findViewById(R.id.informacion_Convenio);
            contacto = (TextView) itemView.findViewById(R.id.contactoConvenio);
            imagen = (ImageView) itemView.findViewById(R.id.FotoConvenio);
        }
    }
}