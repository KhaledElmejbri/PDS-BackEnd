package org.sesame.ms.security.authentication.FailedAuthHandler;


import org.sesame.ms.security.authentication.repositories.LogsRepository;

import java.time.Instant;


public class LoginFailException extends Exception {

    private LogsRepository logsRepository;






    public LoginFailException(String name, LogsRepository logsRepository, Boolean isLocked, int attempts) {

        super();

        this.logsRepository=logsRepository;
        handleLoginFail(name,isLocked,attempts);
       // getnbAttempts(name);

    }




    public int getnbAttempts(String name){
        try {

                return logsRepository.getFailedAttempts(name);


        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }


    }

    private void handleLoginFail(String name,Boolean isLocked,int nbAttempts) {
    if(!isLocked) {

    /*if (nbAttempts == null) {
        nbAttempts = 0;
    }*/

    if (nbAttempts >= 2) {
        logsRepository.lockOrUnlockUser(name, true);
        logsRepository.updateFailedAttempts(name, 0);
    } else {
        logsRepository.updateFailedAttempts(name, nbAttempts + 1);
    }
    }
    }
}
