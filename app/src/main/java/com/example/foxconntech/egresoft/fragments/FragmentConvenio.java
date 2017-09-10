package com.example.foxconntech.egresoft.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.adaptadores.Adaptador_Convenios;
import com.example.foxconntech.egresoft.vo.Convenio_vo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentConvenio.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentConvenio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentConvenio extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    RecyclerView Convenios_Recycler;
    ArrayList<Convenio_vo> ListaConvenios;

    public FragmentConvenio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentConvenio.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentConvenio newInstance(String param1, String param2) {
        FragmentConvenio fragment = new FragmentConvenio();
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


View vista=inflater.inflate(R.layout.fragment_fragment_convenio, container, false);

Convenios_Recycler=vista.findViewById(R.id.recycler_Convenios);

        llenarLista();

       Convenios_Recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        Adaptador_Convenios miAdaptador=new Adaptador_Convenios(ListaConvenios);
        Convenios_Recycler.setAdapter(miAdaptador);

        return vista;
    }

    private void llenarLista() {
        ListaConvenios=new ArrayList<>();
        ListaConvenios.add(new Convenio_vo("Universidad del quindio","homologa 5 semestres","pepito arturo sandoval 311544888",R.drawable.uniquindio));
        ListaConvenios.add(new Convenio_vo("EAM","homologa 5 semestres","pepito arturo sandoval 311544888",R.drawable.eam));
        ListaConvenios.add(new Convenio_vo("Universidad la grancolombia","homologa 5 semestres","pepito arturo sandoval 311544888",R.drawable.granco));
        ListaConvenios.add(new Convenio_vo("Remington","homologa 5 semestres","2pepito arturo sandoval 311544888",R.drawable.remington));



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
