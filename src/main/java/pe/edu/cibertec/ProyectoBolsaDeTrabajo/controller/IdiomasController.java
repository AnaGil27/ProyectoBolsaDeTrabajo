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

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Idiomas;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.NivelIdiomas;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request.IdiomasRequest;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.response.ResultadoResponse;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.service.IdiomasService;

@Controller
@RequestMapping("/idiomas")
public class IdiomasController {
	@Autowired
	private IdiomasService idiomasService;
	
	@GetMapping("/frmidiomas")
	public String frmMantIdiomas(Model model) {
		model.addAttribute("listaidiomas", 
				idiomasService.listarIdioma());
		return "idiomas/frmidiomas";
	}
	@PostMapping("/registrarIdiomas")
	@ResponseBody
	public ResultadoResponse registrarIdiomas(
			@RequestBody IdiomasRequest idiomaRequest
			) {
		String mensaje ="Idioma registrada correctamente";
		Boolean respuesta = true;
		try {			
			//Se puede aplicar el patrón Builder en estos objetos
			Idiomas objIdiomas = new Idiomas();
			if(idiomaRequest.getId_idioma() > 0) {
				objIdiomas.setId_idioma(idiomaRequest.getId_idioma());
			}
			objIdiomas.setIdioma(idiomaRequest.getIdioma());
			
			NivelIdiomas objNivelIdiomas = new NivelIdiomas();
			
			objNivelIdiomas.setId_nivel(idiomaRequest.getId_nivel());
			objIdiomas.setNivelIdiomas(objNivelIdiomas);

			idiomasService.registrarIdiomas(objIdiomas);
		}catch(Exception ex) {
			mensaje = "Idioma no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@DeleteMapping("/eliminarIdiomas")
	@ResponseBody
	public ResultadoResponse eliminarIdiomas(@RequestBody
			IdiomasRequest idiomasRequest) {
		String mensaje = "Idioma eliminada correctamente";
		Boolean respuesta = true;
		try {
			idiomasService.eliminarIdiomas(idiomasRequest.getId_idioma());
		}catch (Exception e) {
			mensaje = "Idioma no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarIdiomas")
	@ResponseBody
	public List<Idiomas> listarIdiomas(){
		return idiomasService.listarIdioma();
	}
}
