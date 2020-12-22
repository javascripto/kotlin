package com.yuri.KotlinSpring.controller

import com.yuri.KotlinSpring.model.Note
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.yuri.KotlinSpring.repository.NoteRepository

@RestController
@RequestMapping
class NoteController (val noteRepository: NoteRepository) {

    @GetMapping("/")
    fun findAll(): Iterable<Note> =
        noteRepository.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable(value = "id") id: Long): ResponseEntity<Note> {
        return noteRepository.findAllById(id).map { note ->
            ResponseEntity.ok(note)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/")
    fun create(@RequestBody note: Note): Note =
        noteRepository.save(note)

    @PutMapping("/{id}")
    fun update(@PathVariable(value = "id") id: Long, @RequestBody note: Note): ResponseEntity<Note> {
        return noteRepository.findAllById(id).map { note ->
            val copy: Note = note.copy(title = note.title, body = note.body)
            ResponseEntity.ok().body(noteRepository.save(copy))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value = "id") id: Long) =
        noteRepository.deleteById(id)
}
