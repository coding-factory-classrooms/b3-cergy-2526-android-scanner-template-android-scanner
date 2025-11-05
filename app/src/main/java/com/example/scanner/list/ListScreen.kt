package com.example.scanner.list

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.scanner.camera.CameraActivity
import com.example.scanner.ui.theme.ScannerTheme


@Composable
fun ListScreen() {
    val context = LocalContext.current


    Scaffold { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {


            CameraButton(onButtonClick = {
                // Charger le context pour démarrer une activité pour camera activity
                val intent = Intent(context, CameraActivity::class.java)
                context.startActivity(intent)
            })
        }


    }
}

@Composable
fun CameraButton(onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick
    ) {
        Text("Caméra")
    }
}



@Preview
@Composable
fun ListScreenPreview() {
    ScannerTheme {
        ListScreen()
    }
}