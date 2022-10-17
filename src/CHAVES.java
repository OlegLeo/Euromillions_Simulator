import com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolverSpi;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;
import static javax.swing.UIManager.get;


public class CHAVES {

    //ATRIBUTOS
    private int nr1, nr2, nr3, nr4, nr5, e1, e2;


    //CONSTRUTOR
    public CHAVES() {
        nr1 = 0;
        nr2 = 0;
        nr3 = 0;
        nr4 = 0;
        nr5 = 0;
        e1 = 0;
        e2 = 0;
    }


    public CHAVES(int nr1, int nr2, int nr3, int nr4, int nr5, int e1, int e2) {
        this.nr1 = nr1;
        this.nr2 = nr2;
        this.nr3 = nr3;
        this.nr4 = nr4;
        this.nr5 = nr5;
        this.e1 = e1;
        this.e2 = e2;
    }



    public int getNr1() {
        return nr1;
    }

    public void setNr1(int nr1) {
        this.nr1 = nr1;
    }

    public int getNr2() {
        return nr2;
    }

    public void setNr2(int nr2) {
        this.nr2 = nr2;
    }

    public int getNr3() {
        return nr3;
    }

    public void setNr3(int nr3) {
        this.nr3 = nr3;
    }

    public int getNr4() {
        return nr4;
    }

    public void setNr4(int nr4) {
        this.nr4 = nr4;
    }

    public int getNr5() {
        return nr5;
    }

    public void setNr5(int nr5) {
        this.nr5 = nr5;
    }

    public int getE1() {
        return e1;
    }

    public void setE1(int e1) {
        this.e1 = e1;
    }

    public int getE2() {
        return e2;
    }

    public void setE2(int e2) {
        this.e2 = e2;
    }

    @Override

    //IMPLEMENTAÇÃO DO METODO equals()

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof CHAVES)) {
            return false;
        }

        CHAVES c = (CHAVES) o;

        return Integer.compare(nr1, c.nr1) == 0
                && Integer.compare(nr2, c.nr2) == 0 && Integer.compare(nr3, c.nr3) == 0 && Integer.compare(nr4, c.nr4) == 0
                && Integer.compare(nr5, c.nr5) == 0 && Integer.compare(e1, c.e1) == 0 && Integer.compare(e2, c.e2) == 0;
    }
    //RETORNO DE LISTA DE OBJETO EM STRING PERSONALIZADA
    public String toString() {
        return  "Números: ("+ nr1 + ") " + "("+ nr2 + ") "+"("+ nr3 + ") "+"("+ nr4 + ") "+"("+ nr5 + ")\n" + "Estrelas: ("+ e1 + ")"+" ("+ e2 + ")";
    }



}
