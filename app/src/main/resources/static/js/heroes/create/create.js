import { loadRacesByFactionName } from "/js/heroes/create/loadRacesByFactionName/loadRaces.js";
import { loadClassDetails } from "/js/heroes/create/loadClassDetailsByClassName/loadClassDetails.js";
import { generateRandomHeroName } from "/js/heroes/create/generateRandomHeroName/generateRandomHeroName.js";

$(".whichFaction").change(function() {
    let factionName = $(this).val();
    loadRacesByFactionName(factionName);
});

$(".whichClass").change(function() {
    let className = $(this).val();
    loadClassDetails(className);
});

$("#num-chars").change(function() {
    $("#name").val("");
});

$("#randomize-hero-name").on("click", function() {
    // Number of letters of the name to be generated.
    let heroNameLength = $("#num-chars option:selected").val();
    generateRandomHeroName(heroNameLength);
});