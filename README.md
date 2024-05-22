# 🚗 Park and Run 🏍️

### 👨‍💻 Rafel Amengual Tomás

# 📜 Información del contenido del proyecto
Mi proyecto consta de una clase abstracta llamada Parking que contiene diferentes métodos, esta tiene una clase hija llamada MegaParking
que implementa métodos nuevos y permite que el parking tenga más de 1 planta, estas dos tienen una interface llamada Acciones que
permite cerrar y abrir puertas, apagar y encender luces.

Aparte de esto se ha creado una clase abstracta llamada Vehículo que implementa los atributos principales que puede tener un vehículo
como por ejemplo la matrícula y un identificador de si es trabajador del parking o no. De esta clase heredan dos más,
una es la clase Coche que contiene una String por default que nos indica que es un coche y dos métodos, una para conseguir el identificador
y un toString que nos devuelve el identificador y la matrícula del vehículo(Esto lo usamos para introducir en la lista de Parking
la información del coche). También tenemos la clase Moto que contiene todo lo mismo que coche, solo que el identificador es diferente.

En el Main está la conexión a bases de datos, un conjunto de menus que nos permiten añadir vehiculos a parkings y un menu avanzado para trabajadores que
nos permite hacer diferentes funciones relacionadas con la información del parking y demás, Hay un generador de Tickets que nos indica cual es el parking y 
que debemos pagar por estar en el. En el Main se encuentran definidos los parkings que son de la empresa Aparcar y a entrenar.


Cuando el Parking esta al completo salta una exception que el vehiculo no puede acceder ya que esta lleno.

## 📕 Enunciado del proyecto
![image](https://github.com/RafelAm/Park-And-Run/assets/147522281/30c7fac5-679c-41b9-a1e0-042340d06360)


### ⚠️ Advertencia

    Se ha obviado que en una plaza de coche caben dos motos, cada uno tiene sus plazas.
