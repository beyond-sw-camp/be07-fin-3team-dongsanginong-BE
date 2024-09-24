package org.samtuap.inong.domain.product.api;

import lombok.RequiredArgsConstructor;
import org.samtuap.inong.common.exception.BaseCustomException;
import org.samtuap.inong.domain.product.dto.*;
import org.samtuap.inong.domain.product.service.PackageProductService;
import org.samtuap.inong.domain.product.dto.TopPackageGetResponse;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.samtuap.inong.common.exceptionType.ProductExceptionType.PRODUCT_NOT_FOUND;


@RequiredArgsConstructor
@RequestMapping("/product")
@RestController
public class PackageProductController {
    private final PackageProductService packageProductService;
    @GetMapping
    public String testApi() {
        return "product-test!!";
    }

    @GetMapping("/test")
    public void exceptionTest() {
        throw new BaseCustomException(PRODUCT_NOT_FOUND);
    }

    @GetMapping("/top10")
    public List<TopPackageGetResponse> getTopPackages() {
        return packageProductService.getTopPackages();
    }

    //  Feign 요청용 메서드
    @GetMapping("/info/{id}")
    public PackageProductResponse getPackageProduct(@PathVariable("id") Long packageProductId) {
        return packageProductService.getProductInfo(packageProductId);
    }

    @PostMapping("/create")
    public ResponseEntity<PackageProductCreateResponse> createProduct(@RequestBody PackageProductCreateRequest request) {
        PackageProductCreateResponse packageProductCreateResponse = packageProductService.createPackageProduct(request);
        return ResponseEntity.ok(packageProductCreateResponse);
    }

    @GetMapping("/product/info")
    List<PackageProductResponse> getPackageProductList(@RequestBody List<Long> ids) {
        return packageProductService.getProductInfoList(ids);
    }

    //  Feign 요청용 메서드
    @PostMapping("/subscription/list")
    public List<PackageProductSubsResponse> getProductSubsList(@RequestBody List<Long> subscriptionIds){
        return packageProductService.getProductSubsList(subscriptionIds);
    }
}
