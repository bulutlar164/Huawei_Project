package com.example.huwaei_ilkproje

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide


class siparisDetay : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_siparis_detay, container, false)

        //
        val KullaniciAdi = view.findViewById<TextView>(R.id.textViewKullanciAdi)
        val KullaniciEmail = view.findViewById<TextView>(R.id.textView12)
        val KullaniciResim = view.findViewById<ImageView>(R.id.imageViewKullaniciResim)
        val YemekImage1 = view.findViewById<ImageView>(R.id.imageView7)
        val YemekImage2 = view.findViewById<ImageView>(R.id.imageView8)



        val KiymaliKücük = view.findViewById<RadioButton>(R.id.radioButtonKiymaliKücük)
        val KiymaliOrta = view.findViewById<RadioButton>(R.id.radioButtonKiymaliOrta)
        val KiymaliBüyük = view.findViewById<RadioButton>(R.id.radioButtonKiymaliBüyük)

        val KasarliKücük = view.findViewById<RadioButton>(R.id.radioButtonKasarliKücük)
        val KasarliKOrta = view.findViewById<RadioButton>(R.id.radioButtonKasarliOrta)
        val KasarliBüyük = view.findViewById<RadioButton>(R.id.radioButtonKasarliBüyük)

        val Sonuc = view.findViewById<TextView>(R.id.textView16)

        val HesaplaButton = view.findViewById<Button>(R.id.button2)
        //


        //Resimler
        Glide.with(this).load("https://i.picsum.photos/id/486/200/200.jpg?hmac=edugbZ0GU8cJ5l4RXA5Lwg9YRoMns_UergIvkxbY5-w").into(KullaniciResim)
        Glide.with(this).load("https://i.picsum.photos/id/493/200/200.jpg?hmac=gTkCS4bzTaN0S0X4DVmbvEYkY0QxwyorqWjnxVNHtgg").into(YemekImage1)
        Glide.with(this).load("https://i.picsum.photos/id/517/200/200.jpg?hmac=7n69zdD4qSZs14zMRZPUfLGKHFEIR9jTpoSEN1o990E").into(YemekImage2)

        //Argument
        arguments?.let {
            val kullaniciAdi = siparisDetayArgs.fromBundle(it).adsoyad
            val email = siparisDetayArgs.fromBundle(it).email

            println(email)
            println(kullaniciAdi)

            KullaniciAdi.text = kullaniciAdi
            KullaniciEmail.text = email
        }

        HesaplaButton.setOnClickListener(){

            //Resimlerin pide ile bir ilgisi yok ama oruçluyum ve canım pide istiyor

            var kasarli = 0
            var kiymali = 0

            var kasarli_fiyat = 0
            var kiymali_fiyat = 0

            //Kiymali
            if(KiymaliKücük.isChecked)
            {
                kiymali = 1
                kiymali_fiyat = 10
               // Toast.makeText(activity,"kücük olan secildi",Toast.LENGTH_LONG).show()
            }
            else if(KiymaliOrta.isChecked)
            {
                kiymali =1
                kiymali_fiyat=20
                //Toast.makeText(activity,"orta olan secildi",Toast.LENGTH_LONG).show()
            }
            else if(KiymaliBüyük.isChecked)
            {
                kiymali =1
                kiymali_fiyat=30
               // Toast.makeText(activity,"büyük olan secildi",Toast.LENGTH_LONG).show()
            }


            //Kasarli
            if(KasarliKücük.isChecked)
            {
                kasarli = 1
                kasarli_fiyat = 100
                //Toast.makeText(activity,"kücük olan secildi",Toast.LENGTH_LONG).show()
            }
            else if(KasarliKOrta.isChecked)
            {
                kasarli = 1
                kasarli_fiyat = 200
               // Toast.makeText(activity,"orta olan secildi",Toast.LENGTH_LONG).show()
            }
            else if(KasarliBüyük.isChecked)
            {
                kasarli = 1
                kasarli_fiyat = 300
                //Toast.makeText(activity,"büyük olan secildi",Toast.LENGTH_LONG).show()
            }

            if (kiymali == 0)
            {
                Toast.makeText(activity, "Tatlı Seçiniz", Toast.LENGTH_SHORT).show()
            }
            else if(kasarli == 0)
            {
                Toast.makeText(activity, "Portakal Seçiniz", Toast.LENGTH_SHORT).show()
            }


            if(kiymali == 1 && kasarli ==1)
            {
                Sonuc.text = "Ödemeniz Gereken Ücret : ${kiymali_fiyat+kasarli_fiyat}"
            }









        }



        return  view
    }



}