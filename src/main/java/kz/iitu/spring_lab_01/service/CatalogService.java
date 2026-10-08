package kz.iitu.spring_lab_01.service;

import kz.iitu.spring_lab_01.audit.Audited;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogService {

    @Audited(action = "CATALOG_LIST", logArguments = true)
    public List<String> findAll(int limit) {
        List<String> items = new ArrayList<>();

        for (int i = 1; i <= limit; i++) {
            items.add("Item-" + i);
        }

        return items;
    }

    public String findById(Long id) {
        return "Item-" + id;
    }

    @Audited(action = "CATALOG_REMOVE", logArguments = true)
    public String remove(Long id) {
        return "Removed item " + id;
    }

    public String proxyInfo() {
        return "CatalogService";
    }
}