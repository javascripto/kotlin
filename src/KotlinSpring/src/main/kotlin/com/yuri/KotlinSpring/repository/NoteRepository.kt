package com.yuri.KotlinSpring.repository

import com.yuri.KotlinSpring.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository: CrudRepository<Note, Long> {

}