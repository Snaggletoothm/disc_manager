package ru.maxsut.lib;

import ru.maxsut.domain.Disc;

/**
 * Created by Максим on 10.08.2015.
 */
public interface InfrastructControllers {
    boolean hasDiscCurrentUser(Disc disc, String currName);
    String getUsername();
}
