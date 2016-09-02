package net.tecnogab.app.hptsqlite.data;

import android.content.ContentValues;
import net.tecnogab.app.hptsqlite.data.ClienteContract.ClienteEntry;

import java.util.UUID;

/**
 * Created by Joselo on 2/9/16.
 */
public class Cliente {

    private String id;
    private String nombre;
    private String apellido;
    private String avatarUri;

    public Cliente(String p_nombre, String p_apellido, String p_avatarUri){

        this.id = UUID.randomUUID().toString();
        this.nombre = p_nombre;
        this.apellido = p_apellido;
        this.avatarUri = p_avatarUri;
    }

    public ContentValues toContentValues(){
        ContentValues l_values = new ContentValues();

        l_values.put(ClienteEntry.ID, id);
        l_values.put(ClienteEntry.NOMBRE, nombre);
        l_values.put(ClienteEntry.APELLIDO, apellido);
        l_values.put(ClienteEntry.AVATAR_URI, avatarUri);

        return l_values;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getAvatarUri() {
        return avatarUri;
    }
}
