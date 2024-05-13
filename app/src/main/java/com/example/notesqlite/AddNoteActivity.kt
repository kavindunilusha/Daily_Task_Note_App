package com.example.notesqlite

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notesqlite.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding:ActivityAddNoteBinding
    private lateinit var db:NotesDatabaseHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEditText.text.toString().trim()
            val content = binding.contentEditText.text.toString().trim()

            if (title.isEmpty()) {
                binding.titleEditText.error = "Title cannot be empty"
                return@setOnClickListener
            }

            if (content.isEmpty()) {
                binding.contentEditText.error = "Content cannot be empty"
                return@setOnClickListener
            }

            val note = Note(0, title, content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note Saved.", Toast.LENGTH_SHORT).show()
        }
        }


    }
