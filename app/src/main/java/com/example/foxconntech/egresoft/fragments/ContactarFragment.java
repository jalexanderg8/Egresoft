package com.example.foxconntech.egresoft.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.activitys.Principal;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContactarFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContactarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactarFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText txtAsunto,txtMensaje;
    String correo,contra;
    Session session;
    Button btnEnviar,btnCancelar;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ContactarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactarFragment newInstance(String param1, String param2) {
        ContactarFragment fragment = new ContactarFragment();
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

        View vista=inflater.inflate(R.layout.fragment_contactar_admin, container, false);

        txtAsunto=vista.findViewById(R.id.txtAsuntoCorreo);
        txtMensaje=vista.findViewById(R.id.txtMensajeCorreo);
        btnEnviar=vista.findViewById(R.id.btnEnviarCorreo);
        btnCancelar=vista.findViewById(R.id.btnCancelarCorreo);

        correo="pruebaegresado@gmail.com";
        contra="Egresoft2017";

        btnEnviar.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {

                                             if (txtAsunto.getText().toString().equals("") || txtMensaje.getText().toString().equals("")) {

                                                 Toast.makeText(getContext(), "El campo Asunto y mensaje son obligatorios", Toast.LENGTH_LONG).show();
                                             } else {

                                                 StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                                                 StrictMode.setThreadPolicy(policy);
                                                 Properties properties = new Properties();
                                                 properties.put("mail.smtp.host", "smtp.googlemail.com");
                                                 properties.put("mail.smtp.socketFactory.port", "465");
                                                 properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                                                 properties.put("mail.smtp.auth", "true");
                                                 properties.put("mail.smtp.port", "465");


                                                 try {

                                                     session = Session.getDefaultInstance(properties, new Authenticator() {
                                                         @Override
                                                         protected PasswordAuthentication getPasswordAuthentication() {
                                                             return new PasswordAuthentication(correo, contra);
                                                         }
                                                     });

                                                     if (session != null) {

                                                         String asunto = txtAsunto.getText().toString();

                                                         Message message = new MimeMessage(session);
                                                         message.setFrom(new InternetAddress(correo));
                                                         message.setSubject(asunto);
                                                         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jagomez6605@misena.edu.co"));
                                                         message.setContent(txtMensaje.getText().toString(), "text/html; charset=utf-8");
                                                         Transport.send(message);
                                                         Toast.makeText(getContext(), "Correo enviado con exito ", Toast.LENGTH_LONG).show();
                                                         limpiar();


                                                     }

                                                 } catch (Exception e) {

                                                     e.printStackTrace();
                                                     Toast.makeText(getContext(), "Correo NO enviado con exito ", Toast.LENGTH_LONG).show();
                                                     limpiar();
                                                 }


                                                 Intent i = new Intent(getContext(), Principal.class);
                                                 startActivity(i);


                                             }
                                         }
                                     });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(getContext(),Principal.class);
                startActivity(i);
                limpiar();
            }
        });

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

    private void limpiar() {

        txtAsunto.setText("");
        txtMensaje.setText("");
    }

    @Override
    public void onClick(View view) {

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
