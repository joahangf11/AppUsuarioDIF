package mx.rmr.menuhamburguesa.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.rmr.menuhamburguesa.R
import mx.rmr.menuhamburguesa.viewmodel.CambiarVM

class CambiarFragment : Fragment() {

    companion object {
        fun newInstance() = CambiarFragment()
    }

    private lateinit var viewModel: CambiarVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_cambiar, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CambiarVM::class.java)
        // TODO: Use the ViewModel
    }

}