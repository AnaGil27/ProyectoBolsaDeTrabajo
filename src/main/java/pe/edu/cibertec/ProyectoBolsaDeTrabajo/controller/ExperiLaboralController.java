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
@RequestMapping("/experiencia")
public class ExperiLaboralController {

	@Autowired
	private ExperiLaboralService ExperiLaboralService;
	
	@GetMapping("/frmexperiencia")
	public String frmMantExperiLaboral(Model model) {
		model.addAttribute("listaexp", 
				ExperiLaboralService.listarExps());
		return "experiencia/frmexperiencia";
	}
	
	@PostMapping("/registrarExp")
	@ResponseBody
	public ResultadoResponse registrarExp(
			@RequestBody ExperiLaboralRequest ExperiLaboralRequest
			) {
		String mensaje ="Experiencia Laboral registrada correctamente";
		Boolean respuesta = true;
		try {			
			//Se puede aplicar el patrón Builder en estos objetos
			ExperiLaboral objExp = new ExperiLaboral();
			if(ExperiLaboralRequest.getId_experi_laboral() > 0) {
				objExp.setId_experi_laboral(ExperiLaboralRequest.getId_experi_laboral());
			}
			objExp.setEmpresa(ExperiLaboralRequest.getEmpresa());
			objExp.setCargo(ExperiLaboralRequest.getCargo());
			objExp.setDescripcion_exp(ExperiLaboralRequest.getDescripcion_exp());
			

			ExperiLaboralService.registrarExp(objExp);
		}catch(Exception ex) {
			mensaje = "Experiencia Laboral no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@DeleteMapping("/eliminarExp")
	@ResponseBody
	public ResultadoResponse eliminarExp(@RequestBody
			ExperiLaboralRequest ExperiLaboralRequest) {
		String mensaje = "Experiencia laboral eliminada correctamente";
		Boolean respuesta = true;
		try {
			ExperiLaboralService.eliminarExp(ExperiLaboralRequest.getId_experi_laboral());
		}catch (Exception e) {
			mensaje = "Experiencia laboral no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarExp")
	@ResponseBody
	public List<ExperiLaboral> listarExp(){
		return ExperiLaboralService.listarExps();
	}
}
