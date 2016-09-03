package net.tecnogab.app.hptsqlite.clientes;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.tecnogab.app.hptsqlite.R;


public class ClientesFragment extends Fragment {

    public ClientesFragment() {
        // Required empty public constructor
    }

    public static ClientesFragment newInstance() {
        return new ClientesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater p_inflater, ViewGroup p_container, Bundle p_savedInstanceState) {

        View l_root = p_inflater.inflate(R.layout.fragment_clientes, p_container, false);
        return l_root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

}
