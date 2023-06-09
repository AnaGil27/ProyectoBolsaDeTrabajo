package pe.edu.cibertec.ProyectoBolsaDeTrabajo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.tema;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request.temaRequest;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.response.ResultadoResponse;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.service.temaService;





@Controller
@RequestMapping("/tema")
public class temaController {
	@Autowired
	private temaService temaService;
	
	@GetMapping("/frmtema")
	public String frmManttema(Model model) {
		model.addAttribute("listatema", 
				temaService.listarTema());
		return "tema/frmtema";
	}
	
	@PostMapping("/registrarTema")
	@ResponseBody
	public ResultadoResponse registrarTema(
			@RequestBody temaRequest temaRequest
			) {
		String mensaje ="Tema registrada correctamente";
		Boolean respuesta = true;
		try {			
			//Se puede aplicar el patrón Builder en estos objetos
			tema objTema = new tema();
			if(temaRequest.getId_temas() > 0) {
				objTema.setId_temas(temaRequest.getId_temas());
			}
			objTema.setTema(temaRequest.getTema());

			temaService.registrarTema(objTema);
			
		}catch(Exception ex) {
			mensaje = "Tema no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarTema")
	@ResponseBody
	public ResultadoResponse eliminarTema(@RequestBody
			temaRequest temaRequest) {
		String mensaje = "Tema eliminado correctamente";
		Boolean respuesta = true;
		try {
			temaService.eliminarTema(temaRequest.getId_temas());
		}catch (Exception e) {
			mensaje = "Tema no eliminado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarTemas")
	@ResponseBody
	public List<tema> listarTemas(){
		return temaService.listarTema();
	}
}
