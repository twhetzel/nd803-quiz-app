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
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    // Global variable to track scores for correct quiz responses
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
                Toast toast = Toast.makeText(context, myMessage + score, duration);
                toast.show();

                // Reset score
                score = 0;
                // Reset input fields
            }
        });
    }

    /**
     * Get quiz responses
     *
     * @param view
     */
    public String getQuizResponses(View view) {
        // Get Answer 1 Response
        EditText q1_answer = (EditText) findViewById(R.id.q1_edit_text);
        String q1_answer_text = q1_answer.getText().toString().trim().toLowerCase();
        // Score Q1 Response
        checkAnswerQ1(q1_answer_text);

        // Get Answer 2 Response
        CheckBox q2_answer_ten_stakes = (CheckBox) findViewById(R.id.q2_checkbox_ten_stakes);
        CheckBox q2_answer_kentucky_derby = (CheckBox) findViewById(R.id.q2_checkbox_kentucky_derby);
        CheckBox q2_answer_soapbox = (CheckBox) findViewById(R.id.q2_checkbox_soapbox);
        CheckBox q2_answer_preakness = (CheckBox) findViewById(R.id.q2_checkbox_preakness);
        CheckBox q2_answer_belmont = (CheckBox) findViewById(R.id.q2_checkbox_belmont);
        CheckBox q2_answer_belmont_fake = (CheckBox) findViewById(R.id.q2_checkbox_belmont_fake);
        // Score Q2 Responses
        checkAnswerQ2(q2_answer_ten_stakes, q2_answer_kentucky_derby, q2_answer_soapbox, q2_answer_preakness,
                q2_answer_belmont, q2_answer_belmont_fake);


        // Get Answer 3 Response
        RadioButton q3_answer_prez = (RadioButton) findViewById(R.id.q3_radio_prez);
        // Score Q3 Response
        checkAnswerQ3(q3_answer_prez);

        // Get Answer 4 Response
        RadioButton q4_answer_true = (RadioButton) findViewById(R.id.q4_true);
        // Score Q4 Response
        checkAnswerQ4(q4_answer_true);

        // Get Answer 5 Response
        RadioButton q5_answer_three = (RadioButton) findViewById(R.id.q5_three);
        // Score Q5 Response
        checkAnswer5(q5_answer_three);

        String scoreMessage = "Your Quiz score is ";
        return scoreMessage;
    }


    /**
     * Check response for Question 1
     *
     * @param q1_answer_text
     * @return
     */
    private int checkAnswerQ1(String q1_answer_text) {
        // Check if text is answer Clydesdale
        String correctAnswer = getString(R.string.q1_correct_answer);
        if (q1_answer_text.equals(correctAnswer)) {
            score++;
        }
        return score;
    }

    /**
     * Check response for Question 2
     *
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
        }
        return score;
    }

    /**
     * Check response for Question 3
     *
     * @param q3_answer_prez
     * @return
     */
    private int checkAnswerQ3(RadioButton q3_answer_prez) {
        if (q3_answer_prez.isChecked()) {
            score++;
        }
        return score;
    }

    /**
     * Check response for Question 4
     *
     * @param q4_answer_true
     * @return
     */
    private int checkAnswerQ4(RadioButton q4_answer_true) {
        if (q4_answer_true.isChecked()) {
            score++;
        }
        return score;
    }

    /**
     * Check for response for Question 5
     *
     * @param q5_answer_three
     * @return
     */
    private int checkAnswer5(RadioButton q5_answer_three) {
        if (q5_answer_three.isChecked()) {
            score++;
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
        // clear form fields
        if (id == R.id.clear_fields) {
            Log.d(TAG, "** Clear fields");
            clearForm((ViewGroup) findViewById(R.id.root_layout));
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Clear form fields
     * @param group
     */
    private void clearForm(ViewGroup group) {
        {
            for (int i = 0, count = group.getChildCount(); i < count; ++i) {
                View view = group.getChildAt(i);
                if (view instanceof EditText) {
                    ((EditText) view).setText("");
                }

                if(view instanceof RadioButton) {
                    ((RadioButton) view).setChecked(false);
                }

                if(view instanceof CheckBox) {
                    ((CheckBox) view).setChecked(false);
                }

                if (view instanceof ViewGroup && (((ViewGroup) view).getChildCount() > 0))
                    clearForm((ViewGroup) view);
            }
        }
    }
}