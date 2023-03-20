Version 0.1 - Combat Update:
    3/20/2023
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
