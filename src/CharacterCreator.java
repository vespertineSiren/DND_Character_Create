import java.util.*;
import java.util.Scanner;

/*

TODO
Convert the array into ArrayList
1. public void determineAS()
2. private void computerASRolls()

RacialTraits
3. Finish method to determine that.
4. Add racial modifies to change abilityScore hashmap.


 */


public class CharacterCreator {

    private String playerName;
    private String  characterName;
    Race characterRace;
    private Scanner userInput = new Scanner(System.in);

    private LinkedHashMap<String, Integer> abilityScore = new LinkedHashMap<>();
    //private LinkedHashMap<String, String> racialTraits = new LinkedHashMap<>();

    CharacterCreator(String name, String pcName, Race race){
        this.playerName = name;
        this.characterName = pcName;
        this.characterRace = race;

    }

    private void determineRacialMods(){
        switch (characterRace) {
            case DWARF_HILL:

                break;
            case DWARF_MOUNTAIN:

                break;
            case ELF_HIGH:

                break;
            case ELF_WOOD:

                break;
            case ELF_DARK:

                break;
            case HALFLING_LIGHTFOOT:

                break;
            case HALFLING_STOUT:

                break;
            case HUMAN:

                break;
            case HUMAN_VARIANT:

                break;
            case DRAGONBORN:

                break;
            case GNOME_FOREST:

                break;
            case GNOME_ROCK:

                break;
            case HALF_ELF:

                break;
            case HALF_ORC:

                break;
            case TIEFLING:

                break;
        }
    }

    public void determineAS(){

        Integer[] highestASvalues = new Integer[6];
        Integer rollValue;
        Scanner userInput = new Scanner(System.in);

        System.out.println("\nDo you want the computer to roll for you?" +
                "\nEnter 0 for computer rolls. " +
                "\nAny other number will be personal dice rolls.");
        int userChoice = this.userInput.nextInt();

        if (userChoice == 0) {

            computerASRolls();
        } else {
            for (int i = 0; i < highestASvalues.length; i++){

               do {
                   System.out.println("Input Highest AS Roll #" + (i +1) + ": ");
                   rollValue = userInput.nextInt();
               } while (rollValue <= 0 || rollValue > 18);

               highestASvalues[i] = rollValue;

            }




            Arrays.sort(highestASvalues, Collections.reverseOrder());
            System.out.println("\nValues for  personal dice rolls");
            System.out.println(Arrays.toString(highestASvalues));
            assignRollstoAS(highestASvalues);

        }
    }

    private void computerASRolls(){

        Integer[] rollArray = new Integer[4];
        Integer[] highestASvalues = new Integer[6];
        int rollValue;
        Random roll = new Random();

        for (int i = 0; i < highestASvalues.length; i++){

            System.out.println("Rolling for AS #" + (i + 1));

            for (int j = 0; j < rollArray.length; j++) {
                rollValue = (roll.nextInt(6)) + 1;
                //System.out.println("    Roll #" + (j + 1) + " : " + rollValue );
                rollArray[j] = rollValue;
            }
            Arrays.sort(rollArray, Collections.reverseOrder());
            System.out.println("Current Values from the Last Roll:");
            System.out.println(Arrays.toString(rollArray));

            highestASvalues[i] = rollArray[0] + rollArray[1] + rollArray[2];
            System.out.println("The three highest values = " + highestASvalues[i] + "\n");
        }

        System.out.println("Final Highest Values:");
        System.out.println(Arrays.toString(highestASvalues));

        assignRollstoAS(highestASvalues);


    }


    private void assignRollstoAS(Integer[] rolls) {
        int rollIndex = 0;
        //  userInput = new Scanner(System.in);
        int userChoice;
        Integer currentAS;

        this.abilityScore.put("Strength", 0);
        this.abilityScore.put("Dexterity", 0);
        this.abilityScore.put("Constitution", 0);
        this.abilityScore.put("Intelligence", 0);
        this.abilityScore.put("Wisdom", 0);
        this.abilityScore.put("Charisma", 0);

        while (rollIndex != 6){
            System.out.println("\nAssigning ["+ rolls[rollIndex] + "] to Ability Score" +
                    "\nAbility Score Summary:" +
                    "\n"        + abilityScore +
                    "\n     Select which score to alter: " +
                    "\n         1. Strength" +
                    "\n         2. Dexterity" +
                    "\n         3. Constitution" +
                    "\n         4. Intelligence" +
                    "\n         5. Wisdom" +
                    "\n         6. Charisma");
            userChoice = this.userInput.nextInt();

            switch (userChoice) {
                case 1:
                    currentAS = abilityScore.get("Strength");
                    if (currentAS == 0) {

                        this.abilityScore.merge("Strength", rolls[rollIndex], Integer::sum);
                        rollIndex++;

                        break;
                    } else{
                        System.out.println("         Already Assigned a Value\n");
                    }
                    break;
                case 2:
                    if (abilityScore.get("Dexterity") == 0) {

                        this.abilityScore.merge("Dexterity", rolls[rollIndex], Integer::sum);
                        rollIndex++;

                        break;
                    } else {
                        System.out.println("         Already Assigned a Value\n");
                    }
                    break;
                case 3:
                    if (abilityScore.get("Constitution") == 0) {

                        this.abilityScore.merge("Constitution", rolls[rollIndex], Integer::sum);
                        rollIndex++;

                        break;
                    } else {
                        System.out.println("         Already Assigned a Value\n");
                    }
                    break;
                case 4:
                    if (abilityScore.get("Intelligence") == 0) {

                        this.abilityScore.merge("Intelligence", rolls[rollIndex], Integer::sum);
                        rollIndex++;

                        break;
                    } else {
                        System.out.println("         Already Assigned a Value\n");
                    }
                    break;
                case 5:
                    if (abilityScore.get("Wisdom") == 0) {

                        this.abilityScore.merge("Wisdom", rolls[rollIndex], Integer::sum);
                        rollIndex++;

                        break;
                    } else {
                        System.out.println("         Already Assigned a Value\n");
                    }
                    break;
                case 6:
                    if (abilityScore.get("Charisma") == 0) {

                        this.abilityScore.merge("Charisma", rolls[rollIndex], Integer::sum);
                        rollIndex++;

                        break;
                    } else {
                        System.out.println("         Already Assigned a Value\n");
                    }
                    break;
                default:
                    System.out.println("\n         NOT A VALID OPTION\n");
            }
        }

        System.out.println("\nCompleted Ability Score Summary:" +
                "\n"        + abilityScore);
    }

    public void racialASIncrease(){

        switch (this.characterRace){
            case DWARF_HILL:

                System.out.println("\nHill Dwarf:" +
                        "\n     +2 Constitution" +
                        "\n     +1 Wisdom");
                this.abilityScore.merge("Constitution", 2, Integer::sum);
                this.abilityScore.merge("Wisdom", 1, Integer::sum);

                break;
            case DWARF_MOUNTAIN:

                System.out.println("\nMountain Dwarf:" +
                        "\n     +2 Constitution" +
                        "\n     +2 Strength");
                this.abilityScore.merge("Constitution", 2, Integer::sum);
                this.abilityScore.merge("Strength", 2, Integer::sum);

                break;
            case ELF_HIGH:

                System.out.println("\nHigh Elf:" +
                        "\n     +2 Dexterity" +
                        "\n     +1 Intelligence");
                this.abilityScore.merge("Dexterity", 2, Integer::sum);
                this.abilityScore.merge("Intelligence", 1, Integer::sum);

                break;
            case ELF_WOOD:

                System.out.println("\nWood Elf:" +
                        "\n     +2 Dexterity " +
                        "\n     +1 Wisdom ");
                this.abilityScore.merge("Dexterity", 2, Integer::sum);
                this.abilityScore.merge("Wisdom", 1, Integer::sum);

                break;
            case ELF_DARK:

                System.out.println("\n Dark Elf:" +
                        "\n     +2 Dexterity " +
                        "\n     +1 Charisma");
                this.abilityScore.merge("Dexterity", 2, Integer::sum);
                this.abilityScore.merge("Charisma", 1, Integer::sum);

                break;
            case HALFLING_LIGHTFOOT:

                System.out.println("\n Lightfoot Halfling:" +
                        "\n     +2 Dexterity " +
                        "\n     +1 Charisma ");
                this.abilityScore.merge("Dexterity", 2, Integer::sum);
                this.abilityScore.merge("Charisma", 1, Integer::sum);

                break;
            case HALFLING_STOUT:

                System.out.println("\n Stout Halfling:" +
                        "\n     +2 Dexterity" +
                        "\n     +1 Constitution");
                this.abilityScore.merge("Dexterity", 2, Integer::sum);
                this.abilityScore.merge("Constitution", 1, Integer::sum);

                break;
            case HUMAN:

                System.out.println("\nHuman: " +
                        "\n     +1 to all Ability Scores ");
                this.abilityScore.merge("Strength", 1, Integer::sum);
                this.abilityScore.merge("Dexterity", 1, Integer::sum);
                this.abilityScore.merge("Constitution", 1, Integer::sum);
                this.abilityScore.merge("Intelligence", 1, Integer::sum);
                this.abilityScore.merge("Wisdom", 1, Integer::sum);
                this.abilityScore.merge("Charisma", 1, Integer::sum);

                break;
            case HUMAN_VARIANT:

                System.out.println("\nHuman Variant: " +
                        "\n     +1 to two different ability scores of your choice");
                choiceRacialASImprovement(2);

                break;
            case DRAGONBORN:

                System.out.println("\nDragonborn:" +
                        "\n     +2 Strength " +
                        "\n     +1 Charisma ");
                this.abilityScore.merge("Strength", 2, Integer::sum);
                this.abilityScore.merge("Charisma", 1, Integer::sum);

                break;
            case GNOME_FOREST:

                System.out.println("\nForest Gnome:" +
                        "\n     +2 Intelligence " +
                        "\n     +1 Dexterity ");
                this.abilityScore.merge("Intelligence", 2, Integer::sum);
                this.abilityScore.merge("Dexterity", 1, Integer::sum);

                break;
            case GNOME_ROCK:

                System.out.println("\nRock Gnome:" +
                        "\n     +2 Intelligence" +
                        "\n     +1 Constitution ");
                this.abilityScore.merge("Intelligence", 2, Integer::sum);
                this.abilityScore.merge("Constitution", 2, Integer::sum);

                break;
            case HALF_ELF:

                System.out.println("\nHalf Elf:" +
                        "\n     +2 Charisma" +
                        "\n     +1 to Ability Score of your choosing");
                this.abilityScore.merge("Dexterity", 2, Integer::sum);


                break;
            case HALF_ORC:

                System.out.println("\nHalf-Orc:" +
                        "\n     +2 Strength " +
                        "\n     +1 Constitution");
                this.abilityScore.merge("Dexterity", 2, Integer::sum);
                this.abilityScore.merge("Intelligence", 1, Integer::sum);

                break;
            case TIEFLING:

                System.out.println("\nTiefling:" +
                        "\n     +1 Intelligence" +
                        "\n     +2 Charisma");
                this.abilityScore.merge("Charisma", 2, Integer::sum);
                this.abilityScore.merge("Intelligence", 1, Integer::sum);

                break;
        }

        System.out.println("Completed Racial AS Increase Score Summary:" +
                "\n"        + abilityScore);
    }

    private void choiceRacialASImprovement(Integer extraPoint) {

        String previousASImprovement = "Nothing";
        int userChoice;

        if (this.characterRace == Race.HUMAN_VARIANT) {
            while (extraPoint != 0) {
                System.out.println("\nIncreasing two different Ability Scores by one" +
                        "\n     Select which score to alter: " +
                        "\n         1. Strength" +
                        "\n         2. Dexterity" +
                        "\n         3. Constitution" +
                        "\n         4. Intelligence" +
                        "\n         5. Wisdom" +
                        "\n         6. Charisma");
                userChoice = this.userInput.nextInt();

                switch (userChoice) {
                    case 1:
                        if (!previousASImprovement.equals("Strength")) {
                            this.abilityScore.merge("Strength", 1, Integer::sum);
                            previousASImprovement = "Strength";
                            extraPoint--;
                        } else {
                            System.out.println("Pick a different AS to improve");
                        }

                        break;
                    case 2:
                        if (!previousASImprovement.equals("Dexterity")) {
                            this.abilityScore.merge("Dexterity", 1, Integer::sum);
                            previousASImprovement = "Dexterity";
                            extraPoint--;
                        } else {
                            System.out.println("Pick a different AS to improve");
                        }
                        break;
                    case 3:
                        if (!previousASImprovement.equals("Constitution")) {
                            this.abilityScore.merge("Constitution", 1, Integer::sum);
                            previousASImprovement = "Constitution";
                            extraPoint--;
                        } else {
                            System.out.println("Pick a different AS to improve");
                        }
                        break;
                    case 4:
                        if (!previousASImprovement.equals("Intelligence")) {
                            this.abilityScore.merge("Intelligence", 1, Integer::sum);
                            previousASImprovement = "Intelligence";
                            extraPoint--;
                        } else {
                            System.out.println("Pick a different AS to improve");
                        }
                        break;
                    case 5:
                        if (!previousASImprovement.equals("Wisdom")) {
                            this.abilityScore.merge("Wisdom", 1, Integer::sum);
                            previousASImprovement = "Wisdom";
                            extraPoint--;
                        } else {
                            System.out.println("Pick a different AS to improve");
                        }
                        break;
                    case 6:
                        if (!previousASImprovement.equals("Charisma")) {
                            this.abilityScore.merge("Charisma", 1, Integer::sum);
                            previousASImprovement = "Charisma";
                            extraPoint--;
                        } else {
                            System.out.println("Pick a different AS to improve");
                        }
                        break;
                    default:
                        System.out.println("\n         NOT A VALID OPTION\n");
                }
            }
        } else {
            while (extraPoint != 0) {
                System.out.println("\nIncreasing two different Ability Scores by one" +
                        "\n     Select which score to alter: " +
                        "\n         1. Strength" +
                        "\n         2. Dexterity" +
                        "\n         3. Constitution" +
                        "\n         4. Intelligence" +
                        "\n         5. Wisdom" +
                        "\n         6. Charisma");
                userChoice = this.userInput.nextInt();

                switch (userChoice) {
                    case 1:
                        this.abilityScore.merge("Strength", 1, Integer::sum);
                        extraPoint--;
                        break;
                    case 2:
                        this.abilityScore.merge("Dexterity", 1, Integer::sum);
                        extraPoint--;
                        break;
                    case 3:
                        this.abilityScore.merge("Constitution", 1, Integer::sum);
                        extraPoint--;
                        break;
                    case 4:
                        this.abilityScore.merge("Intelligence", 1, Integer::sum);
                        extraPoint--;
                        break;
                    case 5:
                        this.abilityScore.merge("Wisdom", 1, Integer::sum);
                        extraPoint--;
                        break;
                    case 6:
                        this.abilityScore.merge("Charisma", 1, Integer::sum);
                        extraPoint--;
                        break;
                    default:
                        System.out.println("\n         NOT A VALID OPTION\n");
                }
            }
        }
    }

    public void displayInfo(){
        System.out.println("This is your name: " + playerName);
        System.out.println("This is your character name: " + characterName);
        System.out.println("This is your race: " + characterRace);

    }
}


