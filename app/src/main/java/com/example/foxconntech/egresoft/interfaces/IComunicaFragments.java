package com.example.foxconntech.egresoft.interfaces;

import com.example.foxconntech.egresoft.egresadoVo.PersonaVo;
import com.example.foxconntech.egresoft.vo.Convenio_vo;
import com.example.foxconntech.egresoft.vo.Estudio_Vo;

/**
 * Created by Foxconn Tech on 22/09/2017.
 */

    public interface IComunicaFragments {

    public void enviarEstudio(Estudio_Vo estudio_vo);
    public void enviarConvenio(Convenio_vo convenio_vo);
    }
