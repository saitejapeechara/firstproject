package com.ibs.demo2.controller

import com.ibs.exceptions.AgeException
import com.ibs.exceptions.PasswordException
import com.ibs.demo2.model.Coustmers
import com.ibs.demo2.repo.CoustmerRepo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import java.util.*
import java.util.stream.Stream


@Controller
class RegistrationController {
    var log : Logger = LoggerFactory.getLogger(RegistrationController::class.java)
    @Autowired
    lateinit var repo:CoustmerRepo
    @RequestMapping("/")
    fun details():String
    {
        return "registration"
    }
    @RequestMapping("/details")
    fun details(coustmers:Coustmers):String{
        try {
            val PasswordLength: Int = coustmers.cpassword.length
            if (PasswordLength < 5) {
                println("in sufficient length")
                log.error("in sufficient length")
                throw  PasswordException("length is less than 5")
            }
            val AgeLimit = coustmers.cage
            if (AgeLimit < 18) {
                println("age is below limit")
                log.error("age is below limit")
                throw AgeException("age is below limit")
            }


            repo.save(coustmers)
        }
       //catch(e:PasswordException){
       // println("error"+e.message)
        //}
        catch(e:AgeException){
            println("error"+e.message)
        }
        return "registration"
    }
    @RequestMapping("/getdetails")
        fun getdetails():String{
            return "viewcoustmer";
        }
       @PostMapping("/getdetails")
        fun getdetails(@RequestParam cid:Int):ModelAndView{
           val coustmers:Coustmers
           var mv = ModelAndView("retrive")
           val coustmerlist: List<Coustmers> = repo.findAll() as List<Coustmers>
          // val person:(Coustmers)->Boolean={coustmers:Coustmers->coustmers.cid==(cid)}
           val matchingCoustmer: Optional<Coustmers> =coustmerlist.stream().filter { p->p.cid==(cid) }.findFirst()
           if(matchingCoustmer.isPresent)
           {
               coustmers=matchingCoustmer.get()
               println("successfully found")
               log.info("${coustmers.cusername} successfully  found")
               mv.addObject(coustmers)
           }
           else
           {
               coustmers=matchingCoustmer.orElse(null)
               println("not found")
               log.info("${coustmers.cname} you have entered wrong credentials")

               mv.setViewName("viewcoustmers")
           }
           return mv;
        }


}