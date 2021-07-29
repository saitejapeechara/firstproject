package com.ibs.demo2.controller

import com.ibs.demo2.model.Coustmers
import com.ibs.demo2.repo.CoustmerRepo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
@Controller
class LoginController {
    var log : Logger = LoggerFactory.getLogger(LoginController::class.java)
    @Autowired
    lateinit var repo: CoustmerRepo
    @RequestMapping("/login")
    fun login():String{
        return "login"
    }
    @PostMapping("/login")
    fun login(@RequestParam cid:Integer,@RequestParam cusername:String,@RequestParam cpassword:String):ModelAndView{
        var mv=ModelAndView();
         var coustmers: Coustmers=repo.findById(cid).orElse(null)
        if((coustmers.cpassword.equals(cpassword))&&(coustmers.cusername.equals(cusername)))
            {
                println("successful login")
                log.info("${coustmers.cname} successfully logged in")
            }
                else
                {
                    println("unsuccessful login")
                    log.info("${coustmers.cname} unsuccessful login")
                }
            return mv
    }
}