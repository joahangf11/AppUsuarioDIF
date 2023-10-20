package mx.rmr.menuhamburguesa.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ListaServiciosApi
{
    @POST("/registrarUsuario")
    fun registrarUsuario(@Body nuevoUsuario:UsuarioR): Call<Any>

    @GET("/inicioSesion/{id}")
    fun iniciarSesionId(@Path("id") id: Int ): Call<List<Usuario>>

    @GET("/obtenerComedores")
    fun obtenerComedores(): Call<List<Comedores>>

    @POST("/calificarComedor")
    fun calificarComedor(@Body calificacionComedor: Calificacion): Call<Any>

    @GET("/obtenerFamilia/{id}")
    fun obtenerFamilia(@Path("id") id: Int): Call<List<Pariente>>

}