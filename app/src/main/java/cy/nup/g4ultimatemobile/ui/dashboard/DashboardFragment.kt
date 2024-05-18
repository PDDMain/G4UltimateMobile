package cy.nup.g4ultimatemobile.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cy.nup.g4ultimatemobile.data.model.PackageType
import cy.nup.g4ultimatemobile.data.repository.UserRepositoryProvider
import cy.nup.g4ultimatemobile.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private val userRepository by lazy { UserRepositoryProvider.userRepository }

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val buttonSelectBasic: Button = binding.buttonSelectBasic
        val buttonSelectAdvanced: Button = binding.buttonSelectAdvanced
        val buttonSelectVip: Button = binding.buttonSelectVip
        buttonSelectBasic.setOnClickListener {
            userRepository.setPackage(PackageType.BASIC)
        }
        buttonSelectAdvanced.setOnClickListener {
            userRepository.setPackage(PackageType.ADVANCED)
        }
        buttonSelectVip.setOnClickListener {
            userRepository.setPackage(PackageType.VIP)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}