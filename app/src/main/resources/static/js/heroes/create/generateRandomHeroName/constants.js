const heroNameCharacters = {
    getLetters: () => {
        return [
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        ];
    },
    getConsonant: () => {
        return [
            'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'
        ];
    }, 
    getVowels: () => {
        return ['a', 'e', 'i', 'o', 'u'];
    }
};

export { heroNameCharacters };