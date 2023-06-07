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

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Habilidades;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request.HabilidadesRequest;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.response.ResultadoResponse;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.service.HabilidadesService;

@Controller
@RequestMapping("/Habilidades")
public class HabilidadesController {
	@Autowired
	private HabilidadesService habilidadesService;
	
	@GetMapping("/frmhabilidades")
	public String frmMantHabilidad(Model model) {
		model.addAttribute("listahabilidades", 
				habilidadesService.listarHabilidades());
		return "Habilidades/frmhabilidades";
	}
	
	@PostMapping("/registrarHabilidad")
	@ResponseBody
	public ResultadoResponse registrarHabilidad(
			@RequestBody HabilidadesRequest habilidadesRequest
			) {
		String mensaje ="Habilidad registrada correctamente";
		Boolean respuesta = true;
		try {			
			Habilidades objHabilidad = new Habilidades();
			if(habilidadesRequest.getId_habilidad() > 0) {
				objHabilidad.setId_habilidad(habilidadesRequest.getId_habilidad());
			}
			objHabilidad.setHabilidad(habilidadesRequest.getHabilidad());
			habilidadesService.registrarHabilidades(objHabilidad);
		}catch(Exception ex) {
			mensaje = "Habilidad no registrada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarHabilidad")
	@ResponseBody
	public ResultadoResponse eliminarHabilidad(@RequestBody
			HabilidadesRequest habilidadesRequest) {
		String mensaje = "Habilidad eliminada correctamente";
		Boolean respuesta = true;
		try {
			habilidadesService.eliminarHabilidades(habilidadesRequest.getId_habilidad());
		}catch (Exception e) {
			mensaje = "Habilidad no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarHabilidades")
	@ResponseBody
	public List<Habilidades> listarHabilidades(){
		return habilidadesService.listarHabilidades();
	}
}
