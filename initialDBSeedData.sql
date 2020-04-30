INSERT INTO armor_types (name) values ('Cloth');
INSERT INTO armor_types (name) values ('Leather');
INSERT INTO armor_types (name) values ('Mail');

INSERT INTO attributes (name, description) VALUES ('strength', 'A measure of how physically strong a character is.');
INSERT INTO attributes (name, description) VALUES ('agility', 'A measure of how agile a character is.');
INSERT INTO attributes (name, description) VALUES ('stamina', 'A measure of how life a character has.');
INSERT INTO attributes (name, description) VALUES ('intellect', 'A measure of a character''s resource resource generetor(mana, fury, discipline)');
INSERT INTO attributes (name, description) VALUES ('spirit', 'A measure of character''s resource and health generation.');
INSERT INTO attributes (name, description) VALUES ('defence', 'A measure of character''s reduced damage from physical attacks');
INSERT INTO attributes (name, description) VALUES ('attack', 'A measure to inflict damage');

INSERT INTO avaiable_character_types (name) VALUES ('Player');
INSERT INTO avaiable_character_types (name) VALUES ('Non-playable');

INSERT INTO classes (name, image_url, overview) 
VALUES (
	'Barbarian', 
    'https://res.cloudinary.com/emicha/image/upload/v1586441725/DevilsQuest/heroes/create/barbarian_wdmfpi.jpg',
	'Barbarians are savage wanderers who never flinch from close-quarters combat. Mighty ground stomps, leaping attacks and dual-wielded slashes leave a barbarian’s enemies dead in their boots and send any survivors fleeing for cover.Thanks to their size and strength, barbarians can dominate a melee with nearly any combination of weapon and approach, though they tend towards massive and imposing weaponry. Barbarians are no strangers to the pains of battle, and often fare better in the midst of several opponents, taking and giving cuts, than when attempting to chase down single targets.Barbarians’ attacks are primarily melee focused. Their quick weapon swings whittle down the number of weaker foes in seconds, while their slower, ground-shaking slams and stomps can send approaching hordes reeling and crack the armor of mightier foes.');
INSERT INTO classes (name, image_url, overview) 
VALUES (
	'Crusader',
	'https://res.cloudinary.com/emicha/image/upload/v1586441771/DevilsQuest/heroes/create/crusader_awkxxv.jpg',
	'Crusaders are unbending champions of faith and law. These living fortresses use impenetrable plate and towering shields to wade through scores of foes, leaving demonic bodies smoldering in their wake.The thick of battle is unforgiving, but crusaders rush in without hesitation, relying on holy magic and heavy armor to guarantee victory. Well-trained crusaders are adept at deflecting attacks entirely, often shrugging off massive blows that would fell lesser combatants. If pressed, they can sacrifice speed and mobility for pure staying power.Bone-crunching flails and wicked shields are perfect for melee, but crusaders are hardly limited to extinguishing evil at close range. When one of these divinely empowered warriors joins battle, blazing fire and blinding light follow, smiting entire packs of enemies who dare to resist judgment.');
INSERT INTO classes (name, image_url, overview) 
VALUES (
	'Demon Hunter',
	'https://res.cloudinary.com/emicha/image/upload/v1586441818/DevilsQuest/heroes/create/demon_hunter_yaxkz3.jpg', 
	'Demon hunters are relentless vigilantes who execute their infernal targets with an arsenal of ranged weapons. They crouch and take aim far from danger, relying on bows, deadly traps, and projectiles to swiftly bring an end to the creatures that haunt their world.With sweeping blasts of shot, wide salvos of arrows and timed explosives at their disposal, demon hunters excel at devastating groups of foes who cluster together. Hunters’ pinpoint accuracy also allows them to deal with stronger monsters at a distance: they can snipe at key targets or fall back while snapping off kill shots at advancing foes.However, demon hunters’ focus on ranged combat and limited melee-weapons training leave them in danger when they’re cornered or surrounded. Evasive skills like defensive rolls and jumps, as well as targeted attacks that hamstring and slow enemies, are as crucial to survival as any arrow in a hunter’s quiver.');
INSERT INTO classes (name, image_url, overview) 
VALUES (
	'Monk',
    'https://res.cloudinary.com/emicha/image/upload/v1586441856/DevilsQuest/heroes/create/monk_p4uajf.jpg',
    'Monks are sacred warriors who channel divine power through sheer force of will. Healing waves, mantras of protection and attacks empowered with holy might are all within their purview.Skilled monks deliver rapid-fire attacks unarmed or with a variety of well-balanced weapons. In combat, they emphasize high maneuverability over staying power, darting in and out of melees and avoiding protracted slugfests.Monks’ attacks are primarily melee-focused. They can eliminate single foes with extreme damage, or deliver short-range area-of-effect assaults with waves of elemental power that emanate from palm strikes or crescent kicks.'
);
INSERT INTO classes (name, image_url, overview) 
VALUES (
	'Wizard',
    'https://res.cloudinary.com/emicha/image/upload/v1586441894/DevilsQuest/heroes/create/wizard_soinle.jpg',
    'Wizards are renegade spellcasters who use their bodies as vessels for arcane energy, forsaking the more careful path favored by other magic users. They manipulate all manner of forces to disintegrate, burn, and freeze their foes, and they can control time and light to teleport, create powerful illusions, and deflect oncoming attacks.Wizards grip wands and staves to focus their less potent magics, blasting at their enemies while gathering the energy or time necessary to destroy them in a dazzling hail of arcane might.With few exceptions, wizard attacks are conducted at a distance, away from danger. As living artillery, wizards are well suited to relying on long-range destructive power.'
);
INSERT INTO classes (name, image_url, overview) 
VALUES (
	'Witch Doctor',
    'https://res.cloudinary.com/emicha/image/upload/v1586441938/DevilsQuest/heroes/create/witch_doctor_drh2dt.jpg',
    'Witch doctors are spiritual warriors who summon dead souls and crawling creatures to do their bidding. By surrounding themselves with conjured zombies and vermin, witch doctors are free to assault their enemies with exploding skulls, acrid poison clouds, and wasting curses.The ability to infect, slow and terrify their enemies gives witch doctors unprecedented control over a battlefield. They can manipulate opposing attacks and movements with debuffs and crowd control spells, rendering enemies easy prey for hungry pets. Witch doctors can also lay down fields of fire and venom that slowly leech life from advancing foes.Although some witch doctors avoid melee combat in favor of augmenting their pets and crippling their enemies from afar, they are also more than capable of slaying weakened foes with their own hands.'
);

INSERT INTO factions (name) VALUES ('Alliance');
INSERT INTO factions (name) VALUES ('Horde');

INSERT INTO genders (name) VALUES ('Male');
INSERT INTO genders (name) VALUES ('Female');

INSERT INTO races (name) VALUES ('Human');
INSERT INTO races (name) VALUES ('Orc');
INSERT INTO races (name) VALUES ('Troll');
INSERT INTO races (name) VALUES ('Dwarf');
INSERT INTO races (name) VALUES ('Night Elf');
INSERT INTO races (name) VALUES ('Undead');

INSERT INTO resource_generators (name) VALUES ('Fury');
INSERT INTO resource_generators (name) VALUES ('Spirit');
INSERT INTO resource_generators (name) VALUES ('Wrath');
INSERT INTO resource_generators (name) VALUES ('Discipline');
INSERT INTO resource_generators (name) VALUES ('Mana');