$(document).on("click", "#btnagregar", function(){
	$("#txtresumen").val("");
	$("#txteducacion").val("");
	$("#txtproyectos").val("");
	$("#txttema").val("")
	$("#txthabilidades").val("")
	$("#hddidregistrocv").val("0");
	
	$("#modalCv").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtresumen").val($(this).attr("data-resumen"));
	$("#txteducacion").val($(this).attr("data-educacion"));
	$("#txtproyectos").val($(this).attr("data-proyectos"));
	$("#txttema").val($(this).attr("data-tema"))
	$("#txthabilidades").val($(this).attr("data-habilidades"))
	$("#hddidregistrocv").val($(this).attr("data-idCV"));	
	
	$("#modalCv").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/cv/frmcv",
		contentType: "application/json",
		data: JSON.stringify({
			idCV: $("#hddidregistrocv").val(),
			resumen: $("#txtresumen").val(),
			educacion: $("#txteducacion").val(),
			proyectos: $("#txtproyectos").val()
			tema: $("#txttema").val()
			habilidades: $("#txthabilidades").val()
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
	$("#hddideliminarcv").val($(this).attr("data-idCv"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-resumen")+"?");
	$("#modalEliminarCv").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/cv/frmcv",
		data: JSON.stringify({
			idsala: $("#hddideliminarcv").val()
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
		url: "/cv/listarCvs",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblcv > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcv > tbody").append("<tr>"+
						"<td>"+value.idCV+"</td>"+
						"<td>"+value.resumen+"</td>"+
						"<td>"+value.educacion+"</td>"+
						"<td>"+value.proyecto+"</td>"+
						"<td>"+value.tema.tema+"</td>"+
						"<td>"+value.habilidades.habilidades+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-idCv='"+value.idCv+"'"+
							" data-resumen='"+value.resumen+"'"+
							" data-educacion='"+value.educacion+"'"+
							" data-proyecto='"+value.proyecto+"'"+
							" data-tema='"+value.tema.tema+"'"+
							" data-habilidades='"+value.habilidades.habilidades+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarcv'"+	
							" data-idCv='"+value.idCv+"'"+
							" data-resumen='"+value.resumen+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}



