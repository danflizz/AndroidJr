package fragment.dany.miservicio;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Dany on 08/10/2015.
 */
public class MiServicio extends Service {
    @Override
    public IBinder onBind(Intent intent)
    {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // return super.onStartCommand(intent, flags, startId);
        Toast.makeText(this,getResources().getString(R.string.servicioI),Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this,getResources().getString(R.string.servicioT),Toast.LENGTH_LONG).show();
    }
}
