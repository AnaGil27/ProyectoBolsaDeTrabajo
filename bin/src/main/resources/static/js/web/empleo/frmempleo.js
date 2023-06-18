$(document).on("click", "#btnagregar", function(){
	$("#txtEmpleo").val("");
	$("#txtEmpresa").val("");
	$("#txtDescripcion").val("");
	$("#txtUbicacion").val("");
	$("#hddidregistroEmpleo").val("0");
	$("#modalEmpleo").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtEmpleo").val($(this).attr("data-empleo"));
	$("#txtEmpresa").val($(this).attr("data-empresa"));
	$("#txtDescripcion").val($(this).attr("data-descripcion"));
	$("#txtUbicacion").val($(this).attr("data-ubicacion"));
	$("#hddidregistroTema").val($(this).attr("data-id_empleos"));
	$("#modalEmpleo").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/empleo/registrarEmpleo",
		contentType: "application/json",
		data: JSON.stringify({
			id_empleos:$("#hddidregistroEmpleo").val(),
			empleo: $("#txtEmpleo").val(),
			empresa: $("#txtEmpresa").val(),
			descripcion: $("#txtDescripcion").val(),
			ubicacion: $("#txtUbicacion").val(),

		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarEmpleo();
		}
	});
	$("#modalEmpleo").modal("hide");
})

$(document).on("click", ".btneliminarempleos", function(){
	$("#hddideliminarEmpleo").val("");
	$("#hddideliminarEmpleo").val($(this).attr("data-id_empleos"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-empleo")+"?");
	$("#modalEliminarEmpleo").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/empleo/eliminarEmpleo",
		data: JSON.stringify({
			id_empleos: $("#hddideliminarEmpleo").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarEmpleo();
		}
	})
	$("#modalEliminarEmpleo").modal("hide");
})

function ListarEmpleo(){
	$.ajax({
		type: "GET",
		url: "/empleo/listarEmpleos",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblempleo > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblempleo > tbody").append("<tr>"+
						"<td>"+value.id_empleos+"</td>"+
						"<td>"+value.empleo+"</td>"+
						"<td>"+value.empresa+"</td>"+
						"<td>"+value.descripcion+"</td>"+
						"<td>"+value.ubicacion+"</td>"+
												
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-id_empleos='"+value.id_empleos+"'"+
							" data-empleo='"+value.empleo+"'"+
							" data-empresa='"+value.empresa+"'"+
							" data-descripcion='"+value.descripcion+"'"+
							" data-ubicacion='"+value.ubicacion+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarempleos'"+	
							" data-id_empleos='"+value.id_empleos+"'"+
							" data-empleo='"+value.empleo+"'"+
							" data-empresa='"+value.empresa+"'"+
							" data-descripcion='"+value.descripcion+"'"+
							" data-ubicacion='"+value.ubicacion+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}

