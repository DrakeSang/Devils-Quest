function loadRacesByFactionName(factionName) {
    if(factionName != "") {
        $(".whichRace").removeAttr("disabled");
    }

    if($('.whichRace option').length > 1) { 
        $('.whichRace').find('option:not(:first)').remove();
    }
    
    let url = "/api/races/get-races-by-faction/" + factionName;

    fetch(url, {method: 'get'})
        .then(response => response.json())
        .then(races => {
            races.forEach(race => {
                $('.whichRace').append($('<option>', { 
                    value: race,
                    text : race
                }));
            });
    })
}

export { loadRacesByFactionName };