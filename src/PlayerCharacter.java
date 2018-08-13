public class PlayerCharacter {

    public static void main(String[] args) {


        CharacterCreator patrick = new CharacterCreator("Patrick", "Vespertine", Race.HUMAN_VARIANT);
        patrick.displayInfo();
        patrick.determineAS();
        patrick.racialASIncrease();


        System.out.println("\n\nEND OF THE PROGRAM");

    }
}
