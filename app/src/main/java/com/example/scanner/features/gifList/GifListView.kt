package com.example.scanner.features.gifList

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Page Gif liste", fontSize = 20.sp)
            CameraCaptureButton(
                modifier = Modifier,
                text = "Open Cam",
                onResult = { base64 ->
                    TODO()
                },
                onError = { error ->
                    TODO()
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