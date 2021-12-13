package com.ilal.resep_masak.utilities

import com.ilal.resep_masak.model.Result

class ResepData {

    companion object{
        var dificulty: String = ""
        var key: String = ""
        var portion: String = ""
        var thumb: String = ""
        var times: String = ""
        var title: String = ""

        fun fill(item: Result){
            dificulty = item.dificulty
            key = item.key
            portion = item.portion
            thumb = item.thumb
            times = item.times
            title = item.title
        }
    }
}