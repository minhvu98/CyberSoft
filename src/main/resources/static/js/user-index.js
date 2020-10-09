const UPLOAD_API = "/upload";
const UPLOAD_METHOD = "POST";

$(document).ready(function({
	$('#fileUpload').on('change', function(){
		let target = $(this).data('target');
		let imgdp = $(this).data('img');
		
		var files = event.target.files;
		var formData = new FormData();
		formData.append("file", files[0]);
		
		$.ajax({
			url: UPLOAD_API,
			type: UPLOAD_METHOD,
			data: formData,
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			success: function(res){
				$(target).val(res);
				$(imgdp).attr('src', res);
			},
			error: function(err) {
				console.log(err);
			}
		})
	})
}));