$(document).on("click", "#btnagregar", function(){
	$("#txtempresa").val("");
	$("#txtcargo").val("");
	$("#txtdescripcion").val("");
	$("#hddidregistroexp").val("0");
	$("#cbonivel").empty();
	$("#modalExp").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtempresa").val($(this).attr("data-empresa"));
	$("#txtcargo").val($(this).attr("data-cargo"));
	$("#txtdescripcion").val($(this).attr("data-descripcion_exp"));
	$("#hddidregistroexp").val($(this).attr("data-id_experi_laboral"));
	$("#modalExp").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/experiencia/registrarExp",
		contentType: "application/json",
		data: JSON.stringify({
			id_experi_laboral: $("#hddidregistroexp").val(),
			empresa: $("#txtempresa").val(),
			cargo: $("#txtcargo").val(),
			descripcion_exp: $("#txtdescripcion").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarExp();
		}
	});
	$("#modalExp").modal("hide");
})

$(document).on("click", ".btneliminarexp", function(){
	$("#hddideliminarexp").val("");
	$("#hddideliminarexp").val($(this).attr("data-id_experi_laboral"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar  "+ 
			$(this).attr("data-empresa")+"?");
	$("#modalEliminarExp").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/experiencia/eliminarExp",
		data: JSON.stringify({
			id_experi_laboral: $("#hddideliminarexp").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarExp();
		}
	})
	$("#modalEliminarExp").modal("hide");
})

function ListarExp(){
	$.ajax({
		type: "GET",
		url: "/experiencia/listarExp",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblexp > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblexp > tbody").append("<tr>"+
						"<td>"+value.id_experi_laboral+"</td>"+
						"<td>"+value.empresa+"</td>"+
						"<td>"+value.cargo+"</td>"+
						"<td>"+value.descripcion_exp+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-id_experi_laboral='"+value.id_experi_laboral+"'"+
							" data-empresa='"+value.empresa+"'"+
							" data-cargo='"+value.cargo+"'"+
							" data-descripcion_exp='"+value.descripcion_exp+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarexp'"+	
							" data-id_experi_laboral='"+value.id_experi_laboral+"'"+
							" data-empresa='"+value.empresa+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}





