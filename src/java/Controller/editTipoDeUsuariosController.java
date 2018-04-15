/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Conexion;
import Models.tipoUsuario;
import Models.ValidateUser;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class editTipoDeUsuariosController {

    private ValidateUser validar;
    private JdbcTemplate jdbcTemplate;

    public editTipoDeUsuariosController() {
        this.validar = new ValidateUser();
        Conexion conn = new Conexion();
        this.jdbcTemplate = new JdbcTemplate(conn.conectar());
    }

   @RequestMapping(value = "editTipoDeUsuarios.htm", method = RequestMethod.GET)
   public ModelAndView edit(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("TiposUsuarios/editTipoDeUsuarios");
        int id = Integer.parseInt(request.getParameter("id"));
        tipoUsuario u = this.selectUsuario(id);
        mav.addObject("tipoUsuario", new tipoUsuario(u.getNombre(),u.getDescripcion(),u.getId()));
        return mav;
    }
    
   
    public tipoUsuario selectUsuario(int id) {
        final tipoUsuario u = new tipoUsuario();
        String query = "select nombre_tipo_usuario,descripcion_tipo_usuario from tipos_usuarios where id='" + id + "';";
        return (tipoUsuario) jdbcTemplate.query(query, new ResultSetExtractor<tipoUsuario>() {
            @Override
            public tipoUsuario extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    u.setNombre(rs.getString("nombre_tipo_usuario"));
                    u.setDescripcion(rs.getString("descripcion_tipo_usuario"));
                }
                return u;
            }
        });
    }
   
   /* @RequestMapping(value = "edit.htm", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("Usuario") Novedad u, BindingResult result, SessionStatus status, HttpServletRequest request){
        this.validar.validate(u, result);
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView();
            mav.setViewName("BD/edit");
            mav.addObject("Usuario",u);
            return mav;
        }else{
            int id = Integer.parseInt(request.getParameter("id"));
            this.jdbcTemplate.update("update novedades set nombre=? ,informacion=? ,fecha=NOW() where id=?;",u.getNombre(),u.getInformacion(),id);
            return new ModelAndView("redirect:/home.htm");
        }
    }
*/
   
}
