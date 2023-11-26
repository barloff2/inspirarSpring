package co.com.inspirar.controllers;

import co.com.inspirar.dao.UsuarioDao;
import co.com.inspirar.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void regUsers(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        usuario.setPassword(argon2.hash(4, 1024, 4, usuario.getPassword()));
        usuarioDao.regUser(usuario);
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsers() {
        return usuarioDao.getUsers();
    }
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void delUser(@PathVariable Long id) {
        usuarioDao.deleteUser(id);
        Usuario usuario = new Usuario();
    }
}
