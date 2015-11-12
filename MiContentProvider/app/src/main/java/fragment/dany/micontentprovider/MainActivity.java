package fragment.dany.micontentprovider;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*

         */
        TextView txtV = (TextView) findViewById(R.id.txtV);
        txtV.setText("");

        Uri uriLlamadas = Uri.parse("content://call_log/calls"); //Estas direcciones estan en la pagina de developer de android
        String [] campos = new String[]
        {
                CallLog.Calls.NUMBER,
                CallLog.Calls.DATE,
                CallLog.Calls.CACHED_NAME,
                CallLog.Calls.DURATION,
                CallLog.Calls.TYPE
        };

        ContentResolver contentResolver = getContentResolver();
        Cursor registros = contentResolver.query(uriLlamadas,campos,null,null,CallLog.Calls.DATE+" "+"DESC");

        while(registros.moveToNext())
        {
            //indices de las columnas
            int numero = registros.getColumnIndex(CallLog.Calls.NUMBER);
            int fecha = registros.getColumnIndex(CallLog.Calls.DATE);
            int nombre = registros.getColumnIndex(CallLog.Calls.CACHED_NAME);
            int duracion = registros.getColumnIndex(CallLog.Calls.DURATION);
            int tipo = registros.getColumnIndex(CallLog.Calls.TYPE);

            //se obtienen los datos
            String Numero = registros.getString(numero);
            Long Fecha = registros.getLong(fecha);
            String Nombre = registros.getString(nombre);
            String Duracion = registros.getString(duracion);
            String Tipo = registros.getString(tipo);

            int tipo1 =  Integer.parseInt(Tipo);
            String tipollamada = "";

            // Segun el tipo de llamada aparecerá el mensaje
            switch (tipo1)
            {
                case CallLog.Calls.INCOMING_TYPE:
                    tipollamada = getString(R.string.entrada);
                    break;
                case CallLog.Calls.OUTGOING_TYPE:
                    tipollamada = getString(R.string.salida);
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    tipollamada = getString(R.string.perdida);
                    break;

                case CallLog.Calls.VOICEMAIL_TYPE:
                    tipollamada = getString(R.string.buzon);
                    break;
                default:
                    tipollamada = getString(R.string.indefinido);

            }

                //mostrar todas las llamadas con sus daatos
            String detalle = getString(R.string.numero)+" "+Numero+"\n"
                             +getString(R.string.nombre)+ " "+Nombre+"\n"
                            +getString(R.string.fecha)+ " "+ android.text.format.DateFormat.format("dd/MM/yyyy k:mm",Fecha) +"\n"
                            +getString(R.string.duracion)+ " "+Duracion+"\n"
                            +getString(R.string.tipo)+ " "+tipollamada+"\n";

            txtV.append(detalle+"\n");

        }
    }
}
