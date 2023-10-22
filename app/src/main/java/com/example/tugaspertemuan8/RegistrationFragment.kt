package com.example.tugaspertemuan8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tugaspertemuan8.databinding.FragmentRegistrationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private  var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    companion object {
        var username: String? = "Admin"
        var password: String? = "Admin"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        val view = binding.root

        with(binding){
            RegButton.setOnClickListener{
                if (RegUsername.text!!.isEmpty()){
                    RegUsername.error = "Username harus diisi"
                } else if (RegEmail.text!!.isEmpty()) {
                    RegEmail.error = "Alamat email harus diisi"
                } else if (RegPhone.text!!.isEmpty()){
                    RegPhone.error = "Nomor telepon harus diisi"
                } else if (RegPassword.text!!.isEmpty()){
                    RegPassword.error = "Password harus diisi"
                } else if (!RegCheckbox.isChecked){
                    Toast.makeText(this@RegistrationFragment.requireActivity(),
                        "Anda harus menyetujui syarat dan ketentuan",
                        Toast.LENGTH_SHORT).show()
                } else {
                    username = RegUsername.text.toString()
                    password = RegPassword.text.toString()

                    RegUsername.text?.clear()
                    RegPhone.text?.clear()
                    RegEmail.text?.clear()
                    RegPassword.text?.clear()
                    RegCheckbox.isChecked = false

                    Toast.makeText(this@RegistrationFragment.requireActivity(), "Registrasi berhasil", Toast.LENGTH_SHORT).show()
                    (requireActivity() as? LogRegActivity)?.switchFragment(1)
                }
            }

            RegHaveAccountLink.setOnClickListener{
                (requireActivity() as? LogRegActivity)?.switchFragment(1)
            }
        }

        // Inflate the layout for this fragment
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}