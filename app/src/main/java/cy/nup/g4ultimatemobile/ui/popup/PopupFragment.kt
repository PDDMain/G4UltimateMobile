package cy.nup.g4ultimatemobile.ui.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cy.nup.g4ultimatemobile.R
import cy.nup.g4ultimatemobile.data.repository.UserRepositoryProvider
import cy.nup.g4ultimatemobile.databinding.PopupLayoutBinding

class PopupFragment : Fragment() {
    private val userRepository by lazy { UserRepositoryProvider.userRepository }

    private var _binding: PopupLayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = PopupLayoutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.submitButton.setOnClickListener {
            val amount: Long = binding.amountEditText.text.toString().toLongOrNull() ?: 0L
            // check bank balance
            userRepository.popUp(amount)

            switchToHomeFragment(inflater, container)
        }

        return root
    }

    private fun switchToHomeFragment(inflater: LayoutInflater, container: ViewGroup?) {
        val alternateView = inflater.inflate(R.layout.fragment_home, container, false)
        _binding?.root?.removeAllViews()
        _binding?.root?.addView(alternateView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
