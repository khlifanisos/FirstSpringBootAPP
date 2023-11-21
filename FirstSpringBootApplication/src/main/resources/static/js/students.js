function deleteStudent(id) {



	swal({
		title: "Are you sure?",
		text: "Once deleted, you will not be able to recover this student!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {

				$.ajax({
					url: "/students/delete-ajax",
					data: { 'id': id },
					method: 'POST',
					success: function() {
						$("#" + id).remove();
						swal("Poof! Your student has been deleted!", {
							icon: "success",
						});
					}
				});

			} else {
				swal("Your student is safe!");
			}
		});







}