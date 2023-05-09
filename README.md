Version 0.1 - Combat Update (3/20/2023):

    In version 0.1, implementing a working version of the combat simulation that takes in stats from both the enemy and the player, player input, and returns a responsive UI was the main focus. There are currently 4 enemy types that work:

        Worker Bot - standard mechanic servant that are now hostile
        Steam Golem - a heavyduty worker used to lift and move heavy objects
        Iron Ant - a mysterious metallic robot based off of rare ant species
        Rock - rock
    
    The player stats are currently a placeholder and will continue to be a placeholder until a player creation system is implemented and allows the user to create and modify their character and their stats in the beginning of the game. Right now, the combat works for one encounter only. The system picks a random enemy for the user to fight. The user is able to pick from a variety of options:

        LIGHT - a simple light attack
        HEAVY - stronger version of the light attack but with a higher chance of missing
        PET - uses the pet ability; CURRENTLY NOT IMPLEMENTED
        FLEE - chance to flee the encounter
        INVENTORY - opens up the inventory and allows the user to change items; CURRENTLY NOT IMPLEMENTED

    The user is able to run the combat implementation by going to the 'Combat' file. This is where the main() method is. Simply run the main() method (run the file) and follow the prompts that are given. To reset, stop the program and rerun it.

Version 0.2 - Combat UI Update (4/16/2023):

    In version 0.2, the UI screen for the combat has been implemented. Similarly to version 0.1, the system picks a random enemy that you will fight against. In this current iteration, the user is only able to finish one combat sequence. The player can choose from either from the 5 options (light attack, heavy attack, flee, pet, and inventory). Currently, only light and heavy attack are fully implemented. 

    The player and enemy stats do update in real-time and the player can see the hit damage of both parties. After winning the fight, the player will also gain experience and gears that can be used in later updates.

    In future updates, we plan on adding in the pets and inventory system. The flee implementation and finishing the fight will both lead to a new menu that will allow the player to start another fight. We also plan on adding in more UI (animations, pictures, music, and a more user-friendly interface). Though we will focus more on the pets and inventory system, the main menus, and a robust leveling system.

Version 1 - Alpha Release (5/9/2023):

    A fully working UI screen is now implemented. The goal of the game has shifted from a story-oriented rpg game to a steampunk-esque rogue-like game. It features a total of 10 enemies that have random stats and grow stronger as you grow stronger. Each enemy is unique and its own special ability. A shop and inventory feature are also working and allows the players to buy infinite amount of each items, if they have enough gears. These 9 items offer different buffs affecting damage, health, defense, and gear gain bonuses.

    To play the game, all the user has to do is click on the buttons they want and the corresponding action will happen. The combat actions now include light attack, heavy attack, inventory, and flee. Pets have been removed from the game. 

    Due to time constraints and limitations, some functionalities have a weird implementation. Since it was causing issues saving information and restoring it when recreating the activity during combat, we changed it so everytime someone rotates the screen, it would manually recreate the combat activity with the correct information, rather than automatically doing it with bundles. This method has not been implemented to both the inventory and workshop screen because it didn't pose a big issue with the functionality. The workshop and inventory screen may receive a fix in later updates that maintains information between switching screen orientations.

    Item and enemy scaling has yet to be tested thoroughly. Scaling may make the user too powerful or too weak at certain times. The randomness in enemy and their stats may also cause a drastic change in power balance.

    Music is also another feature that is planned to be added in. Some text UI changes were also planned to make certain text (ie "CLICK TO CONTINUE") pop out, but the severity of this is low compared to getting the functionality of the app working.

    The game is currently done using multiple activities so switching between sections is not the smoothest, as compared to using fragments. 
