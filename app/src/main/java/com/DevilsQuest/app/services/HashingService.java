package com.DevilsQuest.app.services;

public interface HashingService {
    /**
     * Method for hasing the password.
     * 
     * @param str the entered password of the user as string so i can hash it and save the hashed pass in my db.
     * @return
     */
    String hash(String str);
}