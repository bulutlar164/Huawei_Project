package com.example.huwaei_ilkproje

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.util.regex.Matcher
import java.util.regex.Pattern


class singUpFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sing_up, container, false)

        // Tanımlar
        val textAd = view.findViewById<TextView>(R.id.editTextAd)
        val textSoyAd = view.findViewById<TextView>(R.id.editTextSoyAd)
        val textEmail = view.findViewById<TextView>(R.id.editTextEmail)
        val textSifre = view.findViewById<TextView>(R.id.editTextTextSifre)
        val checkBoxKVK = view.findViewById<CheckBox>(R.id.checkBoxKvk)
        val buttonKayit = view.findViewById<Button>(R.id.buttonKaydet)
        //

        //Action
        val action = singUpFragmentDirections.actionSingUpFragmentToSiparisDetay()

        //

        buttonKayit.setOnClickListener(){
            //Check Ad
            if(textAd.text.toString() != "")
            {
                //Check SoyAd
               if(textSoyAd.text.toString() != "")
               {
                   //Check Email
                   if(emailValidator(textEmail.text.toString()))
                   {
                       //Check Sifre
                       if(textSifre.text != null)
                       {
                           //Check KVK
                           if(checkBoxKVK.isChecked)
                           {
                               findNavController().navigate(action)

                           }
                           else
                           {
                               Toast.makeText(activity,"KVK Aydınlatma Metnini Onaylayın",Toast.LENGTH_SHORT).show()
                           }

                       }
                       else
                       {
                           Toast.makeText(activity,"Şifre Giriniz",Toast.LENGTH_SHORT).show()
                       }

                   }
                   else
                   {
                       Toast.makeText(activity,"Email Giriniz",Toast.LENGTH_SHORT).show()
                   }

               }
               else
               {
                   Toast.makeText(activity,"SoyAdınızı Giriniz",Toast.LENGTH_SHORT).show()
               }

            }
            else
            {
                Toast.makeText(activity,"Adınızı Giriniz",Toast.LENGTH_SHORT).show()
            }
        }






        return view

    }

    fun emailValidator(email: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val EMAIL_PATTERN =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@yalova.edu.tr"
        pattern = Pattern.compile(EMAIL_PATTERN)
        matcher = pattern.matcher(email)
        return matcher.matches()
    }

}