/*
 * Copyright Yiqi Liu
 * 
 */
package hom2.gamelogic;

import hom2.GameSettings;
import hom2.gamelogic.Characters.DragonKnight;
import hom2.gamelogic.Characters.Warrior;
import hom2.gamelogic.Characters.GameCharacter;

/**
 *
 * @author Alex
 */
public class CharacterFactory {

    protected CharacterRepository characterRepo;

    public CharacterFactory(GameController gc) {
        this.characterRepo = gc.getCharacterRepo();
    }

    public GameCharacter makeCharacter(GameCharacter.CharacterType type) {
        GameCharacter characterToAdd = null;
        GameCharacter addedCharacter;
        if (type == GameCharacter.CharacterType.WARRIOR) {
            characterToAdd = new Warrior();
        } else if (type == GameCharacter.CharacterType.DRAGON_KNIGHT) {
            characterToAdd = new DragonKnight();
        }

        if (characterToAdd == null) {
            return null;
        } else {
            // Add the character to repo, which will assign an id to the character
            addedCharacter = this.characterRepo.add(characterToAdd);
            return addedCharacter;
        }

    }

}
