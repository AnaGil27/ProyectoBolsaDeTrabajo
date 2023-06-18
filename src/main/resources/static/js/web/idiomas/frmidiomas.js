$(document).on("click", "#btnagregar", function(){
	$("#txtidioma").val("");
	$("#hddidregistroidioma").val("0");
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
	$("#modalIdiomas").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtidioma").val($(this).attr("data-idioma"));
	$("#hddidregistroidioma").val($(this).attr("data-id_idioma"));
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
	$("#modalIdiomas").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/idiomas/registrarIdiomas",
		contentType: "application/json",
		data: JSON.stringify({
			id_idioma: $("#hddidregistroidioma").val(),
			idioma: $("#txtidioma").val(),
			id_nivel: $("#cbonivel").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarIdoma();
		}
	});
	$("#modalIdiomas").modal("hide");
})

$(document).on("click", ".btneliminaridioma", function(){
	$("#hddideliminaridioma").val("");
	$("#hddideliminaridioma").val($(this).attr("data-id_idioma"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-idioma")+"?");
	$("#modalEliminarIdioma").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/idiomas/eliminarIdiomas",
		data: JSON.stringify({
			id_idioma: $("#hddideliminaridioma").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarIdoma();
		}
	})
	$("#modalEliminarIdioma").modal("hide");
})

function ListarIdoma(){
	$.ajax({
		type: "GET",
		url: "/idiomas/listarIdiomas",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblidioma > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblidioma > tbody").append("<tr>"+
						"<td>"+value.id_idioma+"</td>"+
						"<td>"+value.idioma+"</td>"+
						"<td>"+value.NivelIdiomas.nivel+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-id_idioma='"+value.id_idioma+"'"+
							" data-idioma='"+value.idioma+"'"+
							" data-id_nivel='"+value.NivelIdiomas.id_nivel+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminaridioma'"+	
							" data-id_idioma='"+value.id_idioma+"'"+
							" data-idioma='"+value.idioma+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}





