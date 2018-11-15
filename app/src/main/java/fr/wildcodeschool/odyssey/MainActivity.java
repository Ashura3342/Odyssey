package fr.wildcodeschool.odyssey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkIsWilder;
    private EditText editFirstName;
    private EditText editLastName;
    private TextView txOk;
    private Button btAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkIsWilder = findViewById(R.id.check_main_is_wilder);
        editFirstName = findViewById(R.id.edit_main_firstname);
        editLastName = findViewById(R.id.edit_main_lastname);
        btAccept = findViewById(R.id.bt_main_accept);
        txOk = findViewById(R.id.main_message_ok);

        checkIsWilder.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editLastName.setEnabled(isChecked);
            editFirstName.setEnabled(isChecked);
            btAccept.setEnabled(isChecked);
        });

        btAccept.setOnClickListener((View v) -> {
            String firstName = editFirstName.getText().toString();
            String lastName = editLastName.getText().toString();

            if (firstName.isEmpty() || lastName.isEmpty()) {
                Toast.makeText(this, getString(R.string.main_error), Toast.LENGTH_SHORT)
                        .show();
            } else {
                txOk.setText(String.format("%s %s %s", getString(R.string.main_ok), firstName, lastName));
            }
        });
    }
}
