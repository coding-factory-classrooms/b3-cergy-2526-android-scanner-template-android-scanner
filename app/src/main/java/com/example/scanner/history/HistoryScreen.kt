package com.example.scanner.history

import HistoryViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.example.scanner.data.remote.ProductData

@Composable
fun HistoryScreen(viewModel: HistoryViewModel) {
    val products = viewModel.products.collectAsState()

    Scaffold { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
        ) {
            Text(
                text = "Historique des produits scannés",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(16.dp)
            )

            LazyColumn {
                items(products.value) { product ->
                    Row(modifier = Modifier.padding(8.dp)) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(product.imageUrl)
                                .crossfade(true)
                                .scale(Scale.FILL)
                                .build(),
                            contentDescription = product.name,
                            modifier = Modifier.size(64.dp)
                        )
                        Column(modifier = Modifier.padding(start = 8.dp)) {
                            Text(product.name, fontWeight = FontWeight.Bold)
                            Text(product.brand)
                            Text(product.quantity)
                        }
                    }
                }
            }
        }
    }
}
