package co.com.inspirar.dao;

import co.com.inspirar.models.Usuario;
import java.util.List;


public interface UsuarioDao {
    List<Usuario> getUsers();

    void deleteUser(Long id);

    void regUser(Usuario usuario);
}
