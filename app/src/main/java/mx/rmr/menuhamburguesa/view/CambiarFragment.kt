package mx.rmr.menuhamburguesa.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import mx.rmr.menuhamburguesa.R
import mx.rmr.menuhamburguesa.databinding.FragmentCambiarBinding
import mx.rmr.menuhamburguesa.databinding.FragmentHomeBinding
import mx.rmr.menuhamburguesa.databinding.FragmentRegistrarseBinding
import mx.rmr.menuhamburguesa.ui.home.HomeViewModel
import mx.rmr.menuhamburguesa.viewmodel.CambiarVM
import mx.rmr.menuhamburguesa.viewmodel.SharedViewModel

class CambiarFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private lateinit var _binding: FragmentCambiarBinding

    private val viewModel: CambiarVM by viewModels()

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentCambiarBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onStart() {
        super.onStart()
        registrarEventos()
    }

    private fun registrarEventos() {

        //Agregar pariente
        binding.btnAgregarPariente.setOnClickListener{
            val idParienteNuevo = binding.etIdPariente.text.toString().toInt()
            viewModel.agregarPariente(idParienteNuevo, sharedViewModel.usuario.value!!.IDUsuario)
            envioExitoso()
        }

        //Cambiar correo
        binding.btnCambiarCorreo.setOnClickListener {
            val correoActualizado = binding.etCorreoActualizado.text.toString()
            if (correoActualizado.contains("@")){
                viewModel.actualizarCorreo(sharedViewModel.usuario.value!!.IDUsuario, correoActualizado)
                envioExitoso()
            } else {
                envioNoExitoso()
            }
        }

        //Cambiar numero
        binding.btnCambiarTelefono.setOnClickListener {
            val numeroActualizado = binding.etTelefonoNuevo.text.toString()
            viewModel.actualizarNumero(sharedViewModel.usuario.value!!.IDUsuario, numeroActualizado)
            envioExitoso()
        }




    }

    private fun envioExitoso() {
        val alerta = AlertDialog.Builder(requireContext())
            .setTitle("Aviso")
            .setMessage("¡Información actualizada exitosamente!")
            .setCancelable(false)
            .setPositiveButton("Aceptar") { _, _ ->
                // Cierra este fragmento y vuelve al anterior
                // requireActivity().supportFragmentManager.popBackStack()
            }
        //.create()
        alerta.show()
    }

    private fun envioNoExitoso() {
        val alerta = AlertDialog.Builder(requireContext())
            .setTitle("Aviso")
            .setMessage("¡El dato ingresado no cumple con el formato!")
            .setCancelable(false)
            .setPositiveButton("Aceptar") { _, _ ->
                // Cierra este fragmento y vuelve al anterior
                // requireActivity().supportFragmentManager.popBackStack()
            }
        //.create()
        alerta.show()
    }


}