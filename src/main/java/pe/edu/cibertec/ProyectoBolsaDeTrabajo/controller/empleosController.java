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

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.empleos;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request.empleosRequest;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.response.ResultadoResponse;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.service.empleosService;



@Controller
@RequestMapping("/empleo")
public class empleosController {
	@Autowired
	private empleosService empleosService;

	@GetMapping("/frmempleo")
	public String frmMantempleo(Model model) {
		model.addAttribute("listaempleo", 
				empleosService.listarEmpleo());
		return "empleo/frmempleo";
	}
	
	@PostMapping("/registrarEmpleo")
	@ResponseBody
	public ResultadoResponse registrarEmpleo(
			@RequestBody empleosRequest empleoRequest
			) {
		String mensaje ="Empleo registrado correctamente";
		Boolean respuesta = true;
		try {			
			//Se puede aplicar el patrón Builder en estos objetos
			empleos objEmpleo = new empleos();
			if(empleoRequest.getId_empleos() > 0) {
				objEmpleo.setId_empleos(empleoRequest.getId_empleos());
			}
			objEmpleo.setEmpleo(empleoRequest.getEmpleo());
			objEmpleo.setEmpresa(empleoRequest.getEmpresa());
			objEmpleo.setDescripcion(empleoRequest.getDescripcion());
			objEmpleo.setUbicacion(empleoRequest.getUbicacion());

			empleosService.registrarEmpleo(objEmpleo);
			
		}catch(Exception ex) {
			mensaje = "Tema no registrado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarEmpleo")
	@ResponseBody
	public ResultadoResponse eliminarEmpleo(@RequestBody
			empleosRequest empleoRequest) {
		String mensaje = "Empleo eliminado correctamente";
		Boolean respuesta = true;
		try {
			empleosService.eliminarEmpleo(empleoRequest.getId_empleos());
		}catch (Exception e) {
			mensaje = "Empleo no eliminado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarEmpleos")
	@ResponseBody
	public List<empleos> listarEmpleos(){
		return empleosService.listarEmpleo();
	}
}