package rudol.com.desarrolloapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView nombre;
    private TextView descripcion;
    private TextView email2;
    private TextView telefono;
    private TextView f_naci;
    private Button edit_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        nombre =(TextView) findViewById(R.id.textoNombre);
        f_naci=(TextView)findViewById(R.id.fecha_naci);
        telefono= (TextView)findViewById(R.id.tel);
        email2 = (TextView)findViewById(R.id.e_mail);
        descripcion=(TextView)findViewById(R.id.descripcion2);

        nombre.setText(getIntent().getStringExtra("nombre"));
        descripcion.setText(getIntent().getStringExtra("descripcion"));
        email2.setText(getIntent().getStringExtra("email"));
        telefono.setText(getIntent().getStringExtra("telefono"));
        f_naci.setText(getIntent().getStringExtra("dia")+"/"+getIntent().getStringExtra("mes")+"/"+getIntent().getStringExtra("ano"));
    }

    public void editarDatos(View v)
    {

        String text = f_naci.getText().toString();
        String[] parts = text.split("/");
        int dia = Integer.parseInt(parts[0]);
        int mes = Integer.parseInt(parts[1])-1;
        int year = Integer.parseInt(parts[2]);

        Intent intent= new Intent(this,MainActivity.class);
        intent.putExtra("nombre",nombre.getText().toString());
        intent.putExtra("telefono", telefono.getText().toString());
        intent.putExtra("email",email2.getText().toString());
        intent.putExtra("descripcion", descripcion.getText().toString());
        intent.putExtra("ano", year);
        intent.putExtra("mes", mes);
        intent.putExtra("dia", dia);

        startActivity(intent);

    }

}
