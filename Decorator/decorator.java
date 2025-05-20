interface Carro {
    String getDescricao();
    double getPreco();
}

class CarroBasico implements Carro {
    public String getDescricao() {
        return "Carro básico";
    }

    public double getPreco() {
        return 30000.0;
    }
}

abstract class CarroDecorator implements Carro {
    protected Carro carro;

    public CarroDecorator(Carro carro) {
        this.carro = carro;
    }

    public String getDescricao() {
        return carro.getDescricao();
    }

    public double getPreco() {
        return carro.getPreco();
    }
}

class ArCondicionado extends CarroDecorator {
    public ArCondicionado(Carro carro) {
        super(carro);
    }

    public String getDescricao() {
        return super.getDescricao() + ", Ar Condicionado";
    }

    public double getPreco() {
        return super.getPreco() + 2500.0;
    }
}

class TetoSolar extends CarroDecorator {
    public TetoSolar(Carro carro) {
        super(carro);
    }

    public String getDescricao() {
        return super.getDescricao() + ", Teto Solar";
    }

    public double getPreco() {
        return super.getPreco() + 4000.0;
    }
}

public class Main {
    public static void main(String[] args) {
        Carro carro = new CarroBasico();
        carro = new ArCondicionado(carro);
        carro = new TetoSolar(carro);

        System.out.println(carro.getDescricao());
        System.out.println("Preço total: R$" + carro.getPreco());
    }
}
