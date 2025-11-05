package com.example.scanner.scan

import android.nfc.NfcAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.scanner.R


class ScanActivity: ComponentActivity () {
    private lateinit var  nfcAdapter: NfcAdapter

    override fun onCreate (savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        // Get the default NFC adapter
        nfcAdapter = NfcAdapter.getDefaultAdapter(this)

        if (nfcAdapter == null) {
            Toast.makeText(this, "NFC not supported", Toast.LENGTH_SHORT).show()
        } else if (!nfcAdapter!!.isEnabled) {
            Toast.makeText(this, "Please turn on NFC", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this, "NFC found", Toast.LENGTH_SHORT).show()
        }


    }
}