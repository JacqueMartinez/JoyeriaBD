/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstherModelo;

/**
 *
 * @author Esther
 */
public class Login {
    String idN;
    String nivel;

    public Login(String idN, String nivel) {
        this.idN = idN;
        this.nivel = nivel;
    }

    public String getIdN() {
        return idN;
    }

    public void setIdN(String idN) {
        this.idN = idN;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    
}
