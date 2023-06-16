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

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.ExperiLaboral;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request.ExperiLaboralRequest;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.response.ResultadoResponse;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.service.ExperiLaboralService;

@Controller
@RequestMapping("/experilaboral")
public class ExperiLaboralController {

	@Autowired
	private ExperiLaboralService experiLaboralService;
	
	@GetMapping("/frmexperilaboral")
	public String frmMantexperilaboral(Model model) {
		model.addAttribute("listaexperilaboral", 
				experiLaboralService.listarExperiLaboral());
		return "experilaboral/frmexperilaboral";
	}
	
	@PostMapping("/registrarExperiLaboral")
	@ResponseBody
	public ResultadoResponse registrarExperilaboral(
			@RequestBody ExperiLaboralRequest experiLaboralRequest
			) {
		String mensaje = "Experiencia Laboral registrado correctamente";
		Boolean respuesta = true;
		try {
			ExperiLaboral objExperiLaboral = new ExperiLaboral();
			if(experiLaboralRequest.getId_experi_laboral() > 0) {
				objExperiLaboral.setId_experi_laboral(experiLaboralRequest.getId_experi_laboral());
			}
			objExperiLaboral.setEmpresa(experiLaboralRequest.getEmpresa());
			objExperiLaboral.setCargo(experiLaboralRequest.getCargo());
			objExperiLaboral.setDescripcion_exp(experiLaboralRequest.getDescripcionExp());
			objExperiLaboral.setFecha_ingreso(experiLaboralRequest.getFecha_ingreso());
			objExperiLaboral.setFecha_egreso(experiLaboralRequest.getFecha_egreso());	
			experiLaboralService.registrarExperiLaboral(objExperiLaboral);
		}catch(Exception ex) {
			mensaje = "Experiencia Laboral no registrada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarExperilaboral")
	@ResponseBody
	public ResultadoResponse eliminarExperilaboral(@RequestBody
			ExperiLaboral experiLaboralRequest ) {
		String mensaje = "Experiencia Laboral eliminado correctamente";
		Boolean respuesta = true;
		try {
			experiLaboralService.eleiminarExperiLaboral(experiLaboralRequest.getId_experi_laboral());
		}catch(Exception e) {
			mensaje = "Experiencia Laboral no eliminado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
		
	}
	
	@GetMapping("/listarExperilboral")
	@ResponseBody
	public List<ExperiLaboral> listarExperiLaboral(){
		return experiLaboralService.listarExperiLaboral();
	}
	
}
