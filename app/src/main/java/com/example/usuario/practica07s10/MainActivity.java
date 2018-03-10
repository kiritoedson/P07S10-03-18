package com.example.usuario.practica07s10;

import android.app.ProgressDialog;
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
    String[] datos = {"Toast", "Toast Personalizado", "Snackbar", "Alert Dialog", "Aler Dialog List", "Notification", "Big Text Notification",
            "Inbox Style Notification", "Picture Notification", "Progress Dialog", "Progress Dialog Notification", "Spinner"};
    final CharSequence[] colors = {"Rojo", "Negro", "Azul", "Naranja"};
    ArrayList<Integer> slist = new ArrayList();
    Boolean icount[] = new Boolean[colors.length];
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

        listView=findViewById(R.id.lview);
        txt=findViewById(R.id.textView);
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
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0://toast
                        Toast.makeText(getApplicationContext(), "Ejemplo Toast", Toast.LENGTH_SHORT).show();
                        break;
                    case 1://Toast Personalizado
                        LayoutInflater inflater=getLayoutInflater();
                    View layaout =inflater.inflate(R.layout.toast_layout, (ViewGroup)findViewById(R.id.toast_Llayout);
                    Toast toast=new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layaout);
                    toast.show();
                        break;
                    case 2://Snackbar
                        Snackbar.make(view, "Ejemplo Snackbar", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                }
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
