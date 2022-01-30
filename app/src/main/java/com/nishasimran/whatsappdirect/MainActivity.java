package com.nishasimran.whatsappdirect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phoneEditText, msgEditText;
    Button sendBtn;

    String phone, message, urlMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneEditText = findViewById(R.id.phone_edit_text);
        msgEditText = findViewById(R.id.msg_edit_text);
        sendBtn = findViewById(R.id.send_btn);

        sendBtn.setOnClickListener(view -> {
            if (viewsFilled()) {
                String url = "https://wa.me/91" + phone + "/?text=" + urlMessage;
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private boolean viewsFilled() {
        if (!phoneEditText.getText().toString().isEmpty() && !msgEditText.getText().toString().isEmpty() && phoneEditText.getText().toString().length() == 10) {

            phone = phoneEditText.getText().toString();
            message = msgEditText.getText().toString();
            urlMessage = Uri.encode(message);

            return true;

        } else {
            Toast.makeText(this, "Invalid values", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}