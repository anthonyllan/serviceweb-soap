package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * Servicio web para realizar operaciones básicas de una calculadora.
 * @author xlecd
 */
@WebService(serviceName = "CalculadoraWS")
public class CalculadoraWS {

    private int contadorOperaciones;
    
    public CalculadoraWS() {
        this.contadorOperaciones = 0;
    }
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Suma dos números enteros.
     * @param a Primer número.
     * @param b Segundo número.
     * @return La suma de a y b.
     */
    @WebMethod(operationName = "sumar")
    public int sumar(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        contadorOperaciones++;
        return a + b;
    }

    /**
     * Resta dos números enteros.
     * @param a Primer número.
     * @param b Segundo número.
     * @return La resta de a y b.
     */
    @WebMethod(operationName = "restar")
    public int restar(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        contadorOperaciones++;
        return a - b;
    }

    /**
     * Multiplica dos números enteros.
     * @param a Primer número.
     * @param b Segundo número.
     * @return El producto de a y b.
     */
    @WebMethod(operationName = "multiplicar")
    public int multiplicar(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        contadorOperaciones++;
        return a * b;
    }

    /**
     * Divide dos números enteros.
     * @param a Primer número.
     * @param b Segundo número.
     * @return El cociente de a y b.
     * @throws IllegalArgumentException Si el divisor es cero.
     */
    @WebMethod(operationName = "dividir")
    public int dividir(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        contadorOperaciones++;
        if (b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        }
        return a / b;
    }

    /**
     * Obtiene el número de operaciones realizadas.
     * @return El contador de operaciones.
     */
    @WebMethod(operationName = "getContadorPeticiones")
    public int getContadorPeticiones() {
        return this.contadorOperaciones;
    }
}
