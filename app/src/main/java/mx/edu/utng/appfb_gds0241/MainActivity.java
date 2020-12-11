package mx.edu.utng.appfb_gds0241;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //Clase para manejar la lógica o control de la vista
    EditText etEquipo;
    EditText etJugador;
    Spinner spiEstatus;
    Spinner spiPosicion;
    Button btnRegistrar;

    private DatabaseReference bdDiario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Asociar los objetos de control con la vista del xml
        etJugador = (EditText)findViewById(R.id.etJug);
        etEquipo = (EditText)findViewById(R.id.etEqu);
                spiEstatus = (Spinner)findViewById(R.id.spiEst);
                spiPosicion = (Spinner)findViewById(R.id.spiPoc);
                btnRegistrar = (Button)findViewById(R.id.btnRegistrar);

                //Se define el objeto (Clase) haciendo refercnia a la conexión de FireBase
                bdDiario = FirebaseDatabase.getInstance().getReference("Clase");

                btnRegistrar.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        registrarClase();
                    }
                });
    }//fin del onCreate

    public void registrarClase(){

        String pocision = spiPosicion.getSelectedItem().toString();
        String estatus = spiEstatus.getSelectedItem().toString();
        String jugador = etJugador.getText().toString();
        String equipo = etEquipo.getText().toString();
        if(!TextUtils.isEmpty(jugador)){
            String id = bdDiario.push().getKey();
            Clase leccion = new Clase(id, pocision, estatus, jugador, equipo);
            bdDiario.child("Jugador").child(id).setValue(leccion);
            //mensaje de exito
            Toast.makeText(this,"jugador registrado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Debe introducir un jugador", Toast.LENGTH_SHORT).show();
        }
    }

}