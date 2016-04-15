package br.com.puts.comparefuel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText gas;
    private EditText alc;
    private ImageView img;
    public Button btn;
    public TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            gas = (EditText)findViewById(R.id.valorGas);
            alc = (EditText)findViewById(R.id.valorAlc);
            img = (ImageView) findViewById(R.id.imageView);
            btn = (Button) findViewById(R.id.button);
            txt = (TextView) findViewById(R.id.txtaviso);

            //Adiciona a mascara aos valores.
            //gas.addTextChangedListener(new MascaraMonetaria(gas));
            //alc.addTextChangedListener(new MascaraMonetaria(alc));

            btn.setOnClickListener(new View.OnClickListener() {
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

            if (ind <= a) {
                img.setImageResource(R.drawable.gasolina);
                txt.setText(aviso);
            } else {
                img.setImageResource(R.drawable.alcool);
                txt.setText(aviso);
            }

        }
    }
}
