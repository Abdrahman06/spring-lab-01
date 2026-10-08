package kz.iitu.spring_lab_01.service;

import kz.iitu.spring_lab_01.audit.Audited;
import org.springframework.stereotype.Service;
import org.springframework.aop.framework.AopContext;

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
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return items;
    }

    public String findById(Long id) {
        return "Item-" + id;
    }

    @Audited(action = "CATALOG_REMOVE", logArguments = true)
    public String remove(Long id) {
        if (id == 0) {
            throw new IllegalArgumentException("Item id cannot be 0");
        }

        return "Removed item " + id;
    }
    public String removeTwice(Long id) {
        CatalogService proxy = (CatalogService) AopContext.currentProxy();

        String first = proxy.remove(id);
        String second = proxy.remove(id);

        return first + " | " + second;
    }
    public String proxyInfo() {
        return "CatalogService";
    }
}