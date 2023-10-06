// package com.team.back.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.team.back.service.SalesService;

// import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/sales")
// @RequiredArgsConstructor
// public class SalesController {

//   private final SalesService salesService;
  
//   // API: 판매계획 목록 조회 메서드 //
//   @GetMapping("/sales-plan/{salesPlanCode}")
//   public ResponseEntity<?> getSalesPlanList(
//     @PathVariable(value="salesPlanCode", required=true) Integer salesPlanCode
//   ) {
//     ResponseEntity<?> response = salesService.getSalesPlanDetail(salesPlanCode);
//     return response;
//   }


// }
