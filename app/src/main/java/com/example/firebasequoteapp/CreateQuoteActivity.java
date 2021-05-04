package com.example.firebasequoteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class CreateQuoteActivity extends AppCompatActivity {
    private EditText author,description;
    private Button saveQuoteBtn;
    private FirebaseFirestore firebaseFirestore;
    private QuoteModelClass quoteModelClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quote);
        author=findViewById(R.id.arthour);
        description=findViewById(R.id.description);
        saveQuoteBtn=findViewById(R.id.saveQuoteBtn);
        firebaseFirestore=FirebaseFirestore.getInstance();



        saveQuoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuoteToFireStore();

            }
        });
    }

    private void saveQuoteToFireStore(){

        String authorString=author.getText().toString();
        String descriptionString=description.toString();
        quoteModelClass=new QuoteModelClass();

        quoteModelClass.setAurthor(authorString);
        quoteModelClass.setDescription(descriptionString);
        String user_id= FirebaseAuth.getInstance().getCurrentUser().getUid();

        firebaseFirestore.collection("Quotes").document(user_id).set(quoteModelClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isComplete()){
                    Toast.makeText(getApplicationContext(), "Quote Saved to firestore", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Quote Saved to firestore ,failed", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }
}