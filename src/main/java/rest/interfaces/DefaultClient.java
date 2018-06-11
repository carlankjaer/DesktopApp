package rest.interfaces;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Created by magnus
 */
public interface DefaultClient <T> {
    List<T> getAll() throws NotAuthorizedException;
    T get(int id) throws NotFoundException, NotAuthorizedException;
    T post(T element) throws NotAuthorizedException;
    T delete(int id) throws NotFoundException, NotAuthorizedException;
    T put(int id, T element) throws NotFoundException, NotAuthorizedException;
}
