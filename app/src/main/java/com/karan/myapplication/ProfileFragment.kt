package com.karan.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.karan.myapplication.data.Preferences
import com.karan.myapplication.data.Repository
import com.karan.myapplication.data.User
import com.karan.myapplication.databinding.FragmentProfileBinding
import javax.inject.Inject

class ProfileFragment : Fragment() {

    @Inject
    lateinit var user: User

    @Inject
    lateinit var preferences: Preferences

    @Inject
    lateinit var repository: Repository

    private var binding: FragmentProfileBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).activityComponent.profileComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false).apply {
            userBtn.setOnClickListener(::printUser)
            printPref.setOnClickListener {
                preferences.printInstance()
            }
            printRepository.setOnClickListener {
                repository.printInstance()
            }
        }
        return binding?.root
    }

    private fun printUser(view: View) {
        user.printInstance()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
