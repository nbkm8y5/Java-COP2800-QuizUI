package moreno_quizui;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Quiz Class. Solves COP2800 Java Project # 2 COPYRIGHT (C) 2014 Rolando
 * Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno COP 2800
 * @version 1.01 2014-04-17
 */
public class Quiz {

    private static ArrayList<Question> questions = new ArrayList<>();
    private double numberofQuestions = questions.size();

    /**
     * This method returns the ArrayList of the Question Class.
     *
     * @return This returns the ArrayList of Question Class.
     */
    public static ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * This method adds a Question object into the ArrayList of Questions.
     *
     * @param question This passes an object to be added to the ArrayList
     * questions.
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * This method resets the quiz by running ArrayList method remove() through
     * a for loop.
     */
    public void resetQuiz() {
        for (int i = questions.size() - 1; i >= 0; i--) {
            questions.remove(i);
        }
    }

    /**
     * This method checks to the ArrayList questions to determine if it is empty
     * or not.
     *
     * @return This returns a boolean regarding the status of the ArrayList
     * questions.
     */
    public boolean checkForQuiz() {
        boolean returnValue = false;
        if (questions.isEmpty()) {
            returnValue = true;
        }
        return returnValue;
    }

    /**
     * This method collects the number of correct answers by running an if
     * statement which increments if the correct answer is true.
     *
     * @return This returns a prepared string showing the number of right
     * answers out of number of questions asked in the quiz.
     */
    public String quizResults() {
        String returnValue = "";
        int correctAnswers = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).correctAnswer()) {
                correctAnswers++;
            }
        }
        returnValue = String.format(Constants.QUIZ_RESULTS, correctAnswers, questions.size());
        return returnValue;
    }
}
