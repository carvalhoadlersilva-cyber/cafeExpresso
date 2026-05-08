import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void deveCriarProdutoComDadosValidos() {
        Produto cafe = new Produto("Café Expresso", 5.50);

        assertEquals("Café Expresso", cafe.getNome());
        assertEquals(5.50, cafe.getPrecoUnitario());
    }

    @Test
    void naoDevePermitirProdutoComPrecoNegativo() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("Café Negativo", -10.00);
        });

        assertEquals("Preço não pode ser negativo", erro.getMessage());
    }

    @Test
    void naoDevePermitirProdutoComNomeVazio() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class, () -> {
            new Produto("", 5.00);
        });

        assertEquals("Nome inválido", erro.getMessage());
    }
}