package com.kinan.myclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kinan.myclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar_ku))

        val adapterMahasiwa = MahasiswaAdapter(generateMahasiswa()){
            mahasiswa ->
            Toast.makeText(this@MainActivity, "Hei! you clicked on ${mahasiswa.name}",
                Toast.LENGTH_SHORT).show()

        }

        with(binding){
            rvMahasiswa.apply {
                adapter = adapterMahasiwa
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
    fun generateMahasiswa() : List<Mahasiswa> {

        return listOf(
            Mahasiswa("Kinanthy Cahyaningrum", "22/494423/SV/20815",3.80, R.drawable.img1),
            Mahasiswa("Ashila istri Mark", "22/493981/SV/20767",3.72, R.drawable.img2),
            Mahasiswa("Salma Nur Azizah", "22/500150/SV/24323", 3.67, R.drawable.img3),
            Mahasiswa("Aminah Nurul Huda", "22/498784/SV/13468", 3.75, R.drawable.img4),
            Mahasiswa("Ryvalino Dhanu", "22/500151/SV/142353", 4.0, R.drawable.img5),
            Mahasiswa("Erlangga Syifa", "22/491232/SV/12335", 3.9, R.drawable.img6),
            Mahasiswa("Adiel Boanerge Ganan", "22/500152/SV/12345", 4.0, R.drawable.img7),
            Mahasiswa("Afra Cendekia", "22/4945321/SV/12346", 3.5, R.drawable.img8),
            Mahasiswa("Aldi Coboy Junior", "22/500152/SV/12343", 2.75, R.drawable.img9),


            )
    }

}