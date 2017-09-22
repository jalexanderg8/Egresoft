package com.example.foxconntech.egresoft.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foxconntech.egresoft.adaptadores.Adaptador_P_Academico;
import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.interfaces.IComunicaFragments;
import com.example.foxconntech.egresoft.vo.Estudio_Vo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link P_AcademicoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link P_AcademicoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class P_AcademicoFragment extends Fragment  implements Serializable{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<Estudio_Vo> lista_Estudios;
    RecyclerView recyclerEstudios;
    Activity activity;
    IComunicaFragments interfaceComunicaFragment;

    public P_AcademicoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static P_AcademicoFragment newInstance(String param1, String param2) {
        P_AcademicoFragment fragment = new P_AcademicoFragment();
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

        View view=inflater.inflate(R.layout.fragment_p__academico, container, false);

        recyclerEstudios=(RecyclerView)view.findViewById(R.id.recycler_P_Academico);

        llenarLista();
        recyclerEstudios.setLayoutManager(new LinearLayoutManager(getContext()));

        Adaptador_P_Academico miAdaptador=new Adaptador_P_Academico(lista_Estudios);
        recyclerEstudios.setAdapter(miAdaptador);

        miAdaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getContext(),"esta en:"+lista_Estudios.get(recyclerEstudios
                        .getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_SHORT).show();

                interfaceComunicaFragment.enviarEstudio(lista_Estudios.get(recyclerEstudios.
                        getChildAdapterPosition(view)));

            }
        });

        return view;
    }

    private void llenarLista() {
        lista_Estudios=new ArrayList<>();

        lista_Estudios.add(new Estudio_Vo("Excel basico","40 horas ","lunes, miercoles y viernes 7 am 11 am"));
        lista_Estudios.add(new Estudio_Vo("ingles basico","60 horas","martes a jueves 2 pm 6 pm"));
        lista_Estudios.add(new Estudio_Vo("contabilidad","80 horas","lunes a viernes  6pm 10 pm"));
        lista_Estudios.add(new Estudio_Vo("Photoshop","40 horas ","viernes 8 am 1 pm"));
        lista_Estudios.add(new Estudio_Vo("java ","120 horas","lunes a viernes 8am 12 m"));
        lista_Estudios.add(new Estudio_Vo("php","60 horas","martes y jueves 8am 12m"));
        lista_Estudios.add(new Estudio_Vo("html5","30 horas ","miercoles 7am 11am"));
        lista_Estudios.add(new Estudio_Vo("Phyton","80 horas","jueves 1 pm 7pm "));

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

        if(context instanceof  Activity){
            this.activity=(Activity) context;
            interfaceComunicaFragment=(IComunicaFragments) this.activity;
        }
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
