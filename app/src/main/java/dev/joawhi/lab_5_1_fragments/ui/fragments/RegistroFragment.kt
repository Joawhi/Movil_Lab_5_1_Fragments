package dev.joawhi.lab_5_1_fragments.ui.fragments

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import dev.joawhi.lab_5_1_fragments.R

class RegistroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_registro, container, false)

        val btSave: Button = view.findViewById(R.id.btnSave)
        val etFullName: EditText = view.findViewById(R.id.etFullName)
        val etEmail: EditText = view.findViewById(R.id.etEmail)
        val spCountry: Spinner = view.findViewById(R.id.spCountry)
        val rdGender: RadioGroup = view.findViewById(R.id.rgGender)
        val ckLicense: CheckBox = view.findViewById(R.id.ckLicense)
        val ckCar: CheckBox = view.findViewById(R.id.ckCar)

        //Loading Spinner
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.country_array,
            android.R.layout.simple_spinner_item
            ).also { adapter -> adapter.
                setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spCountry.adapter = adapter
            }

        var spCountryValue = ""
        spCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                spCountryValue = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        btSave.setOnClickListener{
            var fullNameValue = etFullName.text
            var emaliValue = etEmail.text
            var intSelectedButton = rdGender!!.checkedRadioButtonId
            var rbSelected: RadioButton = view.findViewById(intSelectedButton)
            var genderValue = rbSelected.text
            var countryValue = spCountryValue
            var licenseValue = ckLicense.isChecked
            var carValue = ckCar.isChecked

            val allValues = "Full name: $fullNameValue \n" +
                            "Email: $emaliValue \n" +
                            "Gender: $genderValue \n" +
                            "Country: $countryValue \n" +
                            "License: $licenseValue \n" +
                            "Car: $carValue"

            Toast.makeText(requireContext(), allValues, Toast.LENGTH_LONG).show()

        }

        return view
    }

}