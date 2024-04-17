package in.bitcode.a10_04_24_contarintlayoutresources;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView txtWelcomeMessage;
    TextView txtAndroidBatch;
    EditText edtUsername;
    Button btnSubmit;

    Resources resources;
    int [] oddNumbers;
    int numOne;
    int redColorValue;
    String [] names;
    String name;
    TypedArray colours;
    TypedArray numbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        getResourcesFromXML();
    }

    private void getResourcesFromXML(){
        resources = getResources();
        redColorValue = resources.getColor(R.color.red);
        Log.e("RedColourValue", "Red Colour Value" + redColorValue);
        name = resources.getString(R.string.name);
        Log.e("name","Name is " + name);
        numOne = resources.getInteger(R.integer.One);
        Log.e("numOne","Number is " + numOne);
        colours = resources.obtainTypedArray(R.array.colours);
        numbers = resources.obtainTypedArray(R.array.numbers);
        oddNumbers = resources.getIntArray(R.array.odd_numbers);
        for(int i = 0; i< oddNumbers.length;i++){
            Log.e("tag","i th number is " + oddNumbers[i]);
        }
        names = resources.getStringArray(R.array.students_names);
        for(int i = 0;i<names.length;i++){
            Log.e("name", "Name is " + names[i]);
        }
    }

    private void initViews(){
        txtWelcomeMessage = findViewById(R.id.txtWelcomeMessage);
        txtAndroidBatch = findViewById(R.id.txtAndroidBatch);
        edtUsername = findViewById(R.id.edtUsername);
        btnSubmit = findViewById(R.id.btnSubmit);
    }

    private void initListeners(){
        btnSubmit.setOnClickListener(new BtnSubmitClickListener());
    }

    class BtnSubmitClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            txtWelcomeMessage.setText("Welcome " + edtUsername.getText().toString());
        }
    }
}