package com.ilal.resep_masak.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilal.resep_masak.R
import com.ilal.resep_masak.fragment.detail.ResepDetailFragment
import com.ilal.resep_masak.model.Result
import com.ilal.resep_masak.utilities.ResepData
import kotlinx.android.synthetic.main.fragment_resep.*

class ResepFragment : Fragment() {

    lateinit var resepViewModel: ResepViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ResepFragment", "onCreate dipanggil")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("ResepFragment", "onCreateView dipanggil")
        resepViewModel = ViewModelProvider(this).get(ResepViewModel::class.java)
        return inflater.inflate(R.layout.fragment_resep, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvResep.setHasFixedSize(true)
        rvResep.layoutManager = LinearLayoutManager(context)
        resepViewModel.getDataFromApi(rvResep,progressBar, object : ResepViewModel.OnAdapterListener {
            override fun onClick(item: Result) {
                ResepData.fill(item)
                activity?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.container, ResepDetailFragment())
                    ?.addToBackStack(null)
                    ?.commit()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ResepFragment", "onDestroy dipanggil")
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResepFragment()
    }
}