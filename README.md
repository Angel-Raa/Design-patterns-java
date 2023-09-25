#  patrones de diseño 

Los patrones de diseño, en el contexto de la programación y el desarrollo de software, son soluciones generales y reutilizables para problemas comunes que los programadores enfrentan al diseñar y construir aplicaciones. Estos patrones proporcionan un enfoque probado y eficaz para resolver problemas específicos de diseño de software, lo que facilita la creación de código más mantenible, escalable y robusto.


## 💍 Singleton 

El patrón Singleton es un patrón de diseño creacional que garantiza que una clase solo tenga una instancia y proporciona un punto de acceso global a ella.

#### Ventajas:

Garantiza que una clase solo tenga una instancia.
Proporciona un punto de acceso global a la instancia.
Simplifica el código al evitar que se creen instancias múltiples de una clase.

#### Desventajas:

Puede ser difícil de implementar correctamente.
Puede dificultar el escalado del sistema.

### Ejemplo programático
  ```json{

public class Connector {
    private static volatile Connector instance;

    private Connector() {
        System.out.println("Connector created");
    }

    public static Connector getInstance() {
        if (instance == null) {
            synchronized (Connector.class) {
                if (instance == null) {
                    instance = new Connector();
                }
            }
        }
        return instance;
    }

    private static void validateInstance() {
        if (instance == null) {
            throw new IllegalStateException("Connector is not initialized");
        }
    }

    public void connect() {
        validateInstance();
        System.out.println("Connecting.....");


    }

    public void disconnect() {
        validateInstance();
        System.out.println("Disconnecting.....");
    }
 }

}
```






}
 ```
