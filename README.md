#  Patrones de diseño 

Los patrones de diseño, en el contexto de la programación y el desarrollo de software, son soluciones generales y reutilizables para problemas comunes que los programadores enfrentan al diseñar y construir aplicaciones. Estos patrones proporcionan un enfoque probado y eficaz para resolver problemas específicos de diseño de software, lo que facilita la creación de código más mantenible, escalable y robusto.


## 💍 Patrón Singleton

El Patrón Singleton es un diseño de software que se utiliza para garantizar que una clase tenga una única instancia en una aplicación y proporcionar un punto de acceso global a esa instancia. Esta técnica tiene ventajas y desventajas que deben considerarse al implementarla.

### Ventajas:

1. **Garantiza una única instancia:** El Patrón Singleton garantiza que solo exista una instancia de una clase en toda la aplicación. Esto es útil cuando se necesita un control estricto sobre la creación de objetos.

2. **Punto de acceso global:** Proporciona un método estático o propiedad que permite acceder a la instancia única desde cualquier parte del código, lo que facilita la gestión de recursos compartidos o configuraciones globales.

3. **Simplifica el código:** Al prevenir la creación de múltiples instancias de una clase, se evita la complejidad y los errores que pueden surgir al manejar múltiples objetos similares. Esto simplifica el diseño del código.

### Desventajas:

1. **Dificultad de implementación:** La implementación correcta del Patrón Singleton puede ser complicada, especialmente cuando se trata de asegurarse de que la instancia sea única en un entorno de subprocesos múltiples.

2. **Escalabilidad limitada:** El uso excesivo de Singletons puede dificultar la escalabilidad de una aplicación, ya que cada Singleton introduce un estado global y acoplamiento implícito.

#### Ejemplo programático:

Para crear un singleton, haga que el constructor sea privado, deshabilite la clonación, deshabilite la extensión y cree una variable estática para albergar la instancia.

```java
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
```
#### Ejemplo de Uso:

```java
public class Main {
    public static void main(String[] args) {
        // Obtener la instancia única del Connector
        Connector connector1 = Connector.getInstance();
        
        // Intentar crear otra instancia, pero obtendremos la misma instancia creada previamente
        Connector connector2 = Connector.getInstance();
        
        // Verificar si connector1 y connector2 son la misma instancia
        System.out.println(connector1 == connector2); // true
    }
}
```

## 🐑 Prototype 

El patrón Prototype es un patrón de diseño creacional que permite crear nuevos objetos clonando un prototipo existente. Este patrón es útil cuando la creación de un objeto es compleja o costosa, o cuando se necesita crear una gran cantidad de objetos similares.

### Ventajas:

1. **Eficiente:** La clonación es una operación más eficiente que la creación de un objeto desde cero.
2. **Flexible:**  El patrón Prototype permite crear nuevos objetos sin tener que modificar el código fuente del objeto prototipo.
3. **Mantenible:** El patrón Prototype puede ayudar a reducir la complejidad del código, al ocultar la implementación de la clonación.

### Desventajas:

1. **Eficiencia relativa:** El código cliente puede depender de la existencia del prototipo.
2. **Dependencia del prototipo:** Puede ser menos eficiente que otros patrones creacionales, como Factory Method o Abstract Factory.


#### Ejemplo programático: 
Supongamos que necesitamos gestionar listas de productos que se actualizan con frecuencia. En este caso, el prototipo podría ser una lista vacía. Cuando se requiera una nueva lista, podemos clonar el prototipo y luego actualizar la lista clonada con los datos necesarios.
```java
// Definición de la interfaz Prototype que permite la clonación de objetos
public interface Prototype<T extends Prototype<T>> extends Cloneable {
    T clone();   // Clona el objeto 
    T deepClone(); // Realiza una clonación profunda (si es necesario)
    T reset();   // // Restablece el objeto a su estado inicial (opcional)
}


// Clase PrototypeList que implementa la interfaz Prototype para listas
public class PrototypeList implements Prototype {
    private String name;
    private List<Products> productsList;

    public PrototypeList(String name) {
        this.name = name;
    }

     @Override
    public Prototype deepClone() {
        PrototypeList clone = new PrototypeList(name);
        List<Products> products = new ArrayList<>();
        List<Prototype> values = productsList.stream()
                .map(Products::clone).collect(Collectors.toList());
        products.add((Products) values);
        clone.setProducts(products);
        return clone;
    }

    @Override
    public Prototype reset() {
        if (productsList.isEmpty()) {
            return null;
        }

        PrototypeList clone = new PrototypeList(name);
        List<Products> products = new ArrayList<>();
        products.addAll(productsList);
        clone.setProducts(products);

        return clone;
    }

    @Override
    public Prototype clone() {
        PrototypeList clone = new PrototypeList(name);
        clone.setProducts(productsList);
        return clone;
    }
}

// Clase Products que implementa la interfaz Prototype para productos
public class Products implements Prototype {

    private String name;
    private String description;
    private int price;
    private String[] items;

    public Products(String name, String description, int price, String[] items) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.items = items;
    }

    @Override
    public Prototype clone() {
        Products clone = new Products(name, description, price, items);
        return clone;
    }
}

public class Main {
    public static void main(String[] args) {
        // Lista de productos
        List<Products> productsList =
                List.of(new Products("Producto 1", "Este es el primer producto.", 100, new String[]{"Item 1", "Item 2"}),
                        new Products("Producto 2", "Este es el segundo producto.", 200, new String[]{"Item 1", "Item 2"}));

        // Crear una lista prototipo de productos
        PrototypeList list = new PrototypeList("Listado");
        list.setProducts(productsList);

        // Clonar la lista prototipo
        PrototypeList clone = (PrototypeList) list.clone();

        // Cambiar el precio de los productos en la lista clonada
        for (Products product : clone.getProducts()) {
            product.setPrice(product.getPrice() * 2);
        }

        // Imprimir la lista original y la lista clonada
        System.out.println(list);
        System.out.println(clone);
    }
}
``` 
    
### Output: 
```bash
Lista Original:
PrototypeList{name='Listado', productsList=[Products{name='Producto 1', description='Este es el primer producto.', price=100, items=[Item 1, Item 2]}, Products{name='Producto 2', description='Este es el segundo producto.', price=200, items=[Item 1, Item 2]}]}

Lista Clonada:
PrototypeList{name='Listado', productsList=[Products{name='Producto 1', description='Este es el primer producto.', price=200, items=[Item 1, Item 2]}, Products{name='Producto 2', description='Este es el segundo producto.', price=400, items=[Item 1, Item 2]}]}
```








    

