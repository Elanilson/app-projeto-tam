package com.elanilsondejesus.projetotam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
            R.id.nav_principal,R.id.nav_servico,R.id.nav_contato,R.id.nav_sobre
                ,R.id.nav_clientes

                )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){
        String celular ="tel:91996017676";
        String imagem ="https://miro.medium.com/max/1200/1*GCu4cNWIU1ElDbY7d4ycZw.png";
        String endereco ="https://www.google.com.br/maps/place/Esta%C3%A7%C3%A3o+das+Docas/@-1.4487967,-48.5024554,883m/data=!3m2!1e3!4b1!4m5!3m4!1s0x92a48f8e824de2d5:0xc3ab0136dae42ab4!8m2!3d-1.4487967!4d-48.5002667";
//        Intent  intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
//        Intent  intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
//        Intent  intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));
        Intent  intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new  String []{"atedimento@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem Automatica");
        intent.setType("message/rfc822");
//        intent.setType("txt/plain");
//        intent.setType("imagem/*");

        startActivity(Intent.createChooser(intent,"Compartilhar"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
