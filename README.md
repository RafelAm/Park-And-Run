# 🚗 Park and Run 🏍️

### 👨‍💻 Rafel Amengual Tomás

# 📜 Información del contenido del proyecto
Mi proyecto consta de una clase abstracta llamada Parking que contiene diferentes metodos, esta tiene una clase hija llamada MegaParking que implementa metodos nuevos y permite que el parking tenga más de 1 planta, estas dos tienen una interface llamada Acciones que no permite cerrar y abrir puertas, apagar y encender luces.

Aparte de esto se ha creado una clase abstracta llamada Vehiculo que implementa los atributos principales que puede tener un 
vehiculo como por ejemplo la matricula y un identificador de si es trabajador del parking o no. De esta clase heredan dos más,
una es la clase Coche que contiene una String por default que nos indica que es un coche y dos metodos una para conseguir el identificador y un toString que nos devuelve el identificador y la matricula del vehiculo(Esto lo usamos para introducir en la lista de Parking la información del coche).También tenemos la clase Moto que contiene todo lo mismo quer coche solo que el identificador es diferente.

En el Main esta la información general que se puede conseguir mediante los metodos del Parking y el MegaParking, Aparte se crea el objeto MegaParking y los objetos coche y moto. estos se le añaden al objeto MegaParking.

Se ha creado una Exception que salta cuando el parking no tiene el suficiente espacio para que entre una moto o un coche.

## 📕 Enunciado del proyecto
![image](https://github.com/RafelAm/Park-And-Run/assets/147522281/30c7fac5-679c-41b9-a1e0-042340d06360)


### ⚠️ Advertencia

Del encunciado se ha obiado que en una plaza de coche caben dos motos, cada uno tiene sus plazas.
