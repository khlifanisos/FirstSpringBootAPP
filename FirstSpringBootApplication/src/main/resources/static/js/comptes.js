function deleteCompte(rib) {
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
					url: "/comptes/delete-ajax",
					data: { 'rib': rib },
					method: 'POST',
					success: function() {
						$("#" + rib).remove();
						swal("Poof! Your compte has been deleted!", {
							icon: "success",
						});
					}
				});

			} else {
				swal("Your compte is safe!");
			}
		});







}