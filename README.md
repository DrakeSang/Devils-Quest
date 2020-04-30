# Devils-Quest
It will be a browser game using java, spring, thymeleaf and hibernate with creating heroes, leveling, items, fighting between heroes and monsters. I have many ideas and functionality I want to add so I will continue working on it. In this project I do not use any bootstrap and I write on my own the html, css and the responsive design.

First you need to execute this sql initialDBSeedData to seed your db with initial data like Factions(Horde and Allance), Races(Orc, Troll, Undead, Human, Dwarf, Night Elf), Genders(Male, Female), Classes(Barbarian, Crusader, Demon Hunter, Monk, Wizard, WItch Doctor), etc... You can look at the script it is simple just inserting some initial values in some of my db tables, which you will need.

A little overview of what things i have done so far on my project:

1) I added spring security and csrf token. I tried to wrote comments on my code and methods to explain why i did them like that

2) Added remote saving of my images in cloudinary. There i save the profile pics of the user on registering, the pics of every class, the portraits of the classes, which i will use later.

3) Added the hero creation proces with validation and max count for heroes of each user to be 10.

4) Added tests for each fucntionality, but need to add more on creation process of the hero.

5) Added javascript for my slider on the index page, every faction has specific races(Horde can be Orc, Troll, Unded and Alliance can be Human, Dwarf, Night Elf), every class has specific image and short overview, letting user randomize his hero name.

7) Added filters and interceptors.

6) The links header change dynamaclly. Any normal user can see Login and Register. After logging successfully the user can create hero and logout. If he has at least one hero he can see the profile link to see his heroes and the heroes link, where he can fight only if there are opponents.

The things i am currently workign on and want to add to my project:

1) Finishing my tests for creation process of a hero.

2) On the profile page to show all of his heroes with the items. This view i am not stil sure how to make it exactly. I want to be somethign cool where the user can see all fo his heroes, their items, their stats, some sets of items. On moving the cursor on some item to see a little tooltip with the stats it gives. Also i am thinking to put a button there, which will lead him to anotehr endpoint. There he can see his bags, his gold, sell some items.

3) Adding something Like auction house or npcs, which will buy the items.

4) Adding skills tree for every hero.

5) Fighting between heroes want to make it cool like using spells attacks some animations. After battle the one, who loose wil use durability of his items and when they get to zero he needs to fix them.

6) I want to add to the items how strong they are: legendary, epic, common, rare.

So this is some of the things i want to add and i really want to make this project a good one and make it like a good portfolio showing my skils.