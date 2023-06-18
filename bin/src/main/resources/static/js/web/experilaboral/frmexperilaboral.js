$(document).on("click", "#btnagregar", function(){
	$("#txtempresa").val("");
	$("#txtcargo").val("");
	$("#txtdescripcion").val("");
	$("#txtfechaingreso").val("");
	$("#txtfechaegreso").val("");
	$("#hddidregistroexperi").val("0");
	$("#modalExperiLaboral").modal("show");
});

$(document).on("click", ".btnactualizarexperi", function(){
	$("#txtempresa").val($(this).attr("data-empresa"));
	$("#txtcargo").val($(this).attr("data-cargo"));
	$("#txtdescripcion").val($(this).attr("data-descripcion_exp"));
	$("#txtfechaingreso").val($(this).attr("data-fecha_ingreso"));
	$("#txtfechaegreso").val($(this).attr("data-fecha_egreso"));
	$("#hddidregistroexperi").val($(this).attr("data-id_experi_laboral"));
	$("#modalExperiLaboral").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/experilaboral/registrarExperiLaboral",
		contentType: "application/json",
		data: JSON.stringify({
			id_experiLaboral: $("#hddidregistroexperi").val(),
			empresa: $("#txtempresa").val(),
			cargo: $("#txtcargo").val(),
			descripcionExp: $("#txtdescripcion").val(),
			fecha_ingreso: $("#txtfechaingreso").val(),
			fecha_egreso: $("#txtfechaegreso").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarExperiLaboral();
		}
	});
	$("#modalExperiLaboral").modal("hide");
})

$(document).on("click", ".btneliminarexperi", function(){
	$("#hddidregistroexperi").val("");
	$("#hddidregistroexperi").val($(this).attr("data-id_experi_laboral"));
	$("#msjeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-descripcion_exp")+"?");
	$("#modalEliminarExperiLaboral").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/experilaboral/eliminarExperilaboral",
		data: JSON.stringify({
			id_experiLaboral: $("#hddidregistroexperi").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarExperiLaboral();
		}
	})
	$("#modalEliminarExperiLaboral").modal("hide");
})


function ListarExperiLaboral(){
	$.ajax({
		type: "GET",
		url: "/experilaboral/listarExperilboral",
		dataType: "json",
		success: function(resultado){
			console.log(resultado);
			$("#tblexperilaboral > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblexperilaboral > tbody").append("<tr>"+
						"<td>"+value.id_experi_laboral+"</td>"+
						"<td>"+value.usuario.idUsu+"</td>"+
						"<td>"+value.empresa+"</td>"+
						"<td>"+value.cargo+"</td>"+
						"<td>"+value.descripcion_exp+"</td>"+
						"<td>"+value.fecha_ingreso+"</td>"+
						"<td>"+value.fecha_egreso+"</td>"+													
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizarexperi'"+
							" data-id_experi_laboral='"+value.id_experi_laboral+"'"+
							" data-idUsu='"+value.usuario.idUsu+"'"+
							" data-empresa='"+value.empresa+"'"+
							" data-cargo='"+value.cargo+"'"+
							" data-descripcion_exp='"+value.descripcion_exp+"'"+
							" data-fecha_ingreso='"+value.fecha_ingreso+"'"+
							" data-fecha_egreso='"+value.fecha_egreso+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarexperi'"+	
							" data-id_experi_laboral='"+value.id_experi_laboral+"'"+
							" data-descripcion_exp='"+value.descripcion_exp+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}