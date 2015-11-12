package fragment.dany.loaders;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dany on 08/10/2015.
 */
public class MiLoader extends AsyncTaskLoader<List> {

    public MiLoader(Context context) {
        super(context);
    }

    @Override
    public List loadInBackground() {
        //return null;
        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < 100000 ; i++) {
            lista.add( getContext().getResources().getString(R.string.numero) + i);
        }
        return lista;
    }
}
