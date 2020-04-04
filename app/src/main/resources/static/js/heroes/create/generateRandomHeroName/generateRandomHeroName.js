import { heroNameCharacters } from "/js/heroes/create/generateRandomHeroName/constants.js";

function generateRandomHeroName(heroNameLenght) {
    let name = [];
    let selected;

    for (let i = 0; i < heroNameLenght; i++)
    {
        selected = Math.floor(Math.random() * 26);

        if (name.length > 2)
        {
            let lastLetter = name.length - 1;
            let penultLetter = name.length - 2;

            // If the last two letters are equal, the next one should be different.
            while (name[lastLetter] == selected && name[penultLetter] == selected)
                selected = Math.floor(Math.random() * 26);

            // If the last two letters are consonants, the next one must be a vowel.
            if (heroNameCharacters.getConsonant().indexOf(name[lastLetter]) != -1 && heroNameCharacters.getConsonant().indexOf(name[penultLetter]) != -1)
            {
                selected = Math.floor(Math.random() * 5);
                name[i] = heroNameCharacters.getVowels()[selected];
                continue;
            }
        }
        else
        {
            // If the first letter is a vowel, the second must be a consonant, and vice versa.
            if (heroNameCharacters.getVowels().indexOf(name[0]) != -1)
            {
                selected = Math.floor(Math.random() * 21);
                name[i] = heroNameCharacters.getConsonant()[selected];
                continue;
            }
            else if (heroNameCharacters.getConsonant().indexOf(name[0]) != -1)
            {
                selected = Math.floor(Math.random() * 5);
                name[i] = heroNameCharacters.getVowels()[selected];
                continue;
            }
        }

        name[i] = heroNameCharacters.getLetters()[selected];
    }

    // Name must not finish with two consonants.
    if (heroNameCharacters.getConsonant().indexOf(name[name.length - 1]) != -1 && heroNameCharacters.getConsonant().indexOf(name[name.length - 2]) != -1)
    {
        selected = Math.floor(Math.random() * 5);
        name[name.length - 1] = heroNameCharacters.getVowels()[selected];
    }

    // Converts the array into a string.
    name = name.join('');

    // Capitalizes the first letter .
    name = name.substr(0, 1).toUpperCase() + name.substr(1);

    // Prints the generated name.
    $("#name").val(name);
}

export { generateRandomHeroName };