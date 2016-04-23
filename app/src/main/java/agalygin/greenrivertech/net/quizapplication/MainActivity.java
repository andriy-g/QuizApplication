package agalygin.greenrivertech.net.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Fields
    private int total = 0;
    private int questionsRight = 0;
    private int questionsWrong = 0;
    private Quiz quiz;
    private int currentQuestion;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        quiz = new Quiz();

        currentQuestion = 0;
        Question q = quiz.getIthQuestion(currentQuestion);

        //Updates text field with a question
        TextView myText = (TextView)findViewById(R.id.questionText);
        myText.setText(q.getStatement());

    }

    /*
    * True button onClick event, get notification depending on the answer.
    */
    public void trueButtonClick(View view) {
        total++;
        if(quiz.getIthQuestion(currentQuestion).getAnswer() == true) {
            questionsRight++;
            Toast.makeText(getBaseContext(), "You got it", Toast.LENGTH_LONG).show();
        }
        else {
            questionsWrong++;
            Toast.makeText(getBaseContext(), "Try Again", Toast.LENGTH_LONG).show();
        }
    }

    /*
    * False Button onClick event, get notification for selected answer
    */
    public void falseButtonClick(View view) {
        total++;
        if(quiz.getIthQuestion(currentQuestion).getAnswer() == true) {
            questionsWrong++;
            Toast.makeText(getBaseContext(), "Try Again", Toast.LENGTH_LONG).show();
        }
        else {
            questionsRight++;
            Toast.makeText(getBaseContext(), "You got it", Toast.LENGTH_LONG).show();
        }
    }

    /*
    * Updates text field with a new questions and shows summary screen after last question.
    */
    public void handleNextButtonClick(View view) {

        currentQuestion++;
        Question q = quiz.getIthQuestion(currentQuestion);

        TextView myText = (TextView)findViewById(R.id.questionText);
        myText.setText(q.getStatement());

        if(q == quiz.getIthQuestion(10)){
           // Toast.makeText(getBaseContext(), "IT WORKS", Toast.LENGTH_LONG).show();
            setContentView(R.layout.result_activity);
            TextView textResult = (TextView) findViewById(R.id.summary);
            TextView right = (TextView) findViewById(R.id.right);
            TextView wrong = (TextView) findViewById(R.id.wrong);

            textResult.setText("Questions Answered: " + total);
            right.setText("Questions Right:  " + questionsRight);
            wrong.setText("Questions Wrong: " + questionsWrong);
        }
    }

    /*
    * Starts the quiz again after clicking on Play Again button on the summary screen
    */
    public void playagain (View vo) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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
