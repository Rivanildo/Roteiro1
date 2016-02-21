package com.example.rivanildo.roteiro1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensagem = (TextView)findViewById(R.id.textView);
        Bundle b = getIntent().getExtras();
        String nome = b.getString("nome");
        String sobrenome = b.getString("sobre");
        String usu = b.getString("u");
        this.mensagem.setText("Olá, bem vindo "+ nome +""+ sobrenome + "\nSeu login é: "+usu+ "\nSalve a senha e o usuário em segurança!");



    }
}
