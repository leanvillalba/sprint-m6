// Función para obtener la Institución de Salud y AFP de un trabajador por su ID

/*

function obtenerInformacionTrabajador(trabajadorId) {
    $.ajax({
        type: "GET",
        url: "/trabajador/obtenerInformacionTrabajador",
        data: {
            trabajadorId: trabajadorId
        },
        success: function (data) {
            // Actualizar los campos con la información obtenida del servidor
            $("select[name='institucionSalud']").val(data.institucionSalud);
            $("select[name='institucionPrevision']").val(data.institucionPrevision);
        },
        error: function (xhr, status, error) {
            console.error("Error al obtener la información del trabajador:", error);
        }
    });
}

// Función para seleccionar automáticamente la Institución de Salud y AFP correspondientes al trabajador seleccionado
function seleccionarInstituciones(trabajadorId) {
    obtenerInformacionTrabajador(trabajadorId);
}

// Evento para detectar el cambio en el campo de selección de Trabajador
$("select[name='trabajadorId']").on("change", function () {
    const trabajadorId = $(this).val();
    seleccionarInstituciones(trabajadorId);
});

// Evento para seleccionar automáticamente la Institución de Salud y AFP al cargar la página
$(document).ready(function () {
    const trabajadorId = $("select[name='trabajadorId']").val();
    seleccionarInstituciones(trabajadorId);
});

*/
