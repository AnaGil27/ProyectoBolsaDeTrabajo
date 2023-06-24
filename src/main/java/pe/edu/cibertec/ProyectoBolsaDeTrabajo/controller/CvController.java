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

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Cv;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.ExperiLaboral;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Habilidades;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Idiomas;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Usuario;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.tema;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request.CvRequest;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.response.ResultadoResponse;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.service.CvService;

@Controller
@RequestMapping("/cv")
public class CvController {
	@Autowired
	private CvService cvService;
	
	@GetMapping("/frmcv")
	public String frmMantCv(Model model) {
		model.addAttribute("listarcv",cvService.listarCv());
		return "cv/frmcv";
	}
	@PostMapping("/registrarCv")
	@ResponseBody
	public ResultadoResponse registrarCv(
			@RequestBody CvRequest cvRequest) {
		String mensaje="CV registrado correctamente";
		Boolean respuesta= true;
		try {
			Cv objcv = new Cv();
			if(cvRequest.getIdCV() > 0) {
				objcv.setIdCV(cvRequest.getIdCV());
			}
			objcv.setResumen(cvRequest.getResumen());
			objcv.setEducacion(cvRequest.getEducacion());
			objcv.setProyectos(cvRequest.getProyectos());
			

			
			ExperiLaboral objexpl = new ExperiLaboral();
			objexpl.setId_experi_laboral(cvRequest.getId_experi_laboral());
			objcv.setExperiLaboral(objexpl);
			
			Habilidades objhab = new Habilidades();
			objhab.setId_habilidad(cvRequest.getId_habilidad());
			objcv.setHabilidades(objhab);
			
			tema objtema = new tema();
			objtema.setId_temas(cvRequest.getId_temas());
			objcv.setTema(objtema);
			
			Idiomas objidi = new Idiomas();
			objidi.setId_idioma(cvRequest.getId_idioma());
			objcv.setIdiomas(objidi);
			
			cvService.registrarCv(objcv);			
			
		} catch (Exception ex) {
			mensaje = "CV no registrado";
			respuesta = false;
		}
		
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}	
	@DeleteMapping("/eliminarCv")
	@ResponseBody
	public ResultadoResponse eliminarCv(@RequestBody
			CvRequest cvRequest) {
		String mensaje = "CV eliminado correctamente";
		Boolean respuesta = true;
		try {
			cvService.eliminarCv(cvRequest.getIdCV());;
		}catch (Exception e) {
			mensaje = "CV no eliminado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarCv")
	@ResponseBody
	public List<Cv> listarCv(){
		return cvService.listarCv();
	}
}
