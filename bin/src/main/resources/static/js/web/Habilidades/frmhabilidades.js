$(document).on("click", "#btnagregar", function(){
	$("#txtdescripcion").val("");
	$("#hddidregistrohabilidad").val("0");
	$("#modalHabilidad").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtdescripcion").val($(this).attr("data-habilidad"));
	$("#hddidregistrohabilidad").val($(this).attr("data-id_habilidad"));
	$("#modalHabilidad").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/Habilidades/registrarHabilidad",
		contentType: "application/json",
		data: JSON.stringify({
			id_habilidad: $("#hddidregistrohabilidad").val(),
			habilidad: $("#txtdescripcion").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarHabilidad();
		}
	});
	$("#modalHabilidad").modal("hide");
})

$(document).on("click", ".btneliminarhabilidad", function(){
	$("#hddideliminarhabilidad").val("");
	$("#hddideliminarhabilidad").val($(this).attr("data-id_habilidad"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-habilidad")+"?");
	$("#modalEliminarHabilidad").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/Habilidades/eliminarHabilidad",
		data: JSON.stringify({
			id_habilidad: $("#hddideliminarhabilidad").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarHabilidad();
		}
	})
	$("#modalEliminarHabilidad").modal("hide");
})

function ListarHabilidad(){
	$.ajax({
		type: "GET",
		url: "/Habilidades/listarHabilidades",
		dataType: "json",
		success: function(resultado){
			$("#tblhabilidades > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblhabilidades > tbody").append("<tr>"+
						"<td>"+value.id_habilidad+"</td>"+
						"<td>"+value.habilidad+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-id_habilidad='"+value.id_habilidad+"'"+
							" data-habilidad='"+value.habilidad+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarhabilidad'"+	
							" data-id_habilidad='"+value.id_habilidad+"'"+
							" data-habilidad='"+value.habilidad+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}