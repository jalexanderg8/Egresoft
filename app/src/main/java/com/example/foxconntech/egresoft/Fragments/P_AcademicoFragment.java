package com.example.foxconntech.egresoft.Fragments;

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

import com.example.foxconntech.egresoft.Adaptadores.Adaptador_P_Academico;
import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.vo.Estudio_Vo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link P_AcademicoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link P_AcademicoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class P_AcademicoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayList<Estudio_Vo> Lista_Estudios;
    RecyclerView recyclerEstudios;

    public P_AcademicoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment P_AcademicoFragment.
     */
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

        Adaptador_P_Academico miAdaptador=new Adaptador_P_Academico(Lista_Estudios);
        recyclerEstudios.setAdapter(miAdaptador);

        miAdaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Toast.makeText(getContext(),"esta en:"+Lista_Estudios.get(recyclerEstudios.getChildAdapterPosition(view)).getNombre(),Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }

    private void llenarLista() {
        Lista_Estudios=new ArrayList<>();

        Lista_Estudios.add(new Estudio_Vo("tecnologia en analisis y desarrollo de sistemas de informacion","de lunes a viernes a las 3 am","sena galan sgasdg"));
        Lista_Estudios.add(new Estudio_Vo("tecnologia en peluqueria+maniquiur, y pediquiuur","de lunes a viernes a las 3 am","sena galan sgasdg"));

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
