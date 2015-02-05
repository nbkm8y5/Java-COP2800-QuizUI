package moreno_quizui;

/**
 * Numeric Question Class. Solves COP2800 Java Project # 2 COPYRIGHT (C) 2014
 * Rolando Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno COP 2800
 * @version 1.01 2014-04-13
 */
public class NumericQuestion extends Question {

    double numericalAnswer = 0.0;
    private boolean correctAnswer = false;

    /**
     * NumericQuestion Constructor. Initialized with three arguments, two of
     * which are from superclass Question.
     *
     * @param question This argument collects a String question.
     * @param answer This argument collects the answer to be used in the quiz.
     * @param numericalAnswer This argument collects the numeric answer to be
     * used in the quiz.
     */
    NumericQuestion(String question, String answer, double numericalAnswer) {
        super(question, answer);
        this.numericalAnswer = numericalAnswer;
    }

    /**
     * This methods checks the quiz answer against the answer that was collected
     * in the constructor of this class. It overrides the method from the
     * Question Class to compare doubles, instead of Strings.
     *
     * @return This returns a String of arguments.
     */
    @Override
    public String checkForAnswer() {
        String returnValue = "";

        if (Math.abs(this.getUnverifiedNumericalAnswer() - numericalAnswer) <= Constants.EPSILON) {
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
    @Override
    public boolean correctAnswer() {
        return correctAnswer;
    }
}
