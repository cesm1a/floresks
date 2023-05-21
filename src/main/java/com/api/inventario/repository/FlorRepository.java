package com.api.inventario.repository;
import com.api.inventario.model.Flor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlorRepository {
    public static List<Flor> flores = new ArrayList<>();

    public static void addFlores(List<Flor> flor) {
        flores.addAll(flor);
    }


    public static void deleteFlores(int id) {
        for (int i = 0; i < flores.size(); i++) {
            if (flores.get(i).getId() == id) {
                flores.remove(i);
                break;
            }
        }
    }

    public static List<Flor> getFloresByName(String n) {
        List<Flor> sflores = new ArrayList<>();
        for (Flor f : flores) {
            if (f.getName().equals(n)) {
                sflores.add(f);
            }
        }
        return sflores;
    }

    public static List<Flor> getFloresOrderDesc() {
        flores.sort(Comparator.comparing(Flor::getName).reversed());
        for (Flor flor : flores) {
            String nameKometsales = flor.getName() + "-kometsales";
            flor.setName(nameKometsales);
        }
        return flores;
    }

    public static List<Flor> getFloresByPrice() {
        List<Flor> floresPrice = new ArrayList<>();
        for (Flor f : flores) {
            if (f.getPrice()>20) {
                floresPrice.add(f);
            }
        }
        return floresPrice;
    }

    public static List<Flor> getAllFlores() {
        return flores;
    }
}
