package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ListFragment : Fragment(), View.OnClickListener {
    private lateinit var coffeeListener: CoffeeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is CoffeeListener) {
            coffeeListener = context
        } else {
            throw RuntimeException("Must implement CoffeeListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set click listeners untuk setiap coffee item
        view.findViewById<View>(R.id.affogato)?.setOnClickListener(this)
        view.findViewById<View>(R.id.americano)?.setOnClickListener(this)
        view.findViewById<View>(R.id.latte)?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        coffeeListener.onSelected(v.id)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}