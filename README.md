# Explicación de los tests desarrollados:

## Unit Tests
Para los unit tests se ha hecho uso de la anotación @ParameterizedTest, en vez de la esperada @Test, ya que evita la repetición de código dentro del test inyectando desde el bin correspondiente toda la información relevante a cada test. Se han implementado 3 tests para el DNI: uno que contiene ejemplos válidos obtenidos en generadordni.es, uno prueba ejemplos con un formato equivocado, y otro que prueba ejemplos con el formato correcto, pero con valores inválidos dado que la letra no es la esperada. Se podrían haber juntado los dos últimos tests pero para facilitar el entendimiento de los mismos se presentan separados.

Con los números de teléfono se implementan 2 tests, uno con números válidos, probando todos los casos que permite la expresión regular de la clase Telefono.java, y otro probando distintos tipos de casos no válidos. Todos los tests han salido bien y se ha verificado bien la validación de los datos. Las clases relevantes son TestDNI.java y TestTlf.java

## E2E Tests
Para los tests end-to-end, se han creado 4 distintos para verificar el funcionamiento del controlador. Primero se mandan datos correctos, pero sin buscar la persistencia de datos, luego lo mismo con datos incorrectos, y finalmente se repiten ambos casos introduciendo data legacy. La mayoría del código como tal en este apartado se ha sacado de las diapositivas de la asignatura, con algunas modificaciones. Todo se incluye en el fichero TestE2EController.java
