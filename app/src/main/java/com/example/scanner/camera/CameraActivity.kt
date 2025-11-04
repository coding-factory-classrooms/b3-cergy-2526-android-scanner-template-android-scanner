package com.example.scanner.camera

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat.startActivityForResult
import com.example.scanner.ui.theme.ScannerTheme

@Composable
fun CameraActivity(){

    // 1) état pour l’image
    val photo = remember { mutableStateOf<Bitmap?>(null) }

// 2) launcher
    val takePicturePreview = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bmp -> photo.value = bmp }


// 4) afficher si dispo
    photo.value?.let { bmp -> /* Image(bitmap = ... ) */ }




    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(onClick = { takePicturePreview.launch(null) }) {
                Text("Ouvrir appareil photo")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScannerTheme {
        CameraActivity()
    }
}