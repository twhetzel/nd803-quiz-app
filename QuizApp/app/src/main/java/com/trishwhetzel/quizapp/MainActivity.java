package com.trishwhetzel.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
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
                String myMessage = getQuizResponses(view);

                // Display results with score
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, myMessage+score, duration);
                toast.show();

                // Reset score
                score = 0;
                // Reset input fields


//                Snackbar.make(view, myMessage+" Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    /**
     * Get quiz responses
     * @param view
     */
    public String getQuizResponses(View view) {
        // Get Answer 1 Response
        EditText q1_answer = (EditText) findViewById(R.id.beer_wagon);
        String q1_answer_text = q1_answer.getText().toString().trim();
        Log.d(TAG, "Q1-Answer:" + q1_answer_text);
        // Score Q1 Response
        int q1_score = checkAnswerQ1(q1_answer_text);
        Log.d(TAG, "Q1-Score:"+q1_score);


        // Get Answer 2 Response
        CheckBox q2_answer_ten_stakes = (CheckBox) findViewById(R.id.q2_checkbox_ten_stakes);
        CheckBox q2_answer_kentucky_derby = (CheckBox) findViewById(R.id.q2_checkbox_kentucky_derby);
        CheckBox q2_answer_soapbox = (CheckBox) findViewById(R.id.q2_checkbox_soapbox);
        CheckBox q2_answer_preakness = (CheckBox) findViewById(R.id.q2_checkbox_preakness);
        CheckBox q2_answer_belmont = (CheckBox) findViewById(R.id.q2_checkbox_belmont);
        CheckBox q2_answer_belmont_fake = (CheckBox) findViewById(R.id.q2_checkbox_belmont_fake);
        // Score Q2 Responses
        int q2_score = checkAnswerQ2(q2_answer_ten_stakes, q2_answer_kentucky_derby, q2_answer_soapbox, q2_answer_preakness,
                q2_answer_belmont, q2_answer_belmont_fake);
        Log.d(TAG, "Q2-Score:"+q2_score);


        // Get Answer 3 Response
        //RadioButton q3_answer_arabian = (RadioButton) findViewById(R.id.q3_radio_arabian);
        RadioButton q3_answer_prez = (RadioButton) findViewById(R.id.q3_radio_prez);
        //RadioButton q3_answer_clydesdale = (RadioButton) findViewById(R.id.q3_radio_clydesdale);
        // Score Q3 Response
        int q3_score = checkAnswerQ3(q3_answer_prez);
        Log.d(TAG, "Q3-Score:"+q3_score);

        // Get Answer 4 Response
        RadioButton q4_answer_true = (RadioButton) findViewById(R.id.q4_true);
        // Score Q4 Response
        int q4_score = checkAnswerQ4(q4_answer_true);
        Log.d(TAG, "Q4-Score:"+q4_score);

        String scoreMessage = "You answered the Quiz!";
        return scoreMessage;
    }


    /**
     * Check response for Question 1
     * @param q1_answer_text
     * @return
     */
    private int checkAnswerQ1(String q1_answer_text) {
        // Check if text is answer Clydesdale
        String correctAnswer = getString(R.string.q1_correct_answer);
        if (q1_answer_text.equals(correctAnswer)) {
            score++;
            Log.d(TAG, "-- Correct Q1 Answer");
        }
        return score;
    }

    /**
     * Check response for Question 2
     * @param q2_answer_ten_stakes
     * @param q2_answer_kentucky_derby
     * @param q2_answer_soapbox
     * @param q2_answer_preakness
     * @param q2_answer_belmont
     * @param q2_answer_belmont_fake
     */
    public int checkAnswerQ2(CheckBox q2_answer_ten_stakes, CheckBox q2_answer_kentucky_derby,
                             CheckBox q2_answer_soapbox, CheckBox q2_answer_preakness,
                             CheckBox q2_answer_belmont, CheckBox q2_answer_belmont_fake) {

        if ((q2_answer_ten_stakes.isChecked() == false) && q2_answer_kentucky_derby.isChecked() &&
                (q2_answer_soapbox.isChecked() == false) && q2_answer_preakness.isChecked() &&
                q2_answer_belmont.isChecked() && (q2_answer_belmont_fake.isChecked() == false)) {
            score++;
            Log.d(TAG, "-- Correct Q2 Answer");
        }
        return score;
    }

    /**
     * Check response for Question 3
     * @param q3_answer_prez
     * @return
     */
    private int checkAnswerQ3(RadioButton q3_answer_prez) {
        if(q3_answer_prez.isChecked()) {
            score++;
            Log.d(TAG, "-- Correct Q3 Answer");
        }
        return score;
    }

    /**
     * Check response for Question 4
     * @param q4_answer_true
     * @return
     */
    private int checkAnswerQ4(RadioButton q4_answer_true) {
        if(q4_answer_true.isChecked()){
            score++;
        }
        return score;
    }




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
