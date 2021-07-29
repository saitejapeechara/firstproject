package com.ibs.demo2.controller

import com.ibs.demo2.model.Coustmers
import com.ibs.demo2.repo.CoustmerRepo
import com.ibs.exceptions.PasswordException
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations
import java.sql.Date

internal class RegistrationControllerTest{
    @InjectMocks
    lateinit var rc:RegistrationController
    @Mock
    lateinit var repo:CoustmerRepo
    lateinit var p:Coustmers
    @BeforeEach
    fun setup() {
        MockitoAnnotations.initMocks(this)
        p = Coustmers(12, "saiteja", "saiteja", "saiteja", 22, Date(1998 - 12 - 23), "male")
        println("inside setup")

    }
    @AfterEach
    fun cleanup(){
        println("inside cleanup")
    }
    @Test
    @DisplayName("pw length greater than 5")
    @Throws(PasswordException::class)
    fun passwordTest1(){
        p.cpassword="password"
        `when`(repo.save(any(Coustmers::class.java))).thenReturn(p)
            rc.details(p)
        assertEquals(8,p.cpassword.length)
    }
    @Test
    @DisplayName("pw length equals to 5")
    @Throws(PasswordException::class)
    fun passwordTest2(){
        p.cpassword="passw"
        `when`(repo.save(any(Coustmers::class.java))).thenReturn(p)
        rc.details(p)
        assertEquals(5,p.cpassword.length)
    }
    @Test
    @DisplayName("pw length equals to 5")
    @Throws(PasswordException::class)
    fun passwordTest3() {
        p.cpassword = "pass"
        assertThrows(Exception::class.java, { -> rc.details(p) }, "password length is less than 5")
    }
}