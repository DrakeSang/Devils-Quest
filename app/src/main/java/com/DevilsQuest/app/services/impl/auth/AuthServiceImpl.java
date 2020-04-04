package com.DevilsQuest.app.services.impl.auth;

import java.io.IOException;

import com.DevilsQuest.app.data.entities.auth.Role;
import com.DevilsQuest.app.data.entities.auth.User;
import com.DevilsQuest.app.data.models.services.auth.RegisterUserServiceModel;
import com.DevilsQuest.app.data.repositories.RolesRepository;
import com.DevilsQuest.app.data.repositories.UsersRepository;
import com.DevilsQuest.app.services.AuthService;
import com.DevilsQuest.app.services.CloudinaryService;
import com.DevilsQuest.app.services.HashingService;
import com.DevilsQuest.app.services.RolesService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AuthServiceImpl implements AuthService {
    private final RolesService roleseService;
    private final ModelMapper mapper;
    private final HashingService hashingService;
    private final CloudinaryService cloudinaryService;
    private final RolesRepository rolesRepository;
    private final UsersRepository usersRepository;


    public AuthServiceImpl(
        RolesService roleseService, 
        ModelMapper mapper, 
        HashingService hashingService, 
        CloudinaryService cloudinaryService, 
        RolesRepository rolesRepository, 
        UsersRepository usersRepository) {
            this.roleseService = roleseService;
            this.mapper = mapper;
            this.hashingService = hashingService;
            this.cloudinaryService = cloudinaryService;
            this.rolesRepository = rolesRepository;
            this.usersRepository = usersRepository;
    }

    @Override
    public void register(RegisterUserServiceModel serviceModel, MultipartFile profilePic) throws IOException {
        // Seeding roles in our db on the first registered user.
        roleseService.seedRolesInDb();

        // If the second validations are ok we map object of type {@link RegisterUserServiceModel} to {@link User} and we hash the password.
        User user = mapper.map(serviceModel, User.class);
        user.setPassword(hashingService.hash(user.getPassword()));
        user.setImageUrl(cloudinaryService.upload(profilePic));

        // If we have no users the first user is receiving all of the roles we have in our db and every next user gets only role of user.
        if(usersRepository.count() == 0) {
            user.setAllAuthorties(rolesRepository.findAll());
        } else {
            Role role = rolesRepository.findByAuthority("USER");
            user.setSingleAuthority(role);
        }

        // We save the user in our database.
        usersRepository.save(user);
    }
}