package god.cna.bluapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    private UserManager userManager;
    TextInputEditText inputUsername, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userManager = new UserManager(MainActivity.this);
        initViews();
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }

        Executor executor = ContextCompat.getMainExecutor(MainActivity.this);
        BiometricPrompt biometricPrompt = new BiometricPrompt(MainActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);

            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                startActivity(new Intent(MainActivity.this, BluActivity.class));
                finish();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("ورود با اثر انگشت")
                .setNegativeButtonText("انصراف").build();


        MaterialButton btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                biometricPrompt.authenticate(promptInfo);
                String txtInputUsername = inputUsername.getText().toString();

                String txtInputPassword = inputPassword.getText().toString();

                userManager.saveUserInfo(txtInputUsername, txtInputPassword);


            }
        });

    }

    private void initViews() {
        ImageView btnMainInfo = findViewById(R.id.ic_info_main);
        btnMainInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InfoMainDialog infoMainDialog = new InfoMainDialog();
                infoMainDialog.setCancelable(false);
                infoMainDialog.show(getSupportFragmentManager(), null);
            }
        });

        inputUsername = findViewById(R.id.input_username);
        inputPassword = findViewById(R.id.input_password);
        if (userManager.getUsername() != null) {
            inputUsername.setText(userManager.getUsername());

        }

        if (userManager.getPassword() != null) {
            inputPassword.setText(userManager.getPassword());

        }
    }
}