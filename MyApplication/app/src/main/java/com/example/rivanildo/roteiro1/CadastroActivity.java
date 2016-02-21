package com.example.rivanildo.roteiro1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText mNome;
    private EditText mSobrenome;
    private EditText mUsuario;
    private EditText mSenha1;
    private EditText mSenha2;
    private Button mBotao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        this.mNome = (EditText)findViewById(R.id.nome);
        this.mSobrenome = (EditText)findViewById(R.id.sobrenome);
        this.mUsuario = (EditText)findViewById(R.id.usuario);
        this.mSenha1 = (EditText)findViewById(R.id.senha1);
        this.mSenha2 = (EditText)findViewById(R.id.senha2);
        this.mBotao = (Button)findViewById(R.id.button);

        this.mBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });

    }

    private void cadastrar() {
        String nome = this.mNome.getText().toString();
        String sobrenome = this.mSobrenome.getText().toString();
        String usuario = this.mUsuario.getText().toString();
        String senha1 = this.mSenha1.getText().toString();
        String senha2 = this.mSenha2.getText().toString();

        if(usuario.equalsIgnoreCase("Rivan") && senha1.equalsIgnoreCase(senha2)){
            Intent i = new Intent(this, MainActivity.class);
            Bundle b = new Bundle();
            b.putString("nome",nome.toString());
            b.putString("sobre", sobrenome.toString());
            b.putString("u", usuario.toString());
            i.putExtras(b);
            startActivity(i);
            //talvez o finish();
        }
        else{
            View focus = null;
            if(TextUtils.isEmpty(nome)){
                this.mNome.setError("Campo Vazio");
                focus = this.mNome;
                focus.requestFocus();
            }
            if(TextUtils.isEmpty(sobrenome)){
                this.mSobrenome.setError("Campo Vazio");
                focus = this.mSobrenome;
                focus.requestFocus();
            }

            if(TextUtils.isEmpty(usuario)){
                this.mUsuario.setError("Campo Vazio");
                focus = this.mUsuario;
                focus.requestFocus();
            }

            if(TextUtils.isEmpty(senha1)){
                this.mSenha1.setError("Campo Vazio");
                focus = this.mSenha1;
                focus.requestFocus();
            }
            if(TextUtils.isEmpty(senha2)){
                this.mSenha2.setError("Campo Vazio");
                focus = this.mSenha2;
                focus.requestFocus();
            }

            if(!senha1.equalsIgnoreCase(senha2)){
                this.mSenha1.setError("Senha não compatíveis");
                focus = this.mSenha1;
                focus.requestFocus();
            }

            else{
                this.mUsuario.setError("Problema ao se cadastrar");
                focus = this.mUsuario;
                focus.requestFocus();
            }

        }
    }


}
