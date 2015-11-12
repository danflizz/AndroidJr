package holamundo.com.dany.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Persona[] personas =
                {
                        new Persona("Daniely Flores","1234567890","@danflizz","daniely.flores.lara@gmail.com"),
                        new Persona("Marisol Tejeida","1234567890","mtjeida","mtejeida@gmail.com"),
                        new Persona("Laura Olguín","1234567890","no tengo","laura.selenita@hotmail.com"),
                        new Persona("Alejandro Villalvazo","1234567890","no tengo","alexvillama@gmail.com"),
                        new Persona("Tere Valdez","1234567890","@tere","amarilla_cereza@hotmail.com")
                };

        final ListView lista = (ListView) findViewById(R.id.Lv1);
        lista.setAdapter(new ItemAdaptador(this,R.layout.item_lista_layout,personas));
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Persona persona = (Persona) lista.getAdapter().getItem(position);
                TextView tv1 = (TextView) findViewById(R.id.tv1);
                String twitter = getResources().getResourceName(R.string.twitter)+" "+persona.getTwitter();
                String correo = getResources().getResourceName(R.string.correo)+" "+persona.getCorreo();
                tv1.setText(twitter);
                tv1.setText(correo);
            }
        });
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
}
