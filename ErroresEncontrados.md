## Errores encontrados

### RonQI2

    - anyadirDispositivo -> comprobar que el dispositivo no es nulo.

### RonQI2Silver

    - obtenerNuevaLectura -> Leer ambos dispositivos no solo presion.
    - evaluarApneaSuenyo -> Debe devolver true si exites apnea y false si no, no al revés.
    - evaluarApneaSuenyo -> Devuelve true si el promedio de las lecturas de presion y sonido es mayor a los limites, no mayor o igual.
