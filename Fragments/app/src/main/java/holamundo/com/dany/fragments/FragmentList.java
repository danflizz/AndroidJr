package holamundo.com.dany.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Hubber on 07/10/2015.
 */
public class FragmentList extends android.app.Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //return super.onCreateView(inflater, container, savedInstanceState)
        return  inflater.inflate(R.layout.fragment1 ,container);
    }
}
