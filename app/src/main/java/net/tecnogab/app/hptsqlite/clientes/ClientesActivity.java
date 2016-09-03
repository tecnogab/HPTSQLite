package net.tecnogab.app.hptsqlite.clientes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import net.tecnogab.app.hptsqlite.R;

public class ClientesActivity extends AppCompatActivity {

    public static final String EXTRA_CLIENTE_ID = "extra_cliente_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ClientesFragment l_fragment = (ClientesFragment) getSupportFragmentManager().findFragmentById(R.id.clientes_container);

        if (l_fragment == null){
            l_fragment = ClientesFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.clientes_container, l_fragment).commit();
        }

    }

}
