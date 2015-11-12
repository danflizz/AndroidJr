package holamundo.com.dany.fragments;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.zip.Inflater;


/**
 * Created by Hubber on 07/10/2015.
 */
public class ItemAdaptador extends ArrayAdapter<Persona> //coleccion
{
     Context context;
    Persona[] personas;
    int resource;

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater Inflater = ((Activity) context).getLayoutInflater();
        View v =  Inflater.inflate(resource,null); //Inflater.inflate(resource,null);
        TextView txtV = (TextView) v.findViewById(R.id.txtV);
        TextView txtV1 = (TextView) v.findViewById(R.id.txtV1);
        txtV.setText(personas[position].getNombre());
        txtV1.setText(personas[position].getTelefono());

        return v;
    }

    public ItemAdaptador(Context context, int resource, Persona[] personas) {
        super(context, resource, personas);

        this.context = context;
        this.personas = personas;
        this.resource = resource;
    }
}
