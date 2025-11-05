package com.example.scanner

import com.example.scanner.models.ApiCall
import junit.framework.TestCase.assertEquals
import org.junit.Test

class ProductScanTest {

    @Test
    fun ProductApiCallNutella() {
        val call = ApiCall("3017624010701") // Nutella awaited
        assertEquals("Nutella", call?.product_name);
    }

    @Test
    fun ProductApiCallJus() {
        val call = ApiCall("4056489641018") // jus d'orange awaited
        assertEquals("Pur jus d'orange sans pulpe", call?.product_name);
    }
}