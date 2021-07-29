package com.ibs.demo2.repo

import com.ibs.demo2.model.Coustmers
import org.springframework.data.repository.CrudRepository

interface CoustmerRepo :CrudRepository<Coustmers,Integer> {
}