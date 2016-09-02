package net.tecnogab.app.hptsqlite.data;

import android.provider.BaseColumns;

/**
 * Created by Joselo on 2/9/16.
 */
public class ClienteContract {

    public static abstract class ClienteEntry implements BaseColumns{

        public static final String TABLE_NAME = "t_clientes";

        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String APELLIDO = "apellido";
        public static final String AVATAR_URI = "avatarUri";

    }
}
