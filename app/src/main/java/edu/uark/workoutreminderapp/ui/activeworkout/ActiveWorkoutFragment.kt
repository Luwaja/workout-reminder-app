package edu.uark.workoutreminderapp.ui.activeworkout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import edu.uark.workoutreminderapp.WorkoutApplication
import edu.uark.workoutreminderapp.databinding.FragmentActiveworkoutBinding
import edu.uark.workoutreminderapp.ui.addworkout.AddWorkoutViewModel
import edu.uark.workoutreminderapp.ui.addworkout.AddWorkoutViewModelFactory

class ActiveWorkoutFragment : Fragment() {
    private var _binding: FragmentActiveworkoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val activeWorkoutViewModel: ActiveWorkoutViewModel by viewModels {
        ActiveWorkoutViewModelFactory((requireActivity().application as WorkoutApplication).repository, -1)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val activeWorkoutViewModel =
//            ViewModelProvider(this).get(ActiveWorkoutViewModel::class.java)

        _binding = FragmentActiveworkoutBinding.inflate(inflater, container, false)
        val root: View = binding.root



        val textView: TextView = binding.textActiveworkout
        activeWorkoutViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}