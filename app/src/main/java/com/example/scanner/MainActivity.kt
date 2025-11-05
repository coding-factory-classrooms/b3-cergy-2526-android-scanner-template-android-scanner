package com.example.scanner

import android.nfc.NfcAdapter
import android.nfc.Tag
import android.nfc.tech.Ndef
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.scanner.ui.theme.ScannerTheme

class MainActivity : ComponentActivity(), NfcAdapter.ReaderCallback {
    private lateinit var nfcAdapter: NfcAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        nfcAdapter = NfcAdapter.getDefaultAdapter(this)

        if (nfcAdapter == null) {
            Toast.makeText(this, "NFC not supported", Toast.LENGTH_SHORT).show()
            return
        }

        if (!nfcAdapter.isEnabled) {
            Toast.makeText(this, "Please turn on NFC", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "NFC found", Toast.LENGTH_SHORT).show()
        }

        nfcAdapter.enableReaderMode(
            this,
            this,
            NfcAdapter.FLAG_READER_NFC_A or NfcAdapter.FLAG_READER_NFC_B,
            null
        )

        setContent { ScannerTheme {} }
    }

    override fun onTagDiscovered(tag: Tag?) {
        Log.d("NFC", "Tag détecté : $tag")

        val ndef = Ndef.get(tag)

        if(ndef!= null){
            ndef.connect()

            val ndefMessage = ndef.cachedNdefMessage
            val records = ndefMessage.records
            for (record in records){
                val payload = record.payload

                val text: String = payload.toString()

                Log.d("NFC","Nfc data found: $text")
            }
            ndef.close()

        }else{
            Log.d("Error", "Ndef info not found")
        }
    }
}
