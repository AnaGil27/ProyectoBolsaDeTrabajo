$(document).on("click", "#btnagregar", function(){
	$("#txtpais").val("");
	$("#hddidregistropais").val("0");
	$("#modalPais").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
	$("#txtpais").val($(this).attr("data-pais"));
	$("#hddidregistropais").val($(this).attr("data-id_pais"));
	$("#modalPais").modal("show");
});

$(document).on("click", "#btnguardar", function(){
	$.ajax({
		type: "POST",
		url: "/pais/registrarPais",
		contentType: "application/json",
		data: JSON.stringify({
			id_pais: $("#hddidregistropais").val(),
			pais: $("#txtpais").val(),
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarPais();
		}
	});
	$("#modalPais").modal("hide");
})

$(document).on("click", ".btneliminarpais", function(){
	$("#hddideliminarpais").val("");
	$("#hddideliminarpais").val($(this).attr("data-id_pais"));
	$("#mensajeeliminar").text("¿Está seguro de eliminar la "+ 
			$(this).attr("data-pais")+"?");
	$("#modalEliminarPais").modal("show");
})
$(document).on("click", "#btneliminar", function(){
	$.ajax({
		type: "DELETE",
		contentType: 'application/json',
		url: "/pais/eliminarPais",
		data: JSON.stringify({
			id_pais: $("#hddideliminarpais").val()
		}),
		success: function(resultado){
			alert(resultado.mensaje);
			ListarPais();
		}
	})
	$("#modalEliminarPais").modal("hide");
})

function ListarPais(){
	$.ajax({
		type: "GET",
		url: "/pais/listarPais",
		dataType: "json",
		success: function(resultado){
			//console.log(resultado);
			$("#tblpais > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblpais > tbody").append("<tr>"+
						"<td>"+value.id_pais+"</td>"+
						"<td>"+value.pais+"</td>"+
						
						"<td>"+
							"<button type='button' class='btn btn-success btnactualizar'"+
							" data-id_pais='"+value.id_pais+"'"+
							" data-pais='"+value.pais+"'"+
							"><i class='fas fa-pen'></i></button></td>"+
						"<td>"+
							"<button type='button' class='btn btn-danger btneliminarpais'"+	
							" data-id_pais='"+value.id_pais+"'"+
							" data-pais='"+value.pais+"'"+
							"><i class='fas fa-trash'></i></button></td>"+							
						"</tr>")
			})
			
			
		}
	})
}

