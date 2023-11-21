function deleteClient(cin) {
	swal({
		title: "Are you sure?",
		text: "Once deleted, you will not be able to recover this compte!",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {

				$.ajax({
					url: "/clients/delete-ajax",
					data: { 'cin': cin },
					method: 'POST',
					success: function() {
						$("#" + cin).remove();
						swal("Poof! Your client has been deleted!", {
							icon: "success",
						});
					}
				});

			} else {
				swal("Your client is safe!");
			}
		});







}