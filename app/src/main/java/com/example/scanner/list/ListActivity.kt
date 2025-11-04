package com.example.scanner.list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scanner.ui.theme.ScannerTheme


class ListActivity : ComponentActivity() {
    val PERMISSION_REQUEST_CODE: Int = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(checkSelfPermission(android.Manifest.permission.CAMERA) != android.content.pm.PackageManager.PERMISSION_GRANTED){
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), PERMISSION_REQUEST_CODE)
        }
        enableEdgeToEdge()
        setContent {
            CameraQuickTest()
        }
    }
}

@Composable
fun CameraQuickTest() {
    // État qui stocke la photo (nullable tant qu’on n’a rien)
    val photo = remember { mutableStateOf<android.graphics.Bitmap?>(null) }

    // Launcher pour ACTION_IMAGE_CAPTURE (vignette)
    val takePicturePreview = rememberLauncherForActivityResult(
        contract = androidx.activity.result.contract.ActivityResultContracts.TakePicturePreview()
    ) { bmp ->
        photo.value = bmp
    }

    // UI minimale : un bouton pour lancer, et aperçu si dispo
    androidx.compose.foundation.layout.Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        androidx.compose.material3.Button(onClick = { takePicturePreview.launch(null) }) {
            androidx.compose.material3.Text("Prendre une photo (test)")
        }

        // Affiche la vignette si non nulle
        photo.value?.let { bmp ->
            androidx.compose.foundation.Image(
                bitmap = bmp.asImageBitmap(),
                contentDescription = "Vignette",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxSize(fraction = 0.5f)
            )
        }
    }
}