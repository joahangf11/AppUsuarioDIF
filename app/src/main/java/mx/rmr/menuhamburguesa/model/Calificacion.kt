package mx.rmr.menuhamburguesa.model

data class Calificacion(
    val IDUsuario: Int,
    val FolioComedor: Int,
    val Fecha: String,
    val CalLimpieza: Int,
    val CalComida: Int,
    val CalAtencion: Int,
    val Comentario: String?
)
