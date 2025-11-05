import androidx.lifecycle.ViewModel
import com.example.scanner.data.remote.ProductData
import com.example.scanner.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HistoryViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    fun addProduct(product: Product?) {
        product?.let {
            _products.value = _products.value + it
        }
    }

}
