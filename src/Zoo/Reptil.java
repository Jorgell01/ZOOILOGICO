package Zoo;

import java.util.Random;

public class Reptil extends Animal {
    // Variables de instancia específicas de los reptiles
    protected String tipoPiel; // Tipo de piel del reptil
    protected boolean esVeneno; // Indica si el reptil es venenoso
    protected String habitat; // Hábitat natural del reptil

    // Array de tipos de piel posibles
    private static final String[] tiposPielPosibles = {"escamosa", "coriácea", "rugosa"};

    // Constructor sin parámetros
    public Reptil() {
        super(); // Llama al constructor de la clase padre (Animal)
        Random random = new Random(); // Instancia un objeto Random para generar valores aleatorios
        // Asigna un tipo de piel aleatorio al reptil
        this.tipoPiel = tiposPielPosibles[random.nextInt(tiposPielPosibles.length)];
        // Asigna un valor aleatorio para indicar si el reptil es venenoso o no
        this.esVeneno = random.nextBoolean();
        // Genera un hábitat aleatorio para el reptil
        this.habitat = generarHabitatAleatorio();
    }

    // Constructor con parámetros
    public Reptil(String nombre, int edad, float peso, String tipoPiel, boolean esVeneno, String habitat) {
        super(nombre, edad, peso); // Llama al constructor de la clase padre (Animal) con los parámetros correspondientes
        this.tipoPiel = tipoPiel; // Asigna el tipo de piel especificado
        this.esVeneno = esVeneno; // Asigna si el reptil es venenoso
        this.habitat = habitat; // Asigna el hábitat especificado
    }

    // Métodos específicos de los reptiles
    public void tomarSol() {
        System.out.println(nombre + " está tomando el sol para termorregularse.");
    }

    public void mudarPiel() {
        System.out.println(nombre + " está mudando de piel.");
    }

    public void reptar() {
        System.out.println(nombre + " está reptando.");
    }

    // Genera un hábitat aleatorio para el reptil
    private String generarHabitatAleatorio() {
        String[] habitatsPosibles = {"desierto", "selva", "pantano", "montaña"};
        Random random = new Random();
        return habitatsPosibles[random.nextInt(habitatsPosibles.length)];
    }

    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
                this::tomarSol,
                this::mudarPiel,
                this::reptar
        };

        try {
            for (int i = 0; i < 5; i++) {
                int indiceAccion = random.nextInt(acciones.length);
                acciones[indiceAccion].run();

                int tiempoEspera = random.nextInt(2000) + 1000;
                Thread.sleep(tiempoEspera);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
