import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoTest {

    @Test
    void deveCalcularSubtotalCorretamente() {
        Produto bolo = new Produto("Fatia de Bolo", 7.50);
        ItemPedido item = new ItemPedido(bolo, 3); // 3 fatias

        // 3 * 7.50 = 22.50
        assertEquals(22.50, item.calcularSubtotal());
    }

    @Test
    void naoDevePermitirQuantidadeZeroOuNegativa() {
        Produto cafe = new Produto("Café Expresso", 5.50);

        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            new ItemPedido(cafe, 0); // Tentativa de fraude ou erro de input
        });

        assertEquals("Quantidade deve ser maior que zero", erro.getMessage());
    }
}