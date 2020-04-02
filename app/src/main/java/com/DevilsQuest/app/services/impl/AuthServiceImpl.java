package com.DevilsQuest.app.services.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

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
    private final HashingService hashingService;
    private final CloudinaryService cloudinaryService;
    private final UsersRepository usersRepository;
    private final RolesRepository rolesRepository;
    private final ModelMapper mapper;

    public AuthServiceImpl(RolesService roleseService, HashingService hashingService,
            CloudinaryService cloudinaryService, UsersRepository usersRepository, RolesRepository rolesRepository,
            ModelMapper mapper) {
        this.roleseService = roleseService;
        this.hashingService = hashingService;
        this.cloudinaryService = cloudinaryService;
        this.usersRepository = usersRepository;
        this.rolesRepository = rolesRepository;
        this.mapper = mapper;
    }

    @Override
    public void register(RegisterUserServiceModel serviceModel, MultipartFile profilePic) throws IOException {
        // Seeding role sin our db on the first registered user.
        roleseService.seedRolesInDb();

        // If the second validations are ok we map object of type {@link RegisterUserServiceModel} to {@link User} and we hash the password.
        User user = mapper.map(serviceModel, User.class);
        user.setPassword(hashingService.hash(user.getPassword()));
        user.setImageUrl(cloudinaryService.upload(profilePic));

        // If we have no users the first user is receiving all of the roles we have in our db and every next user gets only role of user.
        if(usersRepository.count() == 0) {
            user.setAuthorities(new HashSet<>(rolesRepository.findAll()));
        } else {
            user.setAuthorities(new HashSet<>(Set.of(rolesRepository.findByAuthority("USER"))));
        }

        // We save the user in our database.
        usersRepository.save(user);
    }
}