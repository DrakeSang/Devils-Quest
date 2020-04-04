package com.DevilsQuest.app.config.mapper;

import com.DevilsQuest.app.data.entities.heroes.HeroClass;
import com.DevilsQuest.app.data.enums.CharacterClass;
import com.DevilsQuest.app.data.enums.FactionName;
import com.DevilsQuest.app.data.enums.GenderName;
import com.DevilsQuest.app.data.enums.RaceName;
import com.DevilsQuest.app.data.models.services.heroes.HeroCreateServiceModel;
import com.DevilsQuest.app.data.models.views.heroes.HeroCreateViewModel;
import com.DevilsQuest.app.web.api.models.classes.HeroClassResponseModel;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    private ModelMapper modelMapper;

    public ModelMapperConfig(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        initMapper();
    }

    private void initMapper() {
        /**
         * Create a TypeMap for your mappings from one model to another model.
         */
        TypeMap<HeroClass, HeroClassResponseModel> createHeroProcessClassMap = modelMapper.createTypeMap
            (HeroClass.class, HeroClassResponseModel.class);
        
        TypeMap<HeroCreateViewModel, HeroCreateServiceModel> createHeroProcessMap = modelMapper.createTypeMap
            (HeroCreateViewModel.class, HeroCreateServiceModel.class);

        /** Convertors */
        Converter<String, FactionName> stringToFactionNameConverter = 
            ctx -> FactionName.valueOf(ctx.getSource().toUpperCase());
        
        Converter<String, RaceName> stringToRaceNameConverter = 
            ctx -> RaceName.valueOf(transform(ctx.getSource()));

        Converter<String, GenderName> stringToGenderNameConverter = 
            ctx -> GenderName.valueOf(ctx.getSource().toUpperCase());
        
        Converter<String, CharacterClass> stringToCharacterClassConverter = 
            ctx -> CharacterClass.valueOf(transform(ctx.getSource()));

        /**
         * Define the mappings on the type map. I need it when i map from object of type {@link HeroClass} to 
         * object of type {@link HeroClassResponseModel}. When user creates a hero i need to get the specific
         * pic and story of the class, which user choosed. The response model keeps the pic and story as strings
         * and i can easily show them dynamically with js. When i need to map from one model to another model the 
         * modelmapper uses this configuration. It says to map source getter value to destination setter.
         * So the source getter for the imageUrl is from the HeroClass entity and then call the setter for the 
         * image url of the HeroResponseModel to set it with the value you got from the getter of the imageUrl 
         * from the HeroClass. Tha same logic goes for the overview of the hero class.
         */
        createHeroProcessClassMap.addMappings(mapper -> {
            mapper.map(
                HeroClass::getImageUrl,
                HeroClassResponseModel::setImageUrl
            );
            mapper.map(
                HeroClass::getOverview,
                HeroClassResponseModel::setOverview
            );
        });

        createHeroProcessMap.addMappings(mapper -> {
            mapper
                .using(stringToFactionNameConverter)
                .map(
                    HeroCreateViewModel :: getFaction,
                    HeroCreateServiceModel :: setFaction
                );
            mapper
                .using(stringToRaceNameConverter)
                .map(
                    HeroCreateViewModel :: getRace,
                    HeroCreateServiceModel :: setRace
                );
            mapper
                .using(stringToGenderNameConverter)
                .map(
                    HeroCreateViewModel :: getGender,
                    HeroCreateServiceModel :: setGender
                );
            mapper
                .using(stringToCharacterClassConverter)
                .map(
                    HeroCreateViewModel :: getCharacterClass,
                    HeroCreateServiceModel :: setCharacterClass
                );
        });
    }

    /**
     * Method to transform different names. I use it when i want user is creating a hero. So when he creates a 
     * hero the value, which i receive from the post for lets say race or class i need to change it to my enum
     * values. Lets say he choosed Human. In this case it easy i need only to get the value from the source and 
     * make it to upper case(Human -> HUMAN) and it will be mapped correctly in my enum {@link RaceName}. We 
     * need to think about the another case if he choose Night Elf and i make it to uppercase NIGHT ELF the mapper
     * will throw error because i do not have such enum in {@link RaceName}. I need to make it uppercase and add
     * underscore and that is why i check if the vaalue has space to add the underscore otherwise only make it 
     * uppercase and nothing more. The same logic goes for character class object of type {@link CharacterClass}.
     * I receive Demon Hunter choosed by the user, but i need to make it to DEMON_HUNTER to map my enum value.
     * 
     * @param value the value to be transformed
     * @return the new string depending on what value the methods received
     */
    private String transform(String value) {
        if(value.contains(" ")) {
            int emptySpaceIndex = value.indexOf(" ");
            String leftPart = value.substring(0, emptySpaceIndex);
            String rightPart = value.substring(emptySpaceIndex + 1, value.length());

            return leftPart.toUpperCase() + "_" + rightPart.toUpperCase();
        } else {
            return value.toUpperCase();
        }
    }
}