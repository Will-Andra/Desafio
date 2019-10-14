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

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout inputEmail;
    private TextInputLayout inputSenha;
    private Button btnLogin;
    private Button btnRegistrar;

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    private String email, senha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarCampos();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
            }
        });



    }

    public void initViews() {
        inputEmail = findViewById(R.id.txtEmailLogin);
        inputSenha = findViewById(R.id.txtPasswordLogin);
        btnLogin = findViewById(R.id.BtnLogin);
        btnRegistrar = findViewById(R.id.btnRegistrarLogin);
    }


    public void validarCampos(){
        inputEmail.setErrorEnabled(false);
        inputSenha.setErrorEnabled(false);

        email = inputEmail.getEditText().getText().toString().trim();
        senha = inputSenha.getEditText().getText().toString().trim();

        if (!validateEmail(email) && !validatePassword(senha)) {
            inputEmail.setError("Digite um e-mail válido");
            inputSenha.setError("Sua senha deve ter pelo menos 6 caractéres!");
        } else if (!validatePassword(senha)) {
            inputSenha.setError("Sua senha deve ter pelo menos 6 caractéres!");
            inputEmail.setErrorEnabled(false);
        } else if(!validateEmail(email)){
            inputEmail.setError("Digite um e-mail válido");
            inputSenha.setErrorEnabled(false);
        }else{

            inputEmail.setErrorEnabled(false);
            inputSenha.setErrorEnabled(false);

            //Incluir fluxo seguinte... próximas sprints
            startActivity(new Intent(LoginActivity.this, MainActivity.class));

        }

    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }

}
