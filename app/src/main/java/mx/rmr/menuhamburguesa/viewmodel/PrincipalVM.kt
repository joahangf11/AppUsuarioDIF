package mx.rmr.menuhamburguesa.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.rmr.menuhamburguesa.model.APIS
import mx.rmr.menuhamburguesa.model.Usuario
import mx.rmr.menuhamburguesa.view.PrincipalFragmentDirections

class PrincipalVM : ViewModel() {

    //
    val usuario = MutableLiveData<Usuario>()

    //Referencia al modelo
    private val registro = APIS()

    fun inicioSesionVM(id: Int){
        registro.iniciarSesionId(id)
        registro.usuario.observeForever(){lista ->
             usuario.value = lista.toTypedArray()[0]
        }
    }
}