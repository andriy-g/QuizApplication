package agalygin.greenrivertech.net.quizapplication;

import java.util.ArrayList;

/**
 * Created by Andriy Galygin on 4/21/2016.
 * 4.22.16
 */

/*
* New questions are created and added to the array
*/
public class Quiz {

    private ArrayList<Question> questionList;

    //Creates new questions using Question class and adds them to questionList Array.
    public Quiz(){
        Question q1 = new Question("Green River College has new Bachelor Degrees.", true);
        Question q2 = new Question("Washington is always sunny.", false);
        Question q3 = new Question("Space needle is located in Seattle.", true);
        Question q4 = new Question("Windows is better then Apple.", true);
        Question q5 = new Question("Lightning never strikes in the same place twice.", false);
        Question q6 = new Question("Humans can’t breathe and swallow at the same time.", true);
        Question q7 = new Question("The owner of the company that makes Segways died " +
                                     "after accidentally driving his Segway off a cliff.", true);
        Question q8 = new Question("There is no word that rhymes with Orange", true);
        Question q9 = new Question("Google was originally called BACKRUB", true);
        Question q10 = new Question("There is a planet that rains glass sideways", true);
        Question q11 = new Question("This question is used to catch the app from crashing", true);

        //Adds questions created to the Array
        questionList = new ArrayList<Question>();
        questionList.add(q1);
        questionList.add(q2);
        questionList.add(q3);
        questionList.add(q4);
        questionList.add(q5);
        questionList.add(q6);
        questionList.add(q7);
        questionList.add(q8);
        questionList.add(q9);
        questionList.add(q10);
        questionList.add(q11);
    }

    //Takes value as parameter and returns index value from questionList Array.
    public Question getIthQuestion(int i) {
        return questionList.get(i);
    }
}
