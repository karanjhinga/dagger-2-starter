package com.karan.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.karan.myapplication.data.FirebaseAuth
import com.karan.myapplication.data.Preferences
import com.karan.myapplication.data.Repository
import com.karan.myapplication.databinding.FragmentLoginBinding
import javax.inject.Inject

class LoginFragment : Fragment() {

    @Inject
    lateinit var firebaseAuth: FirebaseAuth

    @Inject
    lateinit var preferences: Preferences

    @Inject
    lateinit var repository: Repository

    private var binding: FragmentLoginBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).activityComponent.loginComponent().create().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false).apply {
            printFirebase.setOnClickListener(::printFirebaseAuth)
            printPref.setOnClickListener {
                preferences.printInstance()
            }
            printRepository.setOnClickListener {
                repository.printInstance()
            }
        }
        return binding?.root
    }

    private fun printFirebaseAuth(view: View) {
        firebaseAuth.printInstance()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
