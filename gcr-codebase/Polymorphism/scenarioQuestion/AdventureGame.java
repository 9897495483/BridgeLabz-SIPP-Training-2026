// File Name: AdventureGame.java

// Superclass
class GameCharacter {

    String characterName;

    GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    void performAttack() {
        System.out.println(characterName + " attacks.");
    }
}

// Warrior Class
class Warrior extends GameCharacter {

    Warrior(String characterName) {
        super(characterName);
    }

    @Override
    void performAttack() {
        System.out.println(characterName + " attacks with a Sword!");
    }
}

// Mage Class
class Mage extends GameCharacter {

    Mage(String characterName) {
        super(characterName);
    }

    @Override
    void performAttack() {
        System.out.println(characterName + " casts a Fireball!");
    }
}

// Archer Class
class Archer extends GameCharacter {

    Archer(String characterName) {
        super(characterName);
    }

    @Override
    void performAttack() {
        System.out.println(characterName + " shoots an Arrow!");
    }
}

// Main Class
public class AdventureGame {

    // Method to start battle
    public static void startBattle(GameCharacter[] characters) {

        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        System.out.println("===== Battle Begins =====\n");

        for (GameCharacter character : characters) {

            // Dynamic Method Dispatch
            character.performAttack();

            // Count character types
            if (character instanceof Warrior)
                warriorCount++;

            else if (character instanceof Mage)
                mageCount++;

            else if (character instanceof Archer)
                archerCount++;
        }

        System.out.println("\n===== Battle Summary =====");
        System.out.println("Warriors : " + warriorCount);
        System.out.println("Mages    : " + mageCount);
        System.out.println("Archers  : " + archerCount);
    }

    public static void main(String[] args) {

        // Array of superclass references
        GameCharacter[] characters = {
                new Warrior("Thor"),
                new Mage("Merlin"),
                new Archer("Robin"),
                new Warrior("Kratos"),
                new Mage("Gandalf"),
                new Archer("Legolas")
        };

        startBattle(characters);
    }
}