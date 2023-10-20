package mx.rmr.menuhamburguesa.model

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIS {


    //LiveData
    val usuario = MutableLiveData<List<Usuario>>()
    val comedores = MutableLiveData<List<Comedores>>()
    val parientes = MutableLiveData<List<Pariente>>()

    //El objeto retrofit
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://44.217.43.137:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Crea el objeto que instancia al objeto que hara la descarga de datos
    private val descargarAPI by lazy {
        retrofit.create(ListaServiciosApi::class.java)
    }

    fun registrarUsuario(nuevoUsuario: UsuarioR) {
        val call = descargarAPI.registrarUsuario(nuevoUsuario)
        call.enqueue(object: Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful){
                    println("RESPUESTA: ${response.body()}")
                } else {
                    println("Error en la descarga ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                println("ERROR: ${t.localizedMessage}")
            }
        })
    }

    /////


    fun iniciarSesionId(id: Int) {
        val call = descargarAPI.iniciarSesionId(id)
        call.enqueue(object: Callback<List<Usuario>> {
            override fun onResponse(call: Call<List<Usuario>>, response: Response<List<Usuario>>) {
                if (response.isSuccessful){
                    println("RESPUESTA: ${response.body()}")
                    usuario.value = response.body()
                } else {
                    println("Error en la descarga ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<Usuario>>, t: Throwable) {
                println("ERROR: ${t.localizedMessage}")
            }
        })
    }


    /////////

    fun obtenerComedores(){
        val call = descargarAPI.obtenerComedores()
        call.enqueue(object: Callback<List<Comedores>>{
            override fun onResponse(call: Call<List<Comedores>>, response: Response<List<Comedores>>) {
                if (response.isSuccessful){
                    comedores.value = response.body()
                } else{
                    println("Error en la descarga ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<Comedores>>, t: Throwable) {
                println("ERROR: ${t.localizedMessage}")
            }
        })
    }

    /////////

    fun calificarComedor(calificacionComedor: Calificacion){
        val call = descargarAPI.calificarComedor(calificacionComedor)
        call.enqueue(object: Callback<Any>{
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful){
                    println("NICE")
                } else{
                    println("Error en la descarga ${response.errorBody()}")
                }
            }
            override fun onFailure(call: Call<Any>, t: Throwable) {
                println("ERROR: ${t.localizedMessage}")
            }
        })
    }

    ////////

    fun obtenerFamilia(id: Int){
        val call = descargarAPI.obtenerFamilia(id)
        call.enqueue(object: Callback<List<Pariente>>{
            override fun onResponse(
                call: Call<List<Pariente>>,
                response: Response<List<Pariente>>
            ) {
                if (response.isSuccessful){
                    parientes.value = response.body()
                } else{
                    println("Error en la descarga ${response.errorBody()}")
                }
            }
            override fun onFailure(call: Call<List<Pariente>>, t: Throwable) {
                println("ERROR: ${t.localizedMessage}")
            }
        })
    }

}