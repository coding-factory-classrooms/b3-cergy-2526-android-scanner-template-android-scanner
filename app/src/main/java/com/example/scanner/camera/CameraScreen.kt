package com.example.scanner.camera

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp


@Composable
fun CameraScreen() {
    CameraQuickTest()
}


@Composable
fun CameraQuickTest() {
    // État qui stocke la photo (nullable tant qu’on n’a rien)
    val photo = remember { mutableStateOf<Bitmap?>(null) }

    // Launcher pour ACTION_IMAGE_CAPTURE (vignette)
    val takePicturePreview = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bmp ->
        photo.value = bmp
    }

    // UI minimale : un bouton pour lancer, et aperçu si dispo
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(onClick = { takePicturePreview.launch(null) }) {
            Text("Prendre une photo (test)")
        }

        // Affiche la vignette si non nulle
        photo.value?.let { bmp ->
            Image(
                bitmap = bmp.asImageBitmap(),
                contentDescription = "Vignette",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxSize(fraction = 0.5f)
            )
        }
    }
}