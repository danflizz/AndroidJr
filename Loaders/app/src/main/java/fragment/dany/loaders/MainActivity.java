package fragment.dany.loaders;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLoaderManager().initLoader(1,null,this).forceLoad();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static int i=0;
    public void Siguiente(View view)
    {
        i++;
        Toast.makeText(this,getResources().getString(R.string.textomsj)+" "+i,Toast.LENGTH_SHORT).show();
    }

    @Override
    public Loader<List> onCreateLoader(int id, Bundle args) {
        MiLoader miloader = new MiLoader(this);

        return miloader;
    }

    @Override
    public void onLoadFinished(Loader<List> loader, List list) {
        ListView listView = (ListView) findViewById(R.id.ListV);

        listView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,list));

    }

    @Override
    public void onLoaderReset(Loader<List> loader) {

    }
}
