package co.com.inspirar.controllers;

import co.com.inspirar.dao.UsuarioDao;
import co.com.inspirar.models.Usuario;
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
