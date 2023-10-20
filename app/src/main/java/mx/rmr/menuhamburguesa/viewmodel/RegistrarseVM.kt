package mx.rmr.menuhamburguesa.viewmodel

import androidx.lifecycle.ViewModel
import mx.rmr.menuhamburguesa.model.APIS
import mx.rmr.menuhamburguesa.model.Usuario
import mx.rmr.menuhamburguesa.model.UsuarioR

class RegistrarseVM : ViewModel() {

    //modelo
    private val registro = APIS()
    fun resgitrarUsuarioVM(nuevoUsuario: UsuarioR){
        registro.registrarUsuario(nuevoUsuario)
    }

}