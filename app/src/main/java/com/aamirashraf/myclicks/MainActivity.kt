package com.aamirashraf.myclicks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.aamirashraf.myclicks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myAdapter= MyAdapter {
            Toast.makeText(this@MainActivity,it.name,Toast.LENGTH_SHORT).show()

        }
        myAdapter.setCallback {
            Toast.makeText(this@MainActivity,it.name,Toast.LENGTH_SHORT).show()
        }
        //in this project we are making the practice for passing the callback in the constructor of the adapter
        setUpRecyclerView()
        loadItemsIntoRecyclerView()
    }
    private fun updateTheList(){

    }
    private fun setUpRecyclerView() = binding.rvMain.apply {
        adapter =myAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun loadItemsIntoRecyclerView() {
        val itemList = listOf(
            Item("Apple"),
            Item("Mango"),
            Item("Banana"),
            Item("Lichi"),
            Item("JackFruit"),
            Item("Chiku"),
            // Add more items as needed
        )

        myAdapter.submitList(itemList)
    }
}