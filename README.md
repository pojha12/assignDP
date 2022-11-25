# assignDP

Screencast: https://youtu.be/1GP6KqJdkPg 

Singleton: only one world(game) gets created
    - Each Cycle (Round) should have its own weather event
    - Trainer can acquire more code-a-mons (max of 6) throughout their adventure
    - The simulation should run on cycles and a cycle is considered to be of 2 parts-1 day time and 1       night time
    - A New world (game) must start with a number of trainers, at least 2, and each of them starts with at least one code-a-mon

Factory: Create code-a-mons because they all are similar so the same functions can be used
    - Code-a-mons gain experience points from winning battles and can level up after earning enough points
    - weather events should benefit certain types of code-a-mon's stats while being a disadvantage to others 
    - Code-a-mons should be of different types and gain advangtages or disadvantages based on their opponent's type
    - Evolutions 
    
Mediator: interactions between everything 
    - Code-a-mons will compete 1v1 with another trainers code-a-mons and only 1 battle at a time
    - Items can be purchased from the store money (potions, boosters)
    - Battles with other trainers (or wild (random) code-a-mons) during the day/night while earning experience points
    - Code-a-mons can heal
    - Can attempt to catch a new Code-a-mon
    - Evolutions of a code-a-mons can occur