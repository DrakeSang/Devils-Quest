package com.DevilsQuest.app.services;

public interface RolesService {
    /**
     * If we do not have any roles in our db we seed the roles we need so we do not have to seed them manually.
     */
    void seedRolesInDb();
}