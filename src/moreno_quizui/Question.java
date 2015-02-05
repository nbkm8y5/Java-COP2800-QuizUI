package moreno_quizui;

/**
 * Question Class. Solves COP2800 Java Project # 2 COPYRIGHT (C) 2014 Rolando
 * Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno COP 2800
 * @version 1.01 2014-04-17
 */
public class Question {

    private String question = "";
    private String answer = "";
    private String unverifiedAnswer = "";
    private double unverifiedNumericalAnswer = 0.0;
    private boolean correctAnswer = false;

    /**
     * Question Class Constructor. Initialized with a String question, and
     * String answer.
     *
     * @param question
     * @param answer
     */
    public Question(String question, String answer) {
        // TODO: fill in implementation
        this.question = question;
        this.answer = answer;
    }

    /**
     * This method sets unverified answers, and unverified numerical answers
     * into instance variables.
     *
     * @param unverifiedAnswer Collects a string from the user.
     * @param unverifiedNumericAnswer Collects a double from the user.
     */
    public void setUnverifiedAnswer(String unverifiedAnswer, double unverifiedNumericalAnswer) {
        this.unverifiedAnswer = unverifiedAnswer;
        this.unverifiedNumericalAnswer = unverifiedNumericalAnswer;
    }

    /**
     * This method returns a String of a question.
     *
     * @return Returns the String of a question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method returns a String of an answer.
     *
     * @return Returns the String of an answer.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method returns an unverified numerical answer.
     *
     * @return This returns a double of an unverified numerical answer.
     */
    public double getUnverifiedNumericalAnswer() {
        return unverifiedNumericalAnswer;
    }

    /**
     * This method returns a String of an unverified answer.
     *
     * @return This returns a String of an unverified answer.
     */
    public String getUnverifiedAnswer() {
        return unverifiedAnswer;
    }

    /**
     * This methods checks the quiz answer against the answer that was collected
     * in the constructor of this class. It compares Strings.
     *
     * @return This returns a String of arguments.
     */
    public String checkForAnswer() {
        String returnValue = "";

        if (unverifiedAnswer.equalsIgnoreCase(answer)) {
            returnValue = Constants.CORRECT;
            correctAnswer = true;
        } else {
            returnValue = Constants.INCORRECT;
            correctAnswer = false;
        }
        return returnValue;
    }

    /**
     * This method returns a boolean that is used in the Quiz Class to tabulate
     * right and wrong answers.
     *
     * @return Returns a boolean.
     */
    public boolean correctAnswer() {
        return correctAnswer;
    }
}
