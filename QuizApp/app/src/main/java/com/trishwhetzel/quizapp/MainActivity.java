package com.trishwhetzel.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get results of quiz responses
                String myMessage = getQuizResponses();

                // Display results with score
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, myMessage+score, duration);
                toast.show();

                // Reset score
                score = 0;

//                Snackbar.make(view, myMessage+" Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Get quiz responses
     */
    public String getQuizResponses() {
        // Get Answer 1
        EditText q1_answer = (EditText) findViewById(R.id.beer_wagon);
        String q1_answer_text = q1_answer.getText().toString();
        q1_answer_text = q1_answer_text.trim();
        Log.d(TAG, "Q1 Answer:" + q1_answer_text);
        int q1_score = checkAnswerQ1(q1_answer_text);
        Log.d(TAG, "Q1-Score:"+q1_score);

        // Get Answer 2
        CheckBox q2_answer = (CheckBox) findViewById(R.id.checkbox4);
        String q2_answer_text = q2_answer.getText().toString();
        Log.d(TAG, "Num hooves:"+q2_answer_text);

        // Get Answer 3


        String scoreMessage = "You answered the Quiz!";
        return scoreMessage;
    }

    private int checkAnswerQ1(String q1_answer_text) {
        Log.d(TAG, "User-Answer:"+q1_answer_text);
        // Check if text is answer Clydesdale
        String correctAnswer = getString(R.string.q1_correct_answer);
        if (q1_answer_text.equals(correctAnswer)) {
            score++;
            Log.d(TAG, "Correct Q1 Answer");
        }
        return score;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
