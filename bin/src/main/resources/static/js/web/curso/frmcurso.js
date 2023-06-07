$(document).on("click", "#btnagregar", function(){
	$("#txtid_alu").val("");
	$("#txtcurso").val("");
	$("#hddidregistrocurso").val("0");
	$("#txtcentro_estudios").val("");
	$("#txtfecha_inicio").val("");
	$("#txtfecha_fin").val("");
	$("#modalCurso").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtcurso").val($(this).attr("data-curso"));
	$("#txtcentro_estudios").val($(this).attr("data-centro_estudios"));
	$("#txtfecha_inicio").val($(this).attr("data-fecha_inicio"));
	$("#txtfecha_fin").val($(this).attr("data-fecha_fin"));
	$("#hddidregistrocurso").val($(this).attr("data-id_curso"));
	var id_alu = $(this).attr("data-id_alu");
	$("#modalCurso").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/curso/registrarCurso",
		contentType: "application/json",
		data: JSON.stringify({
			id_curso: $("#hddidregistrocurso").val(),
			id_alu: $("#txtid_alu").val(),
			curso: $("#txtcurso").val(),
			centro_estudios: $("#txtcentro_estudios").val(),
			centro_estudios: $("#txtfecha_inicio").val(),
			centro_estudios: $("#txtfecha_fin").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarCurso();
		}
	});
	$("#modalCurso").modal("hide");
})

$(document).on("click", ".btneliminarcurso", function(){
	$("#hddideliminarcursos").val("");
	$("#hddideliminarcursos").val($(this).attr("data-id_curso"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar "+ 
			$(this).attr("data-curso")+"?");
	$("#modalEliminarCurso").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/curso/eliminarCurso",
		data: JSON.stringify({
			id_curso: $("#hddideliminarcursos").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarCurso();
		}
	})
	$("#modalEliminarCurso").modal("hide");
})

	
function ListarCurso(){
	$.ajax({
		type: "GET",
		url: "/curso/listarCursos",
		dataType: "json",
		success: function(resultado){
			$("#tblcurso > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcurso > tbody").append("<tr>"+
						"<td>"+value.id_curso+"</td>"+
						"<td>"+value.id_alu+"</td>"+
						"<td>"+value.curso+"</td>"+
						"<td>"+value.centro_estudios+"</td>"+
						"<td>"+value.fecha_inicio+"</td>"+
						"<td>"+value.fecha_fin+"</td>"+
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-id_curso='"+value.id_curso+"'"+
							" data-id_alu='"+value.iid_alu+"'"+
							" data-curso='"+value.curso+"'"+
							" data-centro_estudios='"+value.centro_estudios+"'"+
							" data-fecha_inicio='"+value.fecha_inicio+"'"+
							" data-fecha_fin='"+value.fecha_fin+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarcurso'"+	
							" data-id_curso='"+value.id_curso+"'"+
							" data-curso='"+value.curso+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}





