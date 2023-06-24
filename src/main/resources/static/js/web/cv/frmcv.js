$(document).on("click", "#btnagregar", function(){
	$("#txtresumen").val("");
	$("#txtempresa").val("");
	$("#txtcargo").val("");
	$("#txtexp").val("");
	$("#txtedu").val("");
	$("#txthab").val("");
	$("#txttema").val("");
	$("#txtidioma").val("");
	$("#txtpro").val("");
	$("#hddidregistrocv").val("0");
	$("#modalCv").modal("show");
});
$(document).on("click", ".btnactualizar", function(){
	$("#txtresumen").val($(this).attr("data-resumen"));
	$("#txtempresa").val($(this).attr("data-empresa"));
	$("#txtcargo").val($(this).attr("data-cargo"));
	$("#txtexp").val($(this).attr("data-descripcion_exp"));
	$("#txtedu").val($(this).attr("data-educacion"));
	$("#txthab").val($(this).attr("data-habilidad"));
	$("#txttema").val($(this).attr("data-tema"));
	$("#txtidioma").val($(this).attr("data-idioma"));
	$("#txtpro").val($(this).attr("data-proyectos"));
	$("#hddidregistrocv").val($(this).attr("data-idCV"));	
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
			habilidad: $("#txthab").val(),
			tema: $("#txttema").val(),
			idioma: $("#txtidioma").val(),
			proyectos: $("#txtpro").val()
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
						"<td>"+value.ExperiLaboral.empresa+"</td>"+
						"<td>"+value.ExperiLaboral.cargo+"</td>"+
						"<td>"+value.ExperiLaboral.descripcion_exp+"</td>"+
						"<td>"+value.educacion+"</td>"+
						"<td>"+value.Habilidades.habilidad+"</td>"+
						"<td>"+value.tema.tema+"</td>"+
						"<td>"+value.Idiomas.idioma+"</td>"+
						"<td>"+value.proyectos+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idCV='"+value.idCV+"'"+
							" data-resumen='"+value.resumen+"'"+
							" data-empresa='"+value.ExperiLaboral.empresa+"'"+
							" data-cargo='"+value.ExperiLaboral.cargo+"'"+
							" data-descripcion_exp='"+value.ExperiLaboral.descripcion_exp+"'"+
							" data-educacion='"+value.educacion+"'"+
							" data-habilidad='"+value.Habilidades.habilidad+"'"+
							" data-tema='"+value.tema.tema+"'"+
							" data-idioma='"+value.Idiomas.idioma+"'"+
							" data-proyectos='"+value.proyectos+"'"+
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