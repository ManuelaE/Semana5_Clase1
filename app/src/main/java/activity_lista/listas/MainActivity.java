package activity_lista.listas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private EditText etNombre;
    private Button btnOk;
    private ListView lvEstudiantes;
    private ArrayList<String> estudiantes;
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        estudiantes = new ArrayList<>();
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, estudiantes);

        etNombre = findViewById(R.id.et_nombre);
        btnOk = findViewById(R.id.btn_ok);
        lvEstudiantes = findViewById(R.id.lv_estudiantes);

        lvEstudiantes.setAdapter(adaptador);

        View.OnClickListener miListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                estudiantes.add(nombre);
                adaptador.notifyDataSetChanged();
                etNombre.setText("");
            }
        };

        btnOk.setOnClickListener( miListener );
    }

}
