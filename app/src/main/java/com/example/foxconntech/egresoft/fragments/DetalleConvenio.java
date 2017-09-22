package com.example.foxconntech.egresoft.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.vo.Convenio_vo;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetalleConvenio.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetalleConvenio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetalleConvenio extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ImageView fotoConvenio;
    TextView nombreConvenio;
    TextView infoConvenio;
    TextView contactoConvenio;

    public DetalleConvenio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetalleConvenio.
     */
    // TODO: Rename and change types and number of parameters
    public static DetalleConvenio newInstance(String param1, String param2) {
        DetalleConvenio fragment = new DetalleConvenio();
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

       View vista= inflater.inflate(R.layout.fragment_detalle_convenio, container, false);

        nombreConvenio=vista.findViewById(R.id.nombreDetalleConvenio);
        infoConvenio=vista.findViewById(R.id.infoDetalleConvenio);
        contactoConvenio=vista.findViewById(R.id.contactoDetalleConvenio);
        fotoConvenio=vista.findViewById(R.id.fotoDetalleconvenio);

        Bundle objetoConvenio=getArguments();
        Convenio_vo convenio_vo=null;


        if(objetoConvenio!=null){
            convenio_vo=(Convenio_vo)objetoConvenio.getSerializable("objeto");
            nombreConvenio.setText(convenio_vo.getNombre());
            infoConvenio.setText(convenio_vo.getDescripcion());
            contactoConvenio.setText(convenio_vo.getContacto());
            fotoConvenio.setImageResource(convenio_vo.getFoto());

        }


        return vista;
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
