$(document).on("click", "#btnagregar", function(){
	$("#txtTema").val("");
	$("#hddidregistroTema").val("0");
	$("#modalTema").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtTema").val($(this).attr("data-tema"));
	$("#hddidregistroTema").val($(this).attr("data-id_temas"));
	$("#modalTema").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/tema/registrarTema",
		contentType: "application/json",
		data: JSON.stringify({
			id_temas: $("#hddidregistroTema").val(),
			tema: $("#txtTema").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarTema();
		}
	});
	$("#modalTema").modal("hide");
})

$(document).on("click", ".btneliminartema", function(){
	$("#hddideliminartema").val("");
	$("#hddideliminartema").val($(this).attr("data-id_temas"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-tema")+"?");
	$("#modalEliminarTema").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/tema/eliminarTema",
		data: JSON.stringify({
			id_temas: $("#hddideliminartema").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarTema();
		}
	})
	$("#modalEliminarTema").modal("hide");
})

function ListarTema(){
	$.ajax({
		type: "GET",
		url: "/tema/listarTemas",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tbltema > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tbltema > tbody").append("<tr>"+
						"<td>"+value.id_temas+"</td>"+
						"<td>"+value.tema+"</td>"+
						
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-id_temas='"+value.id_temas+"'"+
							" data-tema='"+value.tema+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminartema'"+	
							" data-id_temas='"+value.id_temas+"'"+
							" data-tema='"+value.tema+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}

