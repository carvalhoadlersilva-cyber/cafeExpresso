import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Pedido {
    private List<ItemPedido> itens;
    private StatusPedido status;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (this.status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Pedido bloqueado para novos itens.");
        }
        this.itens.add(new ItemPedido(produto, quantidade));
    }

    public double calcularTotal() {
        return itens.stream().mapToDouble(ItemPedido::calcularSubtotal).sum();
    }

    public void pagar() {
        if (this.status != StatusPedido.PENDENTE) throw new IllegalStateException("Transição inválida.");
        this.status = StatusPedido.PAGO;
    }

    public void enviarParaCozinha() {
        if (this.status != StatusPedido.PAGO) throw new IllegalStateException("Pedido precisa estar pago.");
        this.status = StatusPedido.EM_PREPARO;
    }

    public void finalizarPedido() {
        if (this.status != StatusPedido.EM_PREPARO) throw new IllegalStateException("Pedido não está em preparo.");
        this.status = StatusPedido.FINALIZADO;
    }

    public StatusPedido getStatus() { return status; }
    public List<ItemPedido> getItens() { return Collections.unmodifiableList(itens); }
}