package cy.nup.g4ultimatemobile.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cy.nup.g4ultimatemobile.R
import cy.nup.g4ultimatemobile.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textHome: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textHome.text = it
//        }

        val textBalance = binding.textBalance
        homeViewModel.textBalance.observe(viewLifecycleOwner) {
            textBalance.text = it
        }

        val textMinutes = binding.textMinutes
        homeViewModel.textMinutes.observe(viewLifecycleOwner) {
            textMinutes.text = it
        }

        val textSms = binding.textSms
        homeViewModel.textSms.observe(viewLifecycleOwner) {
            textSms.text = it
        }

        val textInternet = binding.textInternet
        homeViewModel.textInternet.observe(viewLifecycleOwner) {
            textInternet.text = it
        }

        val progressMinutes = binding.progressMinutes
        homeViewModel.progressMinutes.observe(viewLifecycleOwner) {
            progressMinutes.progress = it
        }

        val progressSms = binding.progressSms
        homeViewModel.progressSms.observe(viewLifecycleOwner) {
            progressSms.progress = it
        }

        val progressInternet = binding.progressInternet
        homeViewModel.progressInternet.observe(viewLifecycleOwner) {
            progressInternet.progress = it
        }

        val textPackage = binding.textPackage
        homeViewModel.textPackage.observe(viewLifecycleOwner) {
            textPackage.text = it
        }

        homeViewModel.transactionLayoutInit(binding.transactionLayout, context)

        val popUpButton = binding.popUpButton
        popUpButton.setOnClickListener {
            switchLayout(inflater, container)
        }

        return root
    }

    private fun switchLayout(inflater: LayoutInflater, container: ViewGroup?) {
            // Inflate the alternate layout manually
            val alternateView = inflater.inflate(R.layout.popup_layout, container, false)
            _binding?.root?.removeAllViews()
            _binding?.root?.addView(alternateView)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}