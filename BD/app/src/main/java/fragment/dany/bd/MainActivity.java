package fragment.dany.bd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   public void mostrarDatos(View v)
   {
        AccionesDB db = new AccionesDB(this,"agenda",null,1);
       SQLiteDatabase acciones = db.getReadableDatabase();
       TextView result = (TextView) findViewById(R.id.contenidoRegis);
       result.setText(null);
       Cursor registros = acciones.rawQuery("SELECT * from persona",null);

       while (registros.moveToNext())
       {
           String detalle = getString(R.string.nombre)+": "
                   +registros.getString(1)+"\n"
                   +getString(R.string.telefono)+": "
                   +registros.getString(2)+"\n"
                   +getString(R.string.twitter)+": "
                   +registros.getString(3)+"\n"
                   +getString(R.string.email)+ ": "
                   +registros.getString(4)+ "\n\n";
           result.append(detalle);
       }
       registros.close();
       acciones.close();
   }

    public void guardarDatos(View v)
    {
        AccionesDB DB = new AccionesDB(this,"agenda",null,1);
        SQLiteDatabase Acciones = DB.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",((EditText) findViewById(R.id.edTNombre)).getText().toString());
        values.put("phone",((EditText) findViewById(R.id.edTtelefono)).getText().toString());
        values.put("twitter",((EditText) findViewById(R.id.edTtwitter)).getText().toString());
        values.put("email",((EditText) findViewById(R.id.edTcorreo)).getText().toString());
        Acciones.insert("persona", null, values);
        Acciones.close();
        ((EditText) findViewById(R.id.edTNombre)).setText("");
        ((EditText) findViewById(R.id.edTtelefono)).setText("");
        ((EditText) findViewById(R.id.edTtwitter)).setText("");
        ((EditText) findViewById(R.id.edTcorreo)).setText("");

        Toast.makeText(this,R.string.exito,Toast.LENGTH_SHORT).show();
    }
    public void borrarDatos(View v)
    {
        AccionesDB Db = new AccionesDB(this,"agenda",null,1);
        SQLiteDatabase ac = Db.getWritableDatabase();
        ac.delete("persona",null,null);
        ac.close();

        Toast.makeText(this,R.string.exitoborrar,Toast.LENGTH_SHORT).show();
    }
}
