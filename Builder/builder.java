public class Carro {
    private String motor;
    private String cor;
    private int portas;
    private boolean arCondicionado;

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public void mostrarInfo() {
        System.out.println("Carro [Motor: " + motor + ", Cor: " + cor + ", Portas: " + portas +
                           ", Ar Condicionado: " + (arCondicionado ? "Sim" : "Não") + "]");
    }
}

public interface CarroBuilder {
    void construirMotor();
    void construirCor();
    void construirPortas();
    void construirArCondicionado();
    Carro getCarro();
}


public class CarroEsportivoBuilder implements CarroBuilder {
    private Carro carro = new Carro();

    public void construirMotor() {
        carro.setMotor("V8");
    }

    public void construirCor() {
        carro.setCor("Vermelho");
    }

    public void construirPortas() {
        carro.setPortas(2);
    }

    public void construirArCondicionado() {
        carro.setArCondicionado(true);
    }

    public Carro getCarro() {
        return carro;
    }
}



public class CarroPopularBuilder implements CarroBuilder {
    private Carro carro = new Carro();

    public void construirMotor() {
        carro.setMotor("1.0 Flex");
    }

    public void construirCor() {
        carro.setCor("Branco");
    }

    public void construirPortas() {
        carro.setPortas(4);
    }

    public void construirArCondicionado() {
        carro.setArCondicionado(false);
    }

    public Carro getCarro() {
        return carro;
    }
}


public class Concessionaria {
    public void construirCarro(CarroBuilder builder) {
        builder.construirMotor();
        builder.construirCor();
        builder.construirPortas();
        builder.construirArCondicionado();
    }
}


public class Main {
    public static void main(String[] args) {
        Concessionaria concessionaria = new Concessionaria();

        CarroBuilder esportivoBuilder = new CarroEsportivoBuilder();
        concessionaria.construirCarro(esportivoBuilder);
        Carro carroEsportivo = esportivoBuilder.getCarro();
        carroEsportivo.mostrarInfo();

        CarroBuilder popularBuilder = new CarroPopularBuilder();
        concessionaria.construirCarro(popularBuilder);
        Carro carroPopular = popularBuilder.getCarro();
        carroPopular.mostrarInfo();
    }
}