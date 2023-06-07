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

import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.bd.Pais;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.request.PaisRequest;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.model.response.ResultadoResponse;
import pe.edu.cibertec.ProyectoBolsaDeTrabajo.service.PaisService;


	@Controller
	@RequestMapping("/pais")
	public class PaisController {
		
		@Autowired
		private PaisService paisService;
		
		@GetMapping("/listarPais")
		@ResponseBody
		public List<Pais> listarPais(){
			return paisService.listarPais();
		}
		
		@GetMapping("/frmpais")
		public String frmMantPais(Model model) {
			model.addAttribute("listapais", 
					paisService.listarPais());
			return "pais/frmpais";
		}
		
		@PostMapping("/registrarPais")
		@ResponseBody
		public ResultadoResponse registrarPais(
				@RequestBody PaisRequest paisRequest
				) {
			String mensaje ="Pais registrado correctamente";
			Boolean respuesta = true;
			try {			
				
				Pais objPais = new Pais();
				if(paisRequest.getId_pais() > 0) {
					objPais.setId_pais(paisRequest.getId_pais());
				}
				objPais.setPais(paisRequest.getPais());
				paisService.registrarPais(objPais);
			}catch(Exception ex) {
				mensaje = "Pais no registrado";
				respuesta = false;
			}
			return ResultadoResponse.builder()
					.mensaje(mensaje)
					.respuesta(respuesta)
					.build();
		}
		
		@DeleteMapping("/eliminarPais")
		@ResponseBody
		public ResultadoResponse eliminarPais(@RequestBody
				PaisRequest paisRequest) {
			String mensaje = "Pais eliminado correctamente";
			Boolean respuesta = true;
			try {
				paisService.eliminarPais(paisRequest.getId_pais());
			}catch (Exception e) {
				mensaje = "Pais no eliminado";
				respuesta = false;
			}
			return ResultadoResponse.builder()
					.mensaje(mensaje)
					.respuesta(respuesta)
					.build();
		}
	
		
			
		

	}

	


