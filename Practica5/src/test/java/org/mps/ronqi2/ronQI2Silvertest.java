package org.mps.ronqi2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mps.dispositivo.Dispositivo;
import org.mps.dispositivo.DispositivoSilver;

@ExtendWith(MockitoExtension.class)
public class ronQI2SilverTest {

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

        /*
         * Un inicializar debe configurar ambos sensores, comprueba que cuando se
         * inicializa de forma correcta (el conectar es true),
         * se llama una sola vez al configurar de cada sensor.
         */
        @DisplayName("El método inicializar debe haber invocado solo una vez a cada método de configuración del dispositivo si se ha conectado correctamente los sensores")
        @Test
        public void Inicializar_SoloSeLlamaUnaVezCadaConfigurar() {
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);
            when(dispositivo.configurarSensorPresion()).thenReturn(true);
            when(dispositivo.configurarSensorSonido()).thenReturn(true);

            boolean result = ronqi2.inicializar();

            verify(dispositivo, times(1)).configurarSensorPresion();
            verify(dispositivo, times(1)).conectarSensorSonido();
            assertTrue(result);
        }
    }

    /*
     * Un reconectar, comprueba si el dispositivo desconectado, en ese caso, conecta
     * ambos y devuelve true si ambos han sido conectados.
     * Genera las pruebas que estimes oportunas para comprobar su correcto
     * funcionamiento.
     * Centrate en probar si todo va bien, o si no, y si se llama a los métodos que
     * deben ser llamados.
     */
    @Nested
    @DisplayName("metodo reconectar")
    class Reconectar {
        @DisplayName("El metodo reconectar debe devolver true si se reconectan ambos sensores correctamente")
        @Test
        public void Reconectar_SensorCorrecto_DevuelveTrue() {
            when(dispositivo.estaConectado()).thenReturn(false);
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);

            boolean resultado = ronqi2.reconectar();

            verify(dispositivo, times(1)).conectarSensorPresion();
            verify(dispositivo, times(1)).conectarSensorSonido();
            assertTrue(resultado);
        }

        @DisplayName("El metodo reconectar debe devolver false si el dispositivo ya esta conectado")
        @Test
        public void Reconectar_SensorYaConectado_DevuelveFalse() {
            when(dispositivo.estaConectado()).thenReturn(true);
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);

            boolean resultado = ronqi2.reconectar();

            verify(dispositivo, times(0)).conectarSensorPresion();
            verify(dispositivo, times(0)).conectarSensorSonido();
            assertFalse(resultado);
        }

        @DisplayName("El metodo reconectar debe devolver false si no se conecta el sensor de presion")
        @Test
        public void Reconectar_NoConectaPresion_DevuelveFalse() {
            when(dispositivo.estaConectado()).thenReturn(false);
            when(dispositivo.conectarSensorPresion()).thenReturn(false);
            when(dispositivo.conectarSensorSonido()).thenReturn(true);

            boolean resultado = ronqi2.reconectar();

            verify(dispositivo, times(1)).conectarSensorPresion();
            verify(dispositivo, times(0)).conectarSensorSonido();
            assertFalse(resultado);
        }

        @DisplayName("El metodo reconectar debe devolver false si no se conecta el sensor de sonido")
        @Test
        public void Reconectar_NoConectaSonido_DevuelveFalse() {
            when(dispositivo.estaConectado()).thenReturn(false);
            when(dispositivo.conectarSensorPresion()).thenReturn(true);
            when(dispositivo.conectarSensorSonido()).thenReturn(false);

            boolean resultado = ronqi2.reconectar();

            verify(dispositivo, times(1)).conectarSensorPresion();
            verify(dispositivo, times(1)).conectarSensorSonido();
            assertFalse(resultado);
        }

        @DisplayName("El metodo reconectar debe devolver false si no se conecta ni el sensor de presion ni el sensor de sonido")
        @Test
        public void Reconectar_NoConectaNiPresionNiSonido_DevuelveFalse() {
            when(dispositivo.estaConectado()).thenReturn(false);
            when(dispositivo.conectarSensorPresion()).thenReturn(false);
            when(dispositivo.conectarSensorSonido()).thenReturn(false);

            boolean resultado = ronqi2.reconectar();

            assertFalse(resultado);
        }

    }

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

    @Nested
    @DisplayName("metodo evaluarApneaSuenyo")
    class evaluarApneaSuenyo {

        @DisplayName("El método evaluarApneaSuenyo debe devolver false si media de las lecturas son nomales")
        @ParameterizedTest
        @ValueSource(ints = { 1, 2, 3, 4, 5, 10 })
        public void EvaluarApneaSuenyo_ConstantesNormales_DevuelveFalse(int n) {
            when(dispositivo.leerSensorPresion()).thenReturn(15f);
            when(dispositivo.leerSensorSonido()).thenReturn(20f);
            for (int i = 0; i < n; i++)
                ronqi2.obtenerNuevaLectura();

            boolean result = ronqi2.evaluarApneaSuenyo();

            assertFalse(result);
        }

        @DisplayName("El método evaluarApneaSuenyo debe devolver true si la media de las lecturas es mayor o igual al umbral establecido")
        @ParameterizedTest
        @ValueSource(ints = { 1, 2, 3, 4, 5, 10 })
        public void EvaluarApneaSuenyo_ConstantesAltas_DevuelveTrue(int n) {
            when(dispositivo.leerSensorPresion()).thenReturn(25f);
            when(dispositivo.leerSensorSonido()).thenReturn(34f);
            for (int i = 0; i < n; i++)
                ronqi2.obtenerNuevaLectura();

            boolean result = ronqi2.evaluarApneaSuenyo();

            assertTrue(result);

        }

        @DisplayName("El método evaluarApneaSuenyo debe devolver false si no se ha realizado ninguna lectura")
        @Test
        public void EvaluarApneaSuenyo_SinLecturas_DevuelveFalse() {
            boolean result = ronqi2.evaluarApneaSuenyo();

            assertFalse(result);
        }

        @DisplayName("El método evaluarApneaSuenyo debe devolver false si la media de las lecturas de sonido es menor al umbral establecido")
        @Test
        public void EvaluarApneaSuenyo_PresionAltaSonidoBajo_DevuelveFalse() {
            when(dispositivo.leerSensorPresion()).thenReturn(30f);
            when(dispositivo.leerSensorSonido()).thenReturn(28f);
            ronqi2.obtenerNuevaLectura();
            when(dispositivo.leerSensorPresion()).thenReturn(19f);
            when(dispositivo.leerSensorSonido()).thenReturn(26f);
            ronqi2.obtenerNuevaLectura();
            when(dispositivo.leerSensorPresion()).thenReturn(38f);
            when(dispositivo.leerSensorSonido()).thenReturn(15f);
            ronqi2.obtenerNuevaLectura();

            boolean result = ronqi2.evaluarApneaSuenyo();

            assertFalse(result);
        }

        @DisplayName("El método evaluarApneaSuenyo debe devolver false si la media de las lecturas de presion es menor al umbral establecido")
        @Test
        public void EvaluarApneaSuenyo_PresionBajaSonidoAlta_DevuelveFalse() {
            when(dispositivo.leerSensorPresion()).thenReturn(10f);
            when(dispositivo.leerSensorSonido()).thenReturn(38f);
            ronqi2.obtenerNuevaLectura();
            when(dispositivo.leerSensorPresion()).thenReturn(29f);
            when(dispositivo.leerSensorSonido()).thenReturn(26f);
            ronqi2.obtenerNuevaLectura();
            when(dispositivo.leerSensorPresion()).thenReturn(18f);
            when(dispositivo.leerSensorSonido()).thenReturn(35f);
            ronqi2.obtenerNuevaLectura();

            boolean result = ronqi2.evaluarApneaSuenyo();

            assertFalse(result);
        }

    }

    @Nested
    @DisplayName("metodo estaConectado")
    class estaConectado {
        @DisplayName("El metodo estaConectado debe devolver true si el dispositivo esta conectado")
        @Test
        public void EstaConectado_DispositivoConectado_DevuelveTrue() {
            when(dispositivo.estaConectado()).thenReturn(true);

            boolean resultado = ronqi2.estaConectado();

            assertTrue(resultado);
        }

        @DisplayName("El metodo estaConectado debe devolver false si el dispositivo no esta conectado")
        @Test
        public void EstaConectado_DispositivoNoConectado_DevuelveFalse() {
            when(dispositivo.estaConectado()).thenReturn(false);

            boolean resultado = ronqi2.estaConectado();

            assertFalse(resultado);
        }

    }

    @Nested
    @DisplayName("metodo anyadirDispositivos")
    class anyadirDispositivos {
        @DisplayName("El metodo anyadirDispositivo debe asignar el dispositivo pasado como parametro si el dispositivo es correcto")
        @Test
        public void AnyadirDispositivo_DispositivoCorrecto_AsignaDispositivo() {
            Dispositivo d = mock(Dispositivo.class);

            ronqi2.anyadirDispositivo(d);
            boolean result = ronqi2.disp == d;

            assertTrue(result);
        }

        @DisplayName("El metodo anyadirDispositivo debe lanzar una excepcion si el dispositivo es nulo")
        @Test
        public void AnyadirDispositivo_DispositivoNulo_LanzaExcepcion() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                ronqi2.anyadirDispositivo(null);
            });
        }
    }

    @Nested
    @DisplayName("metodo obtenerNuevaLectura")
    class obtenerNuevaLectura {
        @DisplayName("El metodo obtenerNuevaLectura debe llamar al metodo leerSensorPresion y leerSensorSonido")
        @Test
        public void ObtenerNuevaLectura_AnyadeLectura() {
            when(dispositivo.leerSensorPresion()).thenReturn(20f);
            when(dispositivo.leerSensorSonido()).thenReturn(30f);

            ronqi2.obtenerNuevaLectura();

            verify(dispositivo, times(1)).leerSensorPresion();
            verify(dispositivo, times(1)).leerSensorSonido();
        }

    }
}
