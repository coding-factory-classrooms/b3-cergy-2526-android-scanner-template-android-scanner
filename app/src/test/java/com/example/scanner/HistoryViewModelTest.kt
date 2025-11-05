package com.example.scanner.history

import HistoryViewModel
import com.example.scanner.domain.model.Product
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class HistoryViewModelTest {

    private lateinit var viewModel: HistoryViewModel

    @Before
    fun setUp() {
        viewModel = HistoryViewModel()
    }

    @Test
    fun `ajouter un produit dans l'historique augmente la liste`() {
        val product = Product(
            name = "Nutella",
            brand = "Ferrero",
            quantity = "400g",
            imageUrl = "https://example.com/nutella.jpg"
        )

        viewModel.addProduct(product)

        val result = viewModel.products.value
        assertEquals(1, result.size)
        assertEquals("Nutella", result.first().name)
        assertEquals("Ferrero", result.first().brand)
    }

    @Test
    fun `ajouter null ne doit pas modifier la liste`() {
        viewModel.addProduct(null)
        val result = viewModel.products.value
        assertTrue(result.isEmpty())
    }
}
