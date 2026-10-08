package kz.iitu.spring_lab_01.controller;

import kz.iitu.spring_lab_01.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lab4")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/item/{id}")
    public String findById(@PathVariable Long id) {
        return catalogService.findById(id);
    }

    @GetMapping("/items")
    public List<String> findAll(
            @RequestParam(defaultValue = "5") int limit) {
        return catalogService.findAll(limit);
    }

    @DeleteMapping("/item/{id}")
    public String remove(@PathVariable Long id) {
        return catalogService.remove(id);
    }

    @GetMapping("/proxy")
    public String proxy() {
        return catalogService.getClass().getName();
    }

    @DeleteMapping("/remove-twice/{id}")
    public String removeTwice(@PathVariable Long id) {
        catalogService.remove(id);
        return catalogService.remove(id);
    }
}