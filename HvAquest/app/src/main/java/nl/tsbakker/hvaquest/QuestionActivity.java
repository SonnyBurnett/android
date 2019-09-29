package nl.tsbakker.hvaquest;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuestionActivity extends AppCompatActivity {



    RadioGroup radioGroup;
    Button answerButton;
    TextView questionTextview;
    RadioButton answer;
    RadioButton answer1;
    RadioButton answer2;
    RadioButton answer3;
    int questionNumber = 1;
    String[] items;
    String correctAnswer;
    String givenAnswer;
    public static final String questionKey = "questionKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        radioGroup = findViewById(R.id.answers_radiogroup);
        answerButton = findViewById(R.id.check_button);
        questionTextview = findViewById(R.id.question_textview);
        answer1 = findViewById(R.id.answer1_button);
        answer2 = findViewById(R.id.answer2_button);
        answer3 = findViewById(R.id.answer3_button);

        populateQuestion(questionNumber);

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(QuestionActivity.this, QuestionActivity.class);
                //startActivity(intent);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Snackbar.make(view, getApplicationContext().getString(R.string.choose_answer),
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                else {
                    RadioButton answer = (RadioButton) findViewById(selectedId);
                    givenAnswer = (String) answer.getText();
                    if (givenAnswer.equals(correctAnswer)) {
                        Intent intent = new Intent(QuestionActivity.this, LocationActivity.class);
                        intent.putExtra(questionKey, questionNumber);
                        startActivityForResult(intent,1234);
                    }
                    else {
                        //Snackbar.make(view, getApplicationContext().getString(R.string.try_again),
                        //        Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        Snackbar.make(view, "FAIL! correctAnswer = " + correctAnswer + " givenAnswer = " + givenAnswer
                                ,Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }
                }

            }
        });
    }

    public void populateQuestion(int questionNumber){

        //   populate question
        String question = "question" + questionNumber;
        int holderint1 = getResources().getIdentifier(question, "string",
                this.getPackageName()); // You had used "name"
        String questionScreen = getResources().getString(holderint1);
        questionTextview.setText(questionScreen);

        // populate answer
        String answer = "answer" + questionNumber;
        int holderint = getResources().getIdentifier(answer, "array",
                this.getPackageName()); // You had used "name"
        items = getResources().getStringArray(holderint);
        answer1.setText(items[1]);
        answer2.setText(items[2]);
        answer3.setText(items[3]);
        correctAnswer = items[0];
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Check if the result code is the right one
        if (resultCode == Activity.RESULT_OK) {
            //Check if the request code is correct
            if (requestCode == 1234) {
                questionNumber = data.getIntExtra(LocationActivity.clueKey,-1);
                populateQuestion(questionNumber);
                radioGroup.clearCheck();
            }
        }
    }


}
