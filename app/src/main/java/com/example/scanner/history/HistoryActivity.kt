package com.example.scanner.history

import HistoryViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.scanner.ui.theme.ScannerTheme

class HistoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ScannerTheme {
                val historyViewModel: HistoryViewModel = viewModel()
                HistoryScreen(viewModel = historyViewModel)
            }
        }
    }
}
