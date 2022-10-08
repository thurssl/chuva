package br.ulbra.calculodesalario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView edtPercentual;
    Button botao;
    RadioGroup rgo;
    EditText Salario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);         setContentView(R.layout.activity_main);
        Salario = (EditText) findViewById(R.id.Salario);
        rgo = (RadioGroup) findViewById(R.id.rgop);
        botao = (Button) findViewById(R.id.botao);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                double salario = Double.parseDouble(Salario.getText().toString());
                int op = rgo.getCheckedRadioButtonId();
                double novo_salario = 0;

                if (op == R.id.rab40)
                    novo_salario = salario + (salario * 0.4);
                else if (op == R.id.rab45)
                    novo_salario = salario + (salario * 0.45);
                else
                    novo_salario = salario + (salario * 0.5);

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Novo salário");
                dialogo.setMessage("Seu novo salário é : R$"
                        +String.valueOf(novo_salario));
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }
}
