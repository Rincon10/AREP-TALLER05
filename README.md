# AREP-TALLER05
Threads and Runnable

## Generando Nuestra arquitectura

```
mvn archetype:generate -DgroupId=edu.escuelaing.arep -DartifactId=App -DarchetypeArtifactId=maven-archetype-quickstart
```

## Ejecutando
```
mvn exec:java -Dexec.mainClass="edu.escuelaing.arep.reflectionsexamples.InvokeMain"
-Dexec.args="edu.escuelaing.arep.reflectionsexamples.ReflectionExample"
```

## Hilo
Es la virtualización de un interprete

## Modelo General

Los hilos en Java, vamos a virtualizar la ejecución pero vamos a compartir memoria a diferencia de los diferentes procesos del sistema operativo.

## Existen 2 maneras de crear hilos

### Extendiendo de Thread

En este caso, se crea un hilo de ejecucion en el main y ademas del hilo del main se crea otro hilo para ejecutar el run. 

```java
public class HelloThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String[] args) {
        new HelloThread().start();
    }
}
```

### Implementando a Runnable

En este caso se crean los hilos al igual que el anterior, lo diferente es como estamos llamando al metodo start

```java
public class HelloRunnable implements Runnable {
    public void run() {
        System.out.println("Hello from Runnable");
    }

    public static void main(String[] args) {
        new Thread( new HelloRunnable()).start();
    }
}
```

## Cordinacion entre hilos por medio de metodos sincronizados y bloques sincronizados


### Metodos Sync
Solo un hilo puede ejecutar al metodo ninguno mas, normalmente se usan cuando estoy creando una estructura de datos sincronizada.

### Bloques Sync


## Seguros y sincronizacion

los seguros son un objeto que le dicen a los hilos antes de entrar a un bloque

Es ideal crear objetos que simulen los seguros para que no se haga synchronized a todo el metodo

```java
private Object lock1 = new Object();
private Object lock2 = new Object();

public void inc1(){
    synchronized(lock1){    
        c1++;
    }
}

public void inc2(){
    synchronized(lock2){    
        c2++;
    }
}

// Esto permite que dos threads no puedan acceder a inc1 o inc2 al tiempo( es decir h1.inc1 y h2.inc1 o h1.inc2 y h2.inc2), pero que si se pueda acceder a inc2 mientras otro hilo esta usando inc1 
```

