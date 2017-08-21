package com.example.foxconntech.egresoft.Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JULIAN HENAO on 20/08/2017.
 */

public class Adaptador_P_Academico extends RecyclerView.Adapter<Adaptador_P_Academico.ViewHolderP_Academico>{


    @Override
    public ViewHolderP_Academico onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolderP_Academico holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderP_Academico extends RecyclerView.ViewHolder {
        public ViewHolderP_Academico(View itemView) {
            super(itemView);
        }
    }
}
