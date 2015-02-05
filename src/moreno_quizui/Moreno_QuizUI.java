package moreno_quizui;

import java.util.Scanner;

/**
 * Quiz Builder and Quiz taker. Solves COP2800 Java Project # 2 COPYRIGHT (C)
 * 2014 Rolando Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno COP 2800
 * @version 1.01 2014-04-20
 */
public class Moreno_QuizUI {

    static boolean done = false;
    static int mainMenuSelection = 0;
    static int buildMenuSelection = 0;
    static int takeQuizMenuSelection = 0;
    static Menu mainMenu;
    static Menu buildMenu;
    static Menu quizMenu;
    static Menu choiceQuestionOptions;
    static Menu booleanQuestionOptions;
    static Question choiceQuestion;
    static Question booleanQuestion;
    static Quiz quiz = new Quiz();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (!done) {

            mainMenu = new Menu(Constants.MAIN_MENU, Constants.MAIN_MENU_SELECTIONS, Constants.DELIMETER);
            mainMenuSelection = mainMenu.getNextSelection(input);

            switch (mainMenuSelection) {
                case (Constants.BUILD_QUIZ): {

                    buildMenu = new Menu(Constants.BUILD_QUIZ_MENU, Constants.BUILD_QUIZ_MENU_SELECTIONS, Constants.DELIMETER);
                    buildMenuSelection = buildMenu.getNextSelection(input);

                    switch (buildMenuSelection) {
                        case (Constants.ADD_FILL_IN_QUESTION): {
                            addFillInQuestion();
                            break;
                        }
                        case (Constants.ADD_CHOICE_QUESTION): {
                            addChoiceQuestion();
                            break;
                        }
                        case (Constants.ADD_NUMERIC_QUESTION): {
                            addNumericQuestion();
                            break;
                        }
                        case (Constants.ADD_BOOLEAN_QUESTION): {
                            addBooleanQuestion();
                            break;
                        }
                        case (Constants.VIEW_QUIZ): {
                            viewQuiz();
                            break;
                        }
                        case (Constants.RESET_QUIZ): {
                            resetQuiz();
                            break;
                        }
                        case (Constants.RETURN_TO_MAIN_MENU): {
                            returnToMainMenu();
                            break;
                        }
                    }
                    break;
                }
                case (Constants.TAKE_QUIZ): {
                    takeQuiz();
                    break;
                }
                case (Constants.QUIT_PROGRAM): {
                    quit();
                    done = true;
                    break;
                }
            }
        }
    }

    /**
     * This method collects a fill in question and adds the object to an
     * ArrayList.
     */
    private static void addFillInQuestion() {
        Scanner input = new Scanner(System.in);
        String question = "";
        String answer = "";

        System.out.print(Constants.ENTER_QUESTION_TEXT);

        if (input.hasNextLine()) {
            question = input.nextLine();
        }

        System.out.print(Constants.ENTER_ANSWER);
        if (input.hasNextLine()) {
            answer = input.nextLine();
        }

        Question fillInQuestion = new Question(question, answer);
        quiz.addQuestion(fillInQuestion);
    }

    /**
     * This method collects a choice question, an option string and an answer,
     * DISPLAYS THE OPTIONS, and adds the object to an ArrayList.
     */
    private static void addChoiceQuestion() {
        Scanner input = new Scanner(System.in);
        String question = "";
        String optionString = "";
        String answer = "";

        System.out.print(Constants.ENTER_QUESTION_TEXT);

        if (input.hasNextLine()) {
            question = input.nextLine();
        }

        System.out.print(Constants.ENTER_OPTION_STRING);

        if (input.hasNextLine()) {
            optionString = input.nextLine();
        }

        choiceQuestionOptions = new Menu(question, optionString, Constants.DELIMETER);
        System.out.print(choiceQuestionOptions.getQuizOptionsDisplayString());

        System.out.print(Constants.ENTER_ANSWER);

        if (input.hasNextLine()) {
            answer = input.nextLine();
        }

        choiceQuestion = new ChoiceQuestion(question, optionString, answer);
        quiz.addQuestion(choiceQuestion);
    }

    /**
     * This method collects a question and a numerical answer and adds the
     * object to an ArrayList.
     */
    private static void addNumericQuestion() {
        Scanner input = new Scanner(System.in);
        String question = "";
        double numericalAnswer = 0.0;

        System.out.print(Constants.ENTER_QUESTION_TEXT);

        if (input.hasNextLine()) {
            question = input.nextLine();
        }

        System.out.print(Constants.ENTER_ANSWER);

        if (input.hasNextDouble()) {
            numericalAnswer = input.nextDouble();
            input.nextLine();
        }

        String stringAnswer = String.valueOf(numericalAnswer);

        Question numericQuestion = new NumericQuestion(question, stringAnswer, numericalAnswer);
        quiz.addQuestion(numericQuestion);
    }

    /**
     *
     */
    private static void addBooleanQuestion() {

        Scanner input = new Scanner(System.in);
        String question = "";
        String answer = "";

        System.out.print(Constants.ENTER_QUESTION_TEXT);

        if (input.hasNextLine()) {
            question = input.nextLine();
        }

        booleanQuestionOptions = new Menu(question, Constants.BOOLEAN_SELECTIONS, Constants.DELIMETER);
        System.out.print(booleanQuestionOptions.getQuizOptionsDisplayString());

        System.out.print(Constants.ENTER_ANSWER);
        if (input.hasNextLine()) {
            answer = input.nextLine();
        }

        booleanQuestion = new BooleanQuestion(question, answer);
        quiz.addQuestion(booleanQuestion);

    }

    /**
     * This method displays all the questions in the quiz.
     */
    private static void viewQuiz() {

        if (quiz.checkForQuiz()) {
            System.out.println(Constants.NO_QUIZ_ERROR);
        } else {

            for (int i = 0; i < quiz.getQuestions().size(); i++) {
                if (quiz.getQuestions().get(i).equals(choiceQuestion)) {
                    System.out.printf(String.format(Constants.OPTION_FORMAT, i + 1, quiz.getQuestions().get(i).getQuestion()));
                    System.out.printf(choiceQuestionOptions.getQuizOptionsDisplayString());
                } else if (quiz.getQuestions().get(i).equals(booleanQuestion)) {
                    System.out.printf(String.format(Constants.OPTION_FORMAT, i + 1, quiz.getQuestions().get(i).getQuestion()));
                    System.out.printf(booleanQuestionOptions.getQuizOptionsDisplayString());
                } else {
                    System.out.println(String.format(Constants.OPTION_FORMAT, i + 1, quiz.getQuestions().get(i).getQuestion()));
                }
            }
        }
    }

    /**
     * This method clears the ArrayList of questions and resets the quiz.
     */
    private static void resetQuiz() {
        Scanner input = new Scanner(System.in);
        char answer = ' ';

        System.out.print(Constants.PROMPT_FLAG);
        if (input.hasNext()) {
            answer = input.next().charAt(Constants.ELEMENT_INDEX);

            if (answer == 'y') {
                quiz.resetQuiz();
                System.out.print(Constants.QUIZ_CLEARED_PROMPT);
            } else if (answer == 'n') {
                buildMenuSelection = Constants.NO_OPTION_SELECTED;
                System.out.println(Constants.QUIZ_NOT_CLEARED_PROMPT);
            }
        }
    }

    /**
     * This method returns the user to the Main Menu.
     */
    private static void returnToMainMenu() {
        buildMenuSelection = Constants.NO_OPTION_SELECTED;
    }

    /**
     * This method invokes taking the quiz.
     */
    private static void takeQuiz() {
        Scanner input = new Scanner(System.in);
        String answer = "";
        double numericAnswer = 0.0;

        if (quiz.checkForQuiz()) {
            System.out.println(Constants.NO_QUIZ_ERROR);
        } else {
            for (int i = 0; i < quiz.getQuestions().size(); i++) {

                if (quiz.getQuestions().get(i).equals(choiceQuestion)) {
                    System.out.printf(Constants.OPTION_FORMAT, i + 1, quiz.getQuestions().get(i).getQuestion());
                    System.out.print(choiceQuestionOptions.getQuizOptionsDisplayString());
                } else if (quiz.getQuestions().get(i).equals(booleanQuestion)) {
                    System.out.printf(String.format(Constants.OPTION_FORMAT, i + 1, quiz.getQuestions().get(i).getQuestion()));
                    System.out.printf(booleanQuestionOptions.getQuizOptionsDisplayString());
                } else {
                    System.out.printf(String.format(Constants.OPTION_FORMAT, i + 1, quiz.getQuestions().get(i).getQuestion()));
                }

                System.out.print(Constants.REQUEST_ANSWER);

                if (input.hasNextDouble()) {
                    numericAnswer = input.nextDouble();
                    input.nextLine();
                } else if (input.hasNextLine()) {
                    answer = input.nextLine();
                }

                quiz.getQuestions().get(i).setUnverifiedAnswer(answer, numericAnswer);
                System.out.print(quiz.getQuestions().get(i).checkForAnswer());
            }
            System.out.print(quiz.quizResults());
        }

    }

    /**
     * This method quits the program.
     */
    private static void quit() {
        System.out.print(Constants.NEW_LINE + Constants.GOODBYE + Constants.NEW_LINE);
    }

}
