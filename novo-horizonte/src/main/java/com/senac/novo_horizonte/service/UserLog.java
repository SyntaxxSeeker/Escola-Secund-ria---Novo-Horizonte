package com.senac.novo_horizonte.service;

import lombok.Data;

@Data
public class UserLog {
    private static boolean acessoLog = false;

    public static boolean acesso(boolean get){
        acessoLog = get;
        return acessoLog;
    }
}
