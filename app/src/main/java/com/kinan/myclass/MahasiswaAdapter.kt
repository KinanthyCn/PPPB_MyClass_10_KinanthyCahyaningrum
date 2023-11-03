package com.kinan.myclass

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kinan.myclass.databinding.ItemMahasiswaBinding


typealias OnClickMahasiswa = (Mahasiswa) -> Unit
class MahasiswaAdapter(
    private val listMahasiswa: List<Mahasiswa>,
    private val onClickMahasiswa: OnClickMahasiswa
):
    RecyclerView.Adapter<MahasiswaAdapter.ItemMahasiswaViewHolder>(){
        inner class ItemMahasiswaViewHolder(private val binding: ItemMahasiswaBinding)
            : RecyclerView.ViewHolder(binding.root){
            fun bind(data: Mahasiswa){
                with(binding){
                    mahasiswaNameTxt.text = data.name
                    nimTxt.text = data.nim
                    nilaiIpkTxt.text = data.ipk.toString()
                    if (data.ipk == 4.0) {
                        nilaiIpkTxt.setTextColor(Color.parseColor("#87CEFA"))
                    } else if (data.ipk >= 3.8) {
                        nilaiIpkTxt.setTextColor(Color.parseColor("#66CDAA"))
                    } else if (data.ipk >= 3.5) {
                        nilaiIpkTxt.setTextColor(Color.parseColor("#FFA500"))
                    } else if (data.ipk >= 3.0) {
                        nilaiIpkTxt.setTextColor(Color.parseColor("#DB7093"))
                    }
                    else {
                        nilaiIpkTxt.setTextColor(Color.parseColor("#FF0000"))
                    }
                    imageMahasiswa.setImageResource(data.imageResId)

                    itemView.setOnClickListener {
                        onClickMahasiswa(data)
                    }
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMahasiswaViewHolder {
            val binding = ItemMahasiswaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false)
            return ItemMahasiswaViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return listMahasiswa.size
        }

        override fun onBindViewHolder(holder: ItemMahasiswaViewHolder, position: Int) {
            holder.bind(listMahasiswa[position])
        }
    }

