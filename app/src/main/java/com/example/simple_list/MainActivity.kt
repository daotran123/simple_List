package com.example.simple_list

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val number = findViewById<EditText>(R.id.number)
        val radioSelect = findViewById<RadioGroup>(R.id.radio)
        val submit = findViewById<Button>(R.id.submit)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)

        var items = mutableListOf<ItemModel>()
        val adapter = ItemAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        submit.setOnClickListener {
            val numberText = number.text.toString()
            val numberInt = try {
                numberText.toInt()
            } catch (e: NumberFormatException) {
                0 // giá trị mặc định nếu người dùng nhập không phải là số
            }

            items.clear() // Xóa danh sách để tránh thêm trùng lặp

            val selected = radioSelect.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(selected)

            if (radioButton.id == R.id.button1) {
                var i = 0
                while (i <= numberInt) {
                    items.add(ItemModel(i))
                    i += 2
                }
            } else if (radioButton.id == R.id.button2) {
                var i = 1
                while (i <= numberInt) {
                    items.add(ItemModel(i))
                    i += 2
                }
            } else {
                var i = 0
                while (i * i <= numberInt) {
                    items.add(ItemModel(i * i))
                    i += 1
                }
            }
            adapter.notifyDataSetChanged() // Thông báo RecyclerView cập nhật dữ liệu mới
        }
    }
}
