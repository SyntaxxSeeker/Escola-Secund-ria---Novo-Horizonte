package com.senac.novo_horizonte.service;

import lombok.Data;

@Data
public class UserLog {
    private static boolean acessoLog = false;

    public static boolean atualizarAcesso(boolean get){
        acessoLog = get;
        return acessoLog;
    }

    public static boolean getAcesso(){
        return acessoLog;
    }
}
