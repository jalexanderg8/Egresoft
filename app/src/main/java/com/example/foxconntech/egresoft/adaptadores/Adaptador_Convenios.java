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

public class Adaptador_Convenios extends RecyclerView.Adapter<Adaptador_Convenios.ViewHolder> implements View.OnClickListener
{

    ArrayList<Convenio_vo> arrayList;

    public Adaptador_Convenios(ArrayList<Convenio_vo> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_convenio,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.nombre.setText(arrayList.get(position).getNombre());
        holder.descripcion.setText(arrayList.get(position).getDescripcion());
        holder.contacto.setText(arrayList.get(position).getContacto());
        holder.imagen.setImageResource(arrayList.get(position).getFoto());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        TextView descripcion;
        TextView contacto;
        ImageView imagen;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombreConvenio);
            descripcion = (TextView) itemView.findViewById(R.id.informacion_Convenio);
            contacto = (TextView) itemView.findViewById(R.id.contactoConvenio);
            imagen = (ImageView) itemView.findViewById(R.id.FotoConvenio);
        }
    }
}