package moreno_quizui;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Menu Class. Solves COP2800 Java Project # 2 COPYRIGHT (C) 2014 Rolando
 * Moreno. All Rights Reserved.
 *
 * @author Rolando Moreno COP 2800
 * @version 1.01 2014-04-13
 */
public class Menu {

    private String title = "";
    private String delimitedOptionList = "";
    private String inDelimeter = "";
    private int userChoice = 0;
    private int validatedUserChoice = 0;
    private int maximumMenuOption = 0;
    private ArrayList<String> menuChoices = new ArrayList<>();

    /**
     * Menu Constructor collects title, delimeter, and string. Also calls
     * loadOptionsFromString method. Adds string to array after and creates a
     * variable collecting size of array.
     *
     * @param title Collects a string title.
     * @param delimitedOptionList Collects a string of menu items
     * @param inDelimeter Delimeter that will separate the string of menu items
     */
    public Menu(String title, String delimitedOptionList, String inDelimeter) {
        this.title = title;
        this.delimitedOptionList = delimitedOptionList;
        this.inDelimeter = inDelimeter;
        loadOptionsFromString();
        if (this.delimitedOptionList.equalsIgnoreCase(Constants.MAIN_MENU_SELECTIONS)) {
            menuChoices.add(Constants.QUIT);
        }
        maximumMenuOption = menuChoices.size();
    }

    /**
     * This method parses the string into an ArrayList.
     */
    private void loadOptionsFromString() {

        StringTokenizer workHorse = new StringTokenizer(delimitedOptionList, inDelimeter);

        while (workHorse.hasMoreTokens()) {
            menuChoices.add(workHorse.nextToken());
        }
    }

    /**
     * This method displays the menu, validates user input, and returns the
     * selection as an integer.
     *
     * @param input Passes the scanner input.
     * @return Returns the menu item selected.
     */
    public int getNextSelection(Scanner input) {
        userChoice = Constants.NO_OPTION_SELECTED;
        do {
            if (userChoice != 0) {
                System.out.printf(Constants.INVALID_INPUT, Constants.MINIMUM_MENU_OPTION, maximumMenuOption);
            }

            System.out.print(getMenuDisplayString());

            if (input.hasNextInt()) {
                userChoice = input.nextInt();
            } else {
                userChoice = Constants.INVALID_SELECTION;
                input.nextLine();
            }
        } while (userChoice < Constants.MINIMUM_MENU_OPTION || userChoice > maximumMenuOption);
        validatedUserChoice = userChoice;
        return validatedUserChoice;
    }

    /**
     * This method displays a menu.
     *
     * @return This returns a string of the prepared menu.
     */
    private String getMenuDisplayString() {
        String returnValue = "";

        returnValue += Constants.DIVIDER;
        returnValue += title + Constants.NEW_LINE;
        returnValue += Constants.DIVIDER;

        for (int i = 0; i < menuChoices.size(); i++) {
            returnValue += String.format(Constants.OPTION_FORMAT, i + 1, menuChoices.get(i));
        }

        returnValue += Constants.DIVIDER;
        returnValue += String.format(Constants.SELECTION_PROMPT_FORMAT, Constants.MINIMUM_MENU_OPTION, maximumMenuOption);

        return returnValue;
    }

    /**
     * This methods prepares the answers of the ChoiceQuestion and
     * BooleanQuestion class.
     *
     * @return This returns a string of the prepared question with options.
     */
    public String getQuizOptionsDisplayString() {
        String returnValue = "";

        returnValue += Constants.NEW_LINE;

        for (int i = 0; i < menuChoices.size(); i++) {
            returnValue += String.format(Constants.QUIZ_OPTION_FORMAT, Constants.LOWER_CASE_ALPHABET.charAt(i), menuChoices.get(i));
        }
        returnValue += Constants.NEW_LINE;
        return returnValue;
    }
}
