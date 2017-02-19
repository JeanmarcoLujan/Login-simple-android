package com.example.user.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText usuario;
    private static EditText password;
    private static TextView intentos;
    private static Button login;
    int num_intentos = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton();
    }

    public void LoginButton(){
        usuario = (EditText)findViewById(R.id.editTextUser);
        password = (EditText)findViewById(R.id.editTextPass);
        intentos = (TextView) findViewById(R.id.textViewIntentos);
        login = (Button)findViewById(R.id.btnIniciarSesion);
        intentos.setText(Integer.toString(num_intentos));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usuario.getText().toString().equals("jeanmarco")&& password.getText().toString().equals("password")){
                    Toast.makeText(MainActivity.this,"Usuario y Contraseña correctos",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Credenciales incorrectas",Toast.LENGTH_SHORT).show();
                    num_intentos --;
                    intentos.setText(Integer.toString(num_intentos));
                    if (num_intentos == 0){
                        login.setEnabled(false);
                    }
                }
            }
        });
    }
}
