package com.example.foxconntech.egresoft.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.foxconntech.egresoft.adaptadores.Adaptador_Eventos;
import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.conexion.Conexion;
import com.example.foxconntech.egresoft.constantes.Constantes;
import com.example.foxconntech.egresoft.vo.Evento_Vo;
import com.example.foxconntech.egresoft.vo.Noticia_vo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EventosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EventosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<Evento_Vo> ListaEventos;
    ArrayList<Noticia_vo>ListaNoticias;
    RecyclerView EventosRecycler;
    Fragment miFragment;
     Button registra;
    Conexion miConexion;
    SQLiteDatabase bd;

    public EventosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventosFragment newInstance(String param1, String param2) {
        EventosFragment fragment = new EventosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

 View vista=inflater.inflate(R.layout.fragment_eventos, container, false);


        registra=vista.findViewById(R.id.btnRegistrarAlEvento);

        EventosRecycler=vista.findViewById(R.id.recycler_Eventos);

        llenarLista();
        EventosRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        Adaptador_Eventos adaptador=new Adaptador_Eventos(ListaEventos);
        EventosRecycler.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"esta en:"+ListaEventos.get(EventosRecycler.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_LONG).show();
            }
        });
        return vista;
    }


    private void llenarLista() {
        ListaEventos=new ArrayList<>();
        ListaEventos.add(new Evento_Vo("evento de navidadcccccccccccccccc","sena centro de comercio y turismo","43 de octubre",R.drawable.navidad));
        ListaEventos.add(new Evento_Vo("en tic confio","centro de convenviones armenia quindio","4 de septiembre",R.drawable.tic));
        ListaEventos.add(new Evento_Vo("novenas de navidad","sena quindio","24 de diciembre",R.drawable.navidad));
        ListaEventos.add(new Evento_Vo("novenas de navidad","sena quindio","24 de diciembre",R.drawable.logo_sena_verde));


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
