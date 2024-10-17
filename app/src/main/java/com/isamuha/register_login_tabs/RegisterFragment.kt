package com.isamuha.register_login_tabs

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.isamuha.register_login_tabs.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private var _binding : FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val usernameInput = binding.usernameRegisterTextInputEditText.text.toString()
            val emailInput = binding.emailRegisterTextInputEditText.text.toString()
            val phoneInput = binding.phoneRegisterTextInputEditText.text.toString()
            val passwordInput = binding.passwordRegisterTextInputEditText.text.toString()

            if (validateInput(usernameInput, emailInput, phoneInput, passwordInput) && binding.checkboxByChecking.isChecked) {
                val sharedPref = activity?.getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                val editor = sharedPref?.edit()
                editor?.putString("username", usernameInput)
                editor?.putString("email", emailInput)
                editor?.putString("phone", phoneInput)
                editor?.putString("password", passwordInput)
                editor?.apply()
                Toast.makeText(context, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
                viewPager?.currentItem = 1

            }  else if (!binding.checkboxByChecking.isChecked) {
                Toast.makeText(
                    context,
                    "Harap Setuju Seluruh Permintaan",
                    Toast.LENGTH_SHORT
                ).show()
            }else {
                Toast.makeText(context, "Tolong Isi Semua Data", Toast.LENGTH_SHORT).show()
            }
        }

        binding.logIn.setOnClickListener {
            val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
            viewPager?.currentItem = 1
        }
    }

    private fun validateInput(username: String, email: String, phone: String, password: String): Boolean {
        return username.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() && password.isNotEmpty()
    }

    override fun onPause() {
        super.onPause()
        // Kosongkan input field saat fragment pindah
        binding.usernameRegisterTextInputEditText.setText("")
        binding.emailRegisterTextInputEditText.setText("")
        binding.phoneRegisterTextInputEditText.setText("")
        binding.passwordRegisterTextInputEditText.setText("")
        binding.checkboxByChecking.isChecked = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}