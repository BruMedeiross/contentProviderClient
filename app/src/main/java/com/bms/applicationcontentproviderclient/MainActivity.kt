package com.bms.applicationcontentproviderclient

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.iid.FirebaseInstanceIdReceiver
import com.google.firebase.installations.FirebaseInstallations

class MainActivity : AppCompatActivity() {


    lateinit var notesRecycler: RecyclerView
    lateinit var notesRefreshButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesRefreshButton = findViewById(R.id.client_button_refresh)
        notesRecycler = findViewById(R.id.client_list)
        getContentProvider()

        notesRefreshButton.setOnClickListener {
            this.showNotification("1234", "ATUALIZADO SEU APP", "Atualização")
            getContentProvider()
           }


    }

    private fun getContentProvider(){
        try{
            val url = "content://com.bms.notecontentprovider.provider/notes"
            val data  = Uri.parse(url)
            val cursor: Cursor? =
                contentResolver.query(data,null,
                    null, null,"title")
            notesRecycler.apply{
                layoutManager= LinearLayoutManager(this@MainActivity)
                adapter = ClientAdapter(cursor as Cursor)
            }
        }catch (ex: Exception){
            ex.printStackTrace()
        }

    }
}