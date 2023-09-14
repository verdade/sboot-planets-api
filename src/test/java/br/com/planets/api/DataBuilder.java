package br.com.planets.api;

import br.com.planets.api.domain.Planet;

public class DataBuilder {

    public static Planet getAudit() {
        return Planet.builder()
                .id(1L)
//                .actionType("ACTIONTYPE")
//                .archive(new byte[10])
//                .branchId("branchId")
//                .branchName("branchName")

                .build();
    }
}
