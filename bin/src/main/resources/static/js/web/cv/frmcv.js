$(document).on("click", "#btnagregar", function(){
	$("#txtresumen").val("");
	$("#txtempresa").val("");
	$("#txtcargo").val("");	
	$("#txtexp").val("");
	$("#txtedu").val("");
	$("#txtpro").val("");
	$("#hddidregistrocv").val("0");
	$("#cbohab").empty();
	$.ajax({
		type: "GET",
		url: "/Habilidades/listarHabilidades",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cbohab").append(
							`<option value="${value.id_habilidad}">
								${value.habilidad}</option>`
							);
				})
			}			
		}
	})
	$("#cbotema").empty();
	$.ajax({
		type: "GET",
		url: "/tema/listarTemas",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cbonivel").append(
							`<option value="${value.id_temas}">
								${value.tema}</option>`
							);
				})
			}			
		}
	})
	
	$("#cboidioma").empty();
	$.ajax({
		type: "GET",
		url: "/idiomas/listarIdiomas",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cboidioma").append(
							`<option value="${value.id_idioma}">
								${value.idioma}</option>`
							);
				})
			}			
		}
	})
	$("#cbonivel").empty();
	$.ajax({
		type: "GET",
		url: "/nivelidioma/listarNivelIdioma",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cbonivel").append(
							`<option value="${value.id_nivel}">
								${value.nivel}</option>`
							);
				})
			}			
		}
	})
	$("#modalCv").modal("show");
});
$(document).on("click", ".btnactualizar", function(){
	$("#txtresumen").val($(this).attr("data-resumen"));
	$("#txtempresa").val($(this).attr("data-empresa"));
	$("#txtcargo").val($(this).attr("data-cargo"));	
	$("#txtexp").val($(this).attr("data-descripcion_exp"));
	$("#txtedu").val($(this).attr("data-educacion"));	
	$("#txtpro").val($(this).attr("data-proyectos"));
	$("#hddidregistrocv").val($(this).attr("data-idCV"));
	$("#cbohab").empty();
	var id_habilidad = $(this).attr("data-id_habilidad");
	$.ajax({
		type: "GET",
		url: "/Habilidades/listarHabilidades",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cbohab").append(
							`<option value="${value.id_habilidad}">
								${value.habilidad}</option>`
							);
				})
				$("#cbohab").val(id_habilidad);
			}			
		}
	})
	$("#cbotema").empty();
	var id_temas = $(this).attr("data-id_temas");
	$.ajax({
		type: "GET",
		url: "/tema/listarTemas",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cbotema").append(
							`<option value="${value.id_temas}">
								${value.tema}</option>`
							);
				})
				$("#cbotema").val(id_temas);
			}			
		}
	})
	$("#cboidioma").empty();
	var id_idioma = $(this).attr("data-id_idioma");
	$.ajax({
		type: "GET",
		url: "/idiomas/listarIdiomas",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cboidioma").append(
							`<option value="${value.id_idioma}">
								${value.idioma}</option>`
							);
				})
				$("#cboidioma").val(id_idioma);
			}			
		}
	})	
	
	$("#cbonivel").empty();
	var id_nivel = $(this).attr("data-id_nivel");
	$.ajax({
		type: "GET",
		url: "/nivelidioma/listarNivelIdioma",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			if(resultado.length > 0){
				$.each(resultado, function(index, value){
					$("#cbonivel").append(
							`<option value="${value.id_nivel}">
								${value.nivel}</option>`
							);
				})
				$("#cbonivel").val(id_nivel);
			}			
		}
	})
	
	$("#modalCv").modal("show");
});
$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/cv/registrarCv",
		contentType: "application/json",
		data: JSON.stringify({
			idCV: $("#hddidregistrocv").val(),
			resumen: $("#txtresumen").val(),
			empresa: $("#txtempresa").val(),
			cargo: $("#txtcargo").val(),			
			descripcion_exp: $("#txtexp").val(),
			educacion: $("#txtedu").val(),
			proyectos: $("#txtpro").val(),
			id_habilidad: $("#cbohab").val(),
			id_temas: $("#cbotema").val(),
			id_idioma: $("#cboidioma").val(),
			id_nivel: $("#cbonivel").val()			
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarCv();
		}
	});
	$("#modalCv").modal("hide");
})
$(document).on("click", ".btneliminarcv", function(){
	$("#hddideliminarcv").val("");
	$("#hddideliminarcv").val($(this).attr("data-idCV"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-resumen")+"?");
	$("#modalEliminarCv").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/cv/eliminarCv",
		data: JSON.stringify({
			idCV: $("#hddideliminarcv").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarCv();
		}
	})
	$("#modalEliminarCv").modal("hide");
})
function ListarCv(){
	$.ajax({
		type: "GET",
		url: "/cv/listarCv",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblcv > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcv > tbody").append("<tr>"+
						"<td>"+value.idCV+"</td>"+
						"<td>"+value.resumen+"</td>"+
						"<td>"+value.empresa+"</td>"+
						"<td>"+value.cargo+"</td>"+
						"<td>"+value.descripcion_exp+"</td>"+
						"<td>"+value.educacion+"</td>"+
						"<td>"+value.proyectos+"</td>"+
						"<td>"+value.Habilidades.habilidad+"</td>"+
						"<td>"+value.tema.tema+"</td>"+
						"<td>"+value.Idiomas.idioma+"</td>"+
						"<td>"+value.NivelIdiomas.nivel+"</td>"+					
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idCV='"+value.idCV+"'"+
							" data-resumen='"+value.resumen+"'"+
							" data-empresa='"+value.empresa+"'"+
							" data-cargo='"+value.cargo+"'"+
							" data-descripcion_exp='"+value.descripcion_exp+"'"+
							" data-educacion='"+value.educacion+"'"+
							" data-proyectos='"+value.proyectos+"'"+
							" data-id_habilidad='"+value.Habilidades.id_habilidad+"'"+
							" data-id_temas='"+value.tema.id_temas+"'"+
							" data-id_idioma='"+value.Idiomas.id_idioma+"'"+
							" data-id_nivel='"+value.NivelIdiomas.id_nivel+"'"+						
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarcv'"+	
							" data-idCV='"+value.idCV+"'"+
							" data-resumen='"+value.resumen+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}