package agalygin.greenrivertech.net.quizapplication;

/**
 * Created by Andrey G on 4/21/2016.
 * Question Class
 */
public class Question {

    //fields
    private String statement;
    private boolean answer;

    public Question()
    {
        statement="";
        answer=true;

    }
    //constructor
    public Question(String statement, boolean answer) {

        this.statement = statement;
        this.answer = answer;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }



}
