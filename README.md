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
