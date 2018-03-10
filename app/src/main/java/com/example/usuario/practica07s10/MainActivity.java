package com.example.usuario.practica07s10;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] datos = {"Toast", "Toast Personalizado", "Snackbar", "Alert Dialog", "Alert Dialog List", "Notification", "Big Text Notification",
            "Inbox Style Notification", "Picture Notification", "Progress Dialog", "Progress Dialog Notification", "Spinner"};
    final CharSequence[] colors = {"Rojo", "Negro", "Azul", "Naranja"};
    ArrayList<Integer> slist = new ArrayList();
    boolean icount[] = new boolean[colors.length];
    String msg = "";

    ListView listView;
    TextView txt;
    ProgressDialog progressDialog;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    public static final String NOTIFICACION = "NOTIFICACION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.lview);
        txt = findViewById(R.id.textView);
        listViewWork();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void listViewWork() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0://toast
                        Toast.makeText(getApplicationContext(), "Ejemplo Toast", Toast.LENGTH_SHORT).show();
                        break;
                    case 1://Toast Personalizado
                        LayoutInflater inflater = getLayoutInflater();
                        View layaout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_Llayout));

                        TextView tv=new TextView(getApplicationContext());
                        tv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                        tv.setTextColor(Color.WHITE);
                        tv.setTextSize(30);
                        tv.setPadding(10,10,10,10);
                        tv.setText("Ejemplo de toast");

                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.setDuration(Toast.LENGTH_LONG);
                        //toast.setView(layaout);
                        toast.setView(tv);
                        toast.show();
                        break;
                    case 2://Snackbar
                        Snackbar.make(view, "Ejemplo Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        break;
                    case 3://Alert Dialog
                        showAlertDialog();
                        break;
                    case 4://Alert Dialog List
                        showAlertDialogList();
                        break;
                    case 5://Notification
                        showNotification();
                        break;
                    case 6://Big Text Notification
                        showNotificationBigText();
                        break;
                    case 7://Inbox Style Notification
                        showNotificationInbox();
                        break;
                    case 8:
                        showNotificationPicture();
                        break;
                    case 9:
                        showProgressDialog();
                        break;
                    case 10:
                        showNotificationProgressDialog();
                        break;
                    case 11:
                        showSpinner();
                        break;
                }
            }
        });
    }


    public void showAlertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Ejemplo de Alert Dialog");
        dialog.setMessage("¿Deseas Salir?");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        dialog.setCancelable(false);
        dialog.setNegativeButton("No quiero", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        dialog.setPositiveButton("Si quiero", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });
        dialog.show();
    }

    public void showAlertDialogList() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Elegir Colores").setMultiChoiceItems(colors, icount, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    slist.add(which);
                } else if (slist.contains(which)) {
                    slist.remove(Integer.valueOf(which));
                }
            }
        }).setCancelable(false).setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                msg = "";
                for (int i = 0; i < slist.size(); i++) {
                    msg = msg + "\n " + (i + 1) + ": " + colors[slist.get(i)];
                }
                Toast.makeText(getApplicationContext(), "Items Seleccionados" + "\n " + msg, Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Nada", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();


    }

    public void showNotification() {
        int icon = R.drawable.ic_notification;
        CharSequence titulo = "Notificacion de Practica";
        CharSequence titubar = "Barra de notificacion";
        CharSequence txto = "Ejemplo de Lanzamiento de Notificacion Android";

        String txtnotifica = "Saludos desde \n" + getResources().getString(R.string.app_name);
        Intent i = new Intent(getApplicationContext(), secondActivity.class);
        i.putExtra(NOTIFICACION, txtnotifica);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent p1 = PendingIntent.getActivity(getApplicationContext(), 0, i, 0);
        Notification notification = new Notification.Builder(getApplicationContext()).setTicker(titulo).setContentTitle(titubar).setContentText(txto)
                .setSmallIcon(icon).setAutoCancel(true).setContentIntent(p1).build();
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;
        notification.defaults |= Notification.DEFAULT_LIGHTS;

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(0, notification);
    }

    public void showNotificationBigText() {

    }

    public void showNotificationInbox() {

    }

    public void showNotificationPicture() {
    }

    public void showProgressDialog() {
    }

    public void showNotificationProgressDialog() {
    }


    public void showSpinner() {
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
