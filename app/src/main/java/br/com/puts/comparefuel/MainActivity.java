package br.com.puts.comparefuel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText gas;
    private EditText alc;
    private ImageView img;
    public Button btn1;
    public TextView txt;
    public TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            gas = findViewById(R.id.valorGas);
            alc = findViewById(R.id.valorAlc);
            img = findViewById(R.id.imageView);
            btn1 = findViewById(R.id.btnCompare);
            txt = findViewById(R.id.txtaviso);
            txt1 = findViewById(R.id.txtaviso1);

            //Adiciona a mascara aos valores.
            //gas.addTextChangedListener(new MascaraMonetaria(gas));
            //alc.addTextChangedListener(new MascaraMonetaria(alc));

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    compare(v);
                }
            });

    }

    public void compare(View v){

        String aviso = "Melhor custo benefício.";

        if(gas.getText().toString().equals("") || alc.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),"Por Favor Digite os Valores!", Toast.LENGTH_SHORT).show();
        }else{

            double g = Double.valueOf(gas.getText().toString());
            double a = Double.valueOf(alc.getText().toString());

            double ind = (g * 0.70);

            DecimalFormat nf = new DecimalFormat("#.00");

            if (ind < a) {
                String text = "O alcool tem que esta em R$ " + nf.format(ind);
                img.setImageResource(R.drawable.gasolina);
                txt.setText(aviso);
                txt1.setText(text);
            } else if (ind == a){
                String text = "O alcool tem que esta em R$ " + nf.format(ind);
                img.setImageResource(R.drawable.gasolina);
                txt.setText(aviso);
                txt1.setText(text);
            }else {
                img.setImageResource(R.drawable.alcool);

                Double result = ((ind * g)/100) + 1;

                String text = "A gasolina tem que esta em R$ " + nf.format(ind * result);
                txt.setText(aviso);
                txt1.setText(text);
            }

        }

    }
}
