package com.e.dhfood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.e.dhfood.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    private TextInputLayout inputEmailReg;
    private TextInputLayout inputNomeReg;
    private TextInputLayout inputSenhaReg;
    private TextInputLayout inputConfSenhaReg;
    private Button btnRegistrar;

    private static final String EMAIL_PATTERNs = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern patterns = Pattern.compile(EMAIL_PATTERNs);
    private Matcher matchers;



    private String emails, senhas, nomes, confSenha;

    public static final String EMAIL_KEYs = "emails";
    public static final String SENHA_KEYs = "senhas";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        initViewss();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emails = inputEmailReg.getEditText().getText().toString().trim();
                nomes = inputNomeReg.getEditText().getText().toString().trim();
                senhas = inputSenhaReg.getEditText().getText().toString().trim();
                confSenha= inputConfSenhaReg.getEditText().getText().toString().trim();

                if (!validateEmail(emails)) {
                    inputEmailReg.setError("Não é um e-mail válido");
                } else if (nomes.isEmpty()) {
                    inputNomeReg.setError("Insira um nome de usuário");
                } else if (!validatePassword(senhas)) {
                    inputSenhaReg.setError("Senha precisa ter no mínimo 6 caracteres");
                }else if (!validateConfPassword(confSenha)){
                    inputConfSenhaReg.setError("Senha precisa ter no mínimo 6 caracteres");
                } else if(senhas.equals(confSenha)) {

                    inputNomeReg.setErrorEnabled(false);
                    inputEmailReg.setErrorEnabled(false);
                    inputSenhaReg.setErrorEnabled(false);
                    inputConfSenhaReg.setErrorEnabled(false);


                    startActivity(new Intent(RegistroActivity.this, MainActivity.class));

                    //No Marvel foi direto para Main
                    //sendBundleToLogin();

                }else{


                    inputConfSenhaReg.setError("Senhas precisam ser iguais para se registrar");

                }

            }
        });

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroActivity that = (RegistroActivity) o;
        return senhas.equals(that.senhas) &&
                confSenha.equals(that.confSenha);
    }


    public void initViewss() {
        inputEmailReg = findViewById(R.id.txtEmailReg);
        inputSenhaReg = findViewById(R.id.txtPasswordReg);
        inputNomeReg = findViewById(R.id.txtNomeReg);
        inputConfSenhaReg = findViewById(R.id.txtPasswordConfirmaReg);
        btnRegistrar = findViewById(R.id.BtnRegistrarReg);
    }

    public boolean validateEmail(String email) {
        matchers = patterns.matcher(email);
        return matchers.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }
    public boolean validateConfPassword(String password) {
        return password.length() > 5;
    }


    public void sendBundleToLogin() {

        Intent intent = new Intent(RegistroActivity.this, MainActivity.class);

        Bundle bundle = new Bundle();

        bundle.putString(EMAIL_KEYs, emails);
        bundle.putString(SENHA_KEYs, senhas);

        intent.putExtras(bundle);

        startActivity(intent);
    }

}
