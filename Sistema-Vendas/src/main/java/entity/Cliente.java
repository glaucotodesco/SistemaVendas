package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="cpf")
public class Cliente extends Pessoa{
	private static final long serialVersionUID = 1L;
    private double limiteCred;
    private double limiteDisp;
    @OneToMany(mappedBy="cliente")
    private List<Pedido> pedidos;
   

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void setLimiteCred(double limiteCred) {
		this.limiteCred = limiteCred;
	}

	public double getLimiteCred() {
        return limiteCred;
    }

    public double getLimiteDisp() {
        return limiteDisp;
    }

    public void setLimiteDisp(double limiteDisp) {
        this.limiteDisp = limiteDisp;
    }
    
    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
        pedido.setCliente(this);
    }
   
}
