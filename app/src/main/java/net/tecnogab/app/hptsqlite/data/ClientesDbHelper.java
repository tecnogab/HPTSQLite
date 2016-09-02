package net.tecnogab.app.hptsqlite.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static net.tecnogab.app.hptsqlite.data.ClienteContract.ClienteEntry;

/**
 * Created by Joselo on 2/9/16.
 */
public class ClientesDbHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Clientes.db";

    public ClientesDbHelper(Context p_context) {
        super(p_context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase p_sqLiteDatabase) {

        p_sqLiteDatabase.execSQL("CREATE TABLE " + ClienteEntry.TABLE_NAME + " ("
            + ClienteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ClienteEntry.ID + " TEXT NOT NULL,"
            + ClienteEntry.NOMBRE + " TEXT NOT NULL,"
            + ClienteEntry.APELLIDO + " TEXT NOT NULL,"
            + ClienteEntry.AVATAR_URI + " TEXT,"
            + "UNIQUE (" + ClienteEntry.ID + "))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase p_sqLiteDatabase, int p_oldVersion, int p_newVersion) {
        // No hay operaciones
    }

    public long guardarCliente(Cliente p_cliente){

        SQLiteDatabase l_db = getWritableDatabase();
            return l_db.insert(ClienteEntry.TABLE_NAME, null, p_cliente.toContentValues());
    }

    public Cursor obtenerTodosLosClientes(){
        return getReadableDatabase().query(ClienteEntry.TABLE_NAME, null, null, null, null, null, null);
    }

    public Cursor obtenerClientePorId(String p_idCliente){
        Cursor l_cursor = getReadableDatabase().query(
                ClienteEntry.TABLE_NAME,
                null,
                ClienteEntry.ID + " LIKE ?",
                new String[]{p_idCliente},
                null,
                null,
                null
        );
        return l_cursor;
    }
}
