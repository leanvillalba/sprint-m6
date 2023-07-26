// Data Table
new DataTable('#miLista');

// Función que se ejecuta cuando se hace clic en el botón "Eliminar" dentro del modal
function eliminarUsuario(idUsuario) {
    // Realizo la solicitud de eliminación al servidor utilizando Fetch API o Axios
    fetch(`/usuario/${idUsuario}/eliminar`, {
        method: 'DELETE', // Método HTTP DELETE para eliminar el usuario
    })
        .then((response) => {
            if (response.ok) {
                // Recargo la página después de eliminar el usuario
                window.location.reload();
            } else {
                // Manejo el caso de error si la eliminación falla
                alert('Error al eliminar el usuario.');
            }
        })
        .catch((error) => {
            // Se manejan errores de conexión u otros errores
            alert('Error al eliminar el usuario.');
            console.error(error);
        });
}