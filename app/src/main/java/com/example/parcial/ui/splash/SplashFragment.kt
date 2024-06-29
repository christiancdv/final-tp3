package com.example.parcial.ui.splash

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.parcial.R
import com.example.parcial.databinding.FragmentSplashBinding
import com.example.parcial.ui.listado.ListadoFragment
import com.example.parcial.ui.main.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class SplashFragment : Fragment() {

    private val splashViewModel: com.example.parcial.ui.splash.SplashViewModel by activityViewModels()
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = SplashFragment()
    }

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        splashViewModel.navigateToMain.observe(viewLifecycleOwner, Observer { navigate ->
            if (navigate) {
                // Transition to MainFragment
                parentFragmentManager.beginTransaction()
                    .replace(R.id.nav_host, ListadoFragment())
                    .commit()
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        (activity as? MainActivity)?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)?.visibility =
            View.GONE
    }

    override fun onPause() {
        super.onPause()
        (activity as? MainActivity)?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)?.visibility =
            View.VISIBLE
    }
}