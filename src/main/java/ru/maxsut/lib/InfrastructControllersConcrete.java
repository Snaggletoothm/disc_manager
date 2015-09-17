package ru.maxsut.lib;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.maxsut.domain.Disc;
import ru.maxsut.domain.User;

import java.util.Set;

@Service
public class InfrastructControllersConcrete implements InfrastructControllers {

    public boolean hasDiscCurrentUser(Disc disc, String currName){
        User user = disc.getUser();
        if(user.getName().equals(currName))
                return true;
        return false;
    }

    public String getUsername(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
