package com.ilal.resep_masak.fragment.detail

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ilal.resep_masak.R
import com.ilal.resep_masak.utilities.ResepData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_resep_detail.*

class ResepDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resep_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get()
            .load(ResepData.thumb)
            .into(imgResepDetail)
        tvResepJudul.text = ResepData.title
        tvKesulitan.text = ResepData.dificulty
        tvPorsi.text = ResepData.portion
        tvWaktu.text = ResepData.times

        btnShare.setOnClickListener{
            val intent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, " _${ResepData.title}_ yang dimasak selama *${ResepData.times}* dan cukup untuk *${ResepData.portion}* dengan tingkat kesulitan *${ResepData.dificulty}* ")
                type = "text/plain"
            }
            val i = Intent.createChooser(intent, null)
            startActivity(i)
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            ResepDetailFragment()
    }
}