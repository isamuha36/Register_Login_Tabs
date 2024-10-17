package com.isamuha.register_login_tabs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.isamuha.register_login_tabs.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val usernameInput = binding.usernameLoginTextInputEditText.text.toString()
            val passwordInput = binding.passwordLoginTextInputEditText.text.toString()

            val sharedPref = activity?.getSharedPreferences("user_pref", Context.MODE_PRIVATE)
            val savedUsername = sharedPref?.getString("username", "")
            val savedPassword = sharedPref?.getString("password", "")

            if (usernameInput == savedUsername && passwordInput == savedPassword) {
                Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, HomePageActivity::class.java)
                intent.putExtra("EXTRA_USERNAME", usernameInput)
                startActivity(intent)
                activity?.finish()
            } else {
                // Jika gagal, tampilkan pesan error
                Toast.makeText(context, "Login failed, check your credentials", Toast.LENGTH_SHORT).show()
            }
        }

        binding.register.setOnClickListener {
            val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
            viewPager?.currentItem = 0
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}