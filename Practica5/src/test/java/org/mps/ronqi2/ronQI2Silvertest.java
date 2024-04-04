package org.mps.ronqi2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mps.dispositivo.Dispositivo;
import org.mps.dispositivo.DispositivoSilver;

@ExtendWith(MockitoExtension.class)
public class ronQI2Silvertest {

    RonQI2 ronqi2;

    @Mock(lenient = true)
    DispositivoSilver dispositivo;

    @BeforeEach
    public void setUp() {
        ronqi2 = new RonQI2Silver();
        ronqi2.disp = dispositivo;
    }

    /*
     * Analiza con los caminos base qué pruebas se han de realizar para comprobar
     * que al inicializar funciona como debe ser.
     * El funcionamiento correcto es que si es posible conectar ambos sensores y
     * configurarlos,
     * el método inicializar de ronQI2 o sus subclases,
     * debería devolver true. En cualquier otro caso false. Se deja programado un
     * ejemplo.
     */
    @Nested
    @DisplayName("metodo inicializar")
    class Inicializar {
        @DisplayName("El metodo inicializar debe devolver true si se conectan y configuran ambos sensores correctamente")
        @Test
        public void Inicializar_todoCorrecto_DevuelveTrue() {
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);
            when(dispositivo.configurarSensorPresion()).thenReturn(true);
            when(dispositivo.configurarSensorSonido()).thenReturn(true);

            boolean resultado = ronqi2.inicializar();

            assertTrue(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conectan ni configuran los sensores correctamente")
        @Test
        public void Inicializar_noConectaNiConfigura_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(false);
            when(dispositivo.conectarSensorSonido()).thenReturn(false);
            when(dispositivo.configurarSensorPresion()).thenReturn(false);
            when(dispositivo.configurarSensorSonido()).thenReturn(false);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conectan el Sensor de Presion")
        @Test
        public void Inicializar_noConectaPresion_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(false);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);
            when(dispositivo.configurarSensorPresion()).thenReturn(true);
            when(dispositivo.configurarSensorSonido()).thenReturn(true);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conectan el Sensor de Sonido")
        @Test
        public void Inicializar_noConectaSonido_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(false);
            when(dispositivo.configurarSensorPresion()).thenReturn(true);
            when(dispositivo.configurarSensorSonido()).thenReturn(true);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se configura el Sensor de Presion")
        @Test
        public void Inicializar_noConfiguraPresion_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);
            when(dispositivo.configurarSensorPresion()).thenReturn(false);
            when(dispositivo.configurarSensorSonido()).thenReturn(true);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se configura el Sensor de Sonido")
        @Test
        public void Inicializar_noConfiguraSonido_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);
            when(dispositivo.configurarSensorPresion()).thenReturn(true);
            when(dispositivo.configurarSensorSonido()).thenReturn(false);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conecta ni configura el sensor de sonido")
        @Test
        public void Inicializar_noConectaNiConfiguraSonido_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(false);
            when(dispositivo.configurarSensorPresion()).thenReturn(true);
            when(dispositivo.configurarSensorSonido()).thenReturn(false);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conecta ni configura el sensor de presion")
        @Test
        public void Inicializar_noConectaNiConfiguraPresion_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(false);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);
            when(dispositivo.configurarSensorPresion()).thenReturn(false);
            when(dispositivo.configurarSensorSonido()).thenReturn(true);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conecta el sensor de sonido y no se configura el sensor de presion")
        @Test
        public void Inicializar_noConectaSonidoNiConfiguraPresion_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(false);
            when(dispositivo.configurarSensorPresion()).thenReturn(false);
            when(dispositivo.configurarSensorSonido()).thenReturn(true);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conecta el sensor de presion y no se configura el sensor de sonido")
        @Test
        public void Inicializar_noConectaPresionNiConfiguraSonido_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(false);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);
            when(dispositivo.configurarSensorPresion()).thenReturn(true);
            when(dispositivo.configurarSensorSonido()).thenReturn(false);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conecta el sensor de sonido y no se conecta el sensor de presion")
        @Test
        public void Inicializar_noConectaSonidoNiConectaPresion_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(false);
            when(dispositivo.conectarSensorSonido()).thenReturn(false);
            when(dispositivo.configurarSensorPresion()).thenReturn(true);
            when(dispositivo.configurarSensorSonido()).thenReturn(true);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se configura el sensor de sonido y no se configura el sensor de presion")
        @Test
        public void Inicializar_noConfiguraSonidoNiConfiguraPresion_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);
            when(dispositivo.configurarSensorPresion()).thenReturn(false);
            when(dispositivo.configurarSensorSonido()).thenReturn(false);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conecta ni configura el sensor de sonido y no se conecta el sensor de presion")
        @Test
        public void Inicializar_noConectaNiConfiguraSonidoNiConectaPresion_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(false);
            when(dispositivo.conectarSensorSonido()).thenReturn(false);
            when(dispositivo.configurarSensorPresion()).thenReturn(true);
            when(dispositivo.configurarSensorSonido()).thenReturn(false);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conecta ni configura el sensor de sonido y no se configura el sensor de presion")
        @Test
        public void Inicializar_noConectaNiConfiguraSonidoNiConfiguraPresion_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(false);
            when(dispositivo.configurarSensorPresion()).thenReturn(false);
            when(dispositivo.configurarSensorSonido()).thenReturn(false);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conecta ni configura el sensor de presion y no se conecta el sensor de sonido")
        @Test
        public void Inicializar_noConectaNiConfiguraPresionNiConectaSonido_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(false);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);
            when(dispositivo.configurarSensorPresion()).thenReturn(false);
            when(dispositivo.configurarSensorSonido()).thenReturn(false);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }

        @DisplayName("El metodo inicializar debe devolver false si no se conecta ni configura el sensor de presion y no se configura el sensor de sonido")
        @Test
        public void Inicializar_noConectaNiConfiguraPresionNiConfiguraSonido_DevuelveFalse() {
            when(dispositivo.conectarSensorPresion()).thenReturn(false);
            when(dispositivo.conectarSensorSonido()).thenReturn(false);
            when(dispositivo.configurarSensorPresion()).thenReturn(false);
            when(dispositivo.configurarSensorSonido()).thenReturn(true);

            boolean resultado = ronqi2.inicializar();

            assertFalse(resultado);
        }
    }
    /*
     * Un inicializar debe configurar ambos sensores, comprueba que cuando se
     * inicializa de forma correcta (el conectar es true),
     * se llama una sola vez al configurar de cada sensor.
     */

    /*
     * Un reconectar, comprueba si el dispositivo desconectado, en ese caso, conecta
     * ambos y devuelve true si ambos han sido conectados.
     * Genera las pruebas que estimes oportunas para comprobar su correcto
     * funcionamiento.
     * Centrate en probar si todo va bien, o si no, y si se llama a los métodos que
     * deben ser llamados.
     */

    /*
     * El método evaluarApneaSuenyo, evalua las últimas 5 lecturas realizadas con
     * obtenerNuevaLectura(),
     * y si ambos sensores superan o son iguales a sus umbrales, que son thresholdP
     * = 20.0f y thresholdS = 30.0f;,
     * se considera que hay una apnea en proceso. Si hay menos de 5 lecturas también
     * debería realizar la media.
     * /
     * 
     * /* Realiza un primer test para ver que funciona bien independientemente del
     * número de lecturas.
     * Usa el ParameterizedTest para realizar un número de lecturas previas a
     * calcular si hay apnea o no (por ejemplo 4, 5 y 10 lecturas).
     * https://junit.org/junit5/docs/current/user-guide/index.html#writing-tests-
     * parameterized-tests
     */
}
