package com.example.usuario.practica07s10;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(layaout);
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
        AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
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
    }

    public void showAlertDialogList() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
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
                    msg = msg + " " + (i + 1) + ": " + colors[slist.get(i)];
                }
                Toast.makeText(getApplicationContext(), "Items Seleccionados" + " " + msg, Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Nada", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void showNotification() {

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
