package net.tecnogab.app.hptsqlite.clientes;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import net.tecnogab.app.hptsqlite.R;
import net.tecnogab.app.hptsqlite.data.ClienteContract.ClienteEntry;

/**
 * Created by Joselo on 3/9/2016.
 */
public class ClientesCursorAdapter extends CursorAdapter{

    public ClientesCursorAdapter(Context p_context, Cursor p_cursor) {
        super(p_context, p_cursor, 0);
    }

    @Override
    public View newView(Context p_context, Cursor p_cursor, ViewGroup p_viewGroup) {
        LayoutInflater l_inflater = LayoutInflater.from(p_context);
        return l_inflater.inflate(R.layout.list_item_clientes, p_viewGroup, false);
    }

    @Override
    public void bindView(View p_view, final Context p_context, Cursor p_cursor) {

        // Referencias UI.
        TextView l_mameText = (TextView) p_view.findViewById(R.id.tv_name);
        final ImageView l_avatarImage = (ImageView) p_view.findViewById(R.id.iv_avatar);

        //Get Valores
        String l_name = p_cursor.getString(p_cursor.getColumnIndex(ClienteEntry.NOMBRE));
        String l_avatarUri = p_cursor.getString(p_cursor.getColumnIndex(ClienteEntry.AVATAR_URI));

        //Setup
        l_mameText.setText(l_name);
        Glide.with(p_context).load("file:///android_asset/" + l_avatarImage).asBitmap().
                error(R.drawable.ic_account_circle).centerCrop().into(new BitmapImageViewTarget(l_avatarImage){
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(p_context.getResources(), resource);
                drawable.setCircular(true);
                l_avatarImage.setImageDrawable(drawable);
            }
        });
    }
}
