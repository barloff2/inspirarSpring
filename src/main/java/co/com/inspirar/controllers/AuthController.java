package co.com.inspirar.controllers;

import co.com.inspirar.dao.UsuarioDao;
import co.com.inspirar.models.Usuario;
import co.com.inspirar.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        Usuario userData = usuarioDao.getUserDataCred(usuario);
        if (userData != null) {
            //Devuelve el token
            return jwtUtil.create(userData.getId().toString(), usuario.getEmail());
        }
        return "FAIL";
    }
}
