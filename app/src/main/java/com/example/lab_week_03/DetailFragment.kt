package com.example.lab_week_03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil coffee ID dari arguments
        val coffeeId = arguments?.getInt("COFFEE_ID", 0) ?: 0
        setCoffeeData(coffeeId)

        // Set click listener untuk back button
        view.findViewById<Button>(R.id.button2)?.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    private fun setCoffeeData(id: Int) {
        view?.let { fragmentView ->
            val coffeeTitle = fragmentView.findViewById<TextView>(R.id.coffee_title)
            val coffeeDesc = fragmentView.findViewById<TextView>(R.id.coffee_desc)

            when (id) {
                R.id.affogato -> {
                    coffeeTitle?.text = getString(R.string.affogato_title)
                    coffeeDesc?.text = getString(R.string.affogato_desc)
                }
                R.id.americano -> {
                    coffeeTitle?.text = getString(R.string.americano_title)
                    coffeeDesc?.text = getString(R.string.americano_desc)
                }
                R.id.latte -> {
                    coffeeTitle?.text = getString(R.string.latte_title)
                    coffeeDesc?.text = getString(R.string.latte_desc)
                }
                R.id.cappuccino -> {  // Case baru
                    coffeeTitle?.text = getString(R.string.cappuccino)
                    coffeeDesc?.text = getString(R.string.cappuccino_desc)
                }
                R.id.macchiato -> {   // Case baru
                    coffeeTitle?.text = getString(R.string.macchiato)
                    coffeeDesc?.text = getString(R.string.macchiato_desc)
                }
            }
        }
    }

    companion object {
        fun newInstance(coffeeId: Int): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putInt("COFFEE_ID", coffeeId)
            fragment.arguments = args
            return fragment
        }
    }
}