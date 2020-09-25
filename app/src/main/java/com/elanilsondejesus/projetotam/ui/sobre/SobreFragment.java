package com.elanilsondejesus.projetotam.ui.sobre;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elanilsondejesus.projetotam.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

/**
 * A simple {@link Fragment} subclass.
 */
public class SobreFragment extends Fragment {


    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String descricao ="A evolução dos conceitos sobre Qualidade ao longo " +
                "do tempo, na chegada à chamada era atual da Gestão da Qualidade," +
                " ou da Qualidade Total está presente em vários livros, artigos," +
                " estudos de caso, normas e documentos emitidos pela ISO,";
        Element versao = new Element();
        versao.setTitle("Versão 1.0");
        return new AboutPage(getActivity())
                    .setImage(R.drawable.logo)
                .setDescription(descricao)

                .addGroup("Entre em contato")
                .addEmail("elanilsonpp@hotmail.com","Envie um e-mail")
                .addWebsite("www.apkdoandroid.com","Acesse nosso site")

                .addGroup("Redes sociais")
                .addFacebook("elanilsondejesus","Facebook")
                .addInstagram("elanilsondejesus","Instagram")
                .addTwitter("elanilsondejesus","Twitter")
                .addYoutube("elanilsondejesus","Youtube")
                .addGitHub("elanilsondejesus","GitHub")
                .addPlayStore("elanilsondejesus","Download App")

                .addItem(versao)


                .create();


//        return inflater.inflate(R.layout.fragment_sobre, container, false);
    }

}
