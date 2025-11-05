package com.example.scanner.features.gifList

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scanner.features.scan.CameraCaptureButton
import com.example.scanner.ui.theme.ScannerTheme

@Composable
fun GifListView() {
    Scaffold() { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = "Page Gif liste", fontSize = 20.sp)
            }

            CameraCaptureButton(
                modifier = Modifier.align(Alignment.BottomEnd),
                text = "Open Cam",
                onResult = { base64 ->
                    Log.d("GifListView", "Image capture (base64 length=${base64.length})")
                },
                onError = { error ->
                    Log.e("GifListView", "Error camera: $error")
                }
            )
        }
    }
}

@Preview
@Composable
fun GifListViewPreview(){
    ScannerTheme() {
        GifListView()
    }
}