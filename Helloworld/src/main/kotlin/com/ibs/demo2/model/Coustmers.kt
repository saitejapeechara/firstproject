package com.ibs.demo2.model

import java.sql.Date
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
@Entity
data class Coustmers(
    @Id
    val cid:Int=0,
    val cname:String="",
    val cusername:String="",
    var cpassword:String="",
    val cage:Int=0,
    val cdob:Date=Date(0),
    val cgender:String="") {
    override fun toString(): String {
        return "Coustmers(cdob=$cdob)"
    }

}


